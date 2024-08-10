package gui.pagamentoSimples.pagamentoSimples.Services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import gui.pagamentoSimples.pagamentoSimples.DTO.ApiRequestDTO;
import gui.pagamentoSimples.pagamentoSimples.DTO.TransactionInputDTO;
import gui.pagamentoSimples.pagamentoSimples.DTO.TransactionOutputDTO;
import gui.pagamentoSimples.pagamentoSimples.Models.Transaction;
import gui.pagamentoSimples.pagamentoSimples.Models.User;
import gui.pagamentoSimples.pagamentoSimples.Repositories.TransactionRepository;
import gui.pagamentoSimples.pagamentoSimples.Repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class TransactionService {
    
    @Autowired
    TransactionRepository repository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    NotificationService notificationService;

    @Transactional
    public TransactionOutputDTO create(TransactionInputDTO dto){
        
        User payer = userRepository.findById(dto.payer().id()).get();
        User payee = userRepository.findById(dto.payee().id()).get();
        Transaction transaction = TransactionInputDTOtoTransaction(dto);
        Transaction transaction2 = new Transaction();
        Double value = transaction.getValue();

        List<User> users = new ArrayList<>();
        String url = "https://util.devi.tools/api/v2/authorize";
        
        if(!payer.getClass().getSimpleName().equals("MerchantUser") && payer.getBalance() >= dto.value() && payee.getId() != null && checkPayment(url)){
                transaction2 = repository.save(transaction);
                TransactionOutputDTO res = new TransactionOutputDTO(transaction2.getValue(), transaction2.getPayer().getId(), transaction2.getPayee().getId());
                payer.setBalance( payer.getBalance() - value);
                payee.setBalance(payee.getBalance() + value);
                userRepository.saveAll(users);
                Boolean notificationResponse = notificationService.sendEmailOrSms();
                if(notificationResponse){
                    return res;
                }else{
                    return null;
                }
        }else{
            return null;
        }

    }

    public Transaction TransactionInputDTOtoTransaction(TransactionInputDTO dto){
        Transaction transaction = new Transaction();
        User payer = new User(dto.payer());
        User payee = new User(dto.payee());

        transaction.setId(dto.id());
        transaction.setPayee(payer);
        transaction.setPayer(payee);
        transaction.setValue(dto.value());
        return transaction;
    }
    
    public Boolean checkPayment(String url){
        try {
            HttpClient http = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(url)).build();
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            ApiRequestDTO dto = mapper.readValue(response.body(), ApiRequestDTO.class);
            
            return dto.getData().isAuthorization();
            
        } catch (Exception e) {
            return false;
        }
    }
}

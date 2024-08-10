package gui.pagamentoSimples.pagamentoSimples.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import gui.pagamentoSimples.pagamentoSimples.DTO.ApiRequestDTO;
import gui.pagamentoSimples.pagamentoSimples.DTO.NotificationDTO;

@Service
public class NotificationService {
    
    private String url = "https://util.devi.tools/api/v1/notify";
    public Boolean sendEmailOrSms(){

            try {
            HttpClient http = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(this.url))
                                    .POST(HttpRequest.BodyPublishers.noBody()).build();
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            
            ObjectMapper mapper = new ObjectMapper();
            NotificationDTO dto = mapper.readValue(response.body(), NotificationDTO.class);
            if(dto.getStatus() == "error"){
                return false;
            }else{
                return true;
            }
            
        } catch (Exception e) {
            return false;
        }
    }
}

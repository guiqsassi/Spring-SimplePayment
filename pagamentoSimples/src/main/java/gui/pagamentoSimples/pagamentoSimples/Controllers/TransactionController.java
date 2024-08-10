package gui.pagamentoSimples.pagamentoSimples.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gui.pagamentoSimples.pagamentoSimples.DTO.TransactionInputDTO;
import gui.pagamentoSimples.pagamentoSimples.Models.Transaction;
import gui.pagamentoSimples.pagamentoSimples.Services.TransactionService;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
    
    @Autowired
    TransactionService service;

    @PostMapping
    public ResponseEntity create(@RequestBody TransactionInputDTO dto){

        var transaction = service.create(dto);
        //Transaction transaction = new Transaction();
        if(transaction == null){
            var res = new ResponseEntity<>("Transação não autorizada",null, 400);
            return res;
        }
            
            var res = new ResponseEntity<>(transaction,null, 201);
            return res;
      

    }
}

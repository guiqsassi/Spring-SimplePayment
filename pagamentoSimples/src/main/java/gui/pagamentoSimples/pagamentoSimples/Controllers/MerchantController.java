package gui.pagamentoSimples.pagamentoSimples.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gui.pagamentoSimples.pagamentoSimples.DTO.MerchantUserInputDTO;
import gui.pagamentoSimples.pagamentoSimples.Models.MerchantUser;
import gui.pagamentoSimples.pagamentoSimples.Services.MerchantUserService;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    
    @Autowired
    MerchantUserService service;

    
    @PostMapping
    public ResponseEntity create(@RequestBody MerchantUserInputDTO dto) {
        
        MerchantUser merchantUser = new MerchantUser();
        merchantUser = service.create(dto);
        ResponseEntity<MerchantUser> res = new ResponseEntity<MerchantUser>(merchantUser, null, 201);
        return res;
    }

    @GetMapping
    public ResponseEntity list() {

        List<MerchantUser> MerchantUsers = new ArrayList<MerchantUser>();

        MerchantUsers = service.list();

        var res = new ResponseEntity<List<MerchantUser>>(MerchantUsers, null, 200);
        return res;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        
        MerchantUser merchantUser = new MerchantUser();
        merchantUser = service.read(id);

        var res = new ResponseEntity<>(merchantUser, null, 200);
        return res;

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        
        service.delete(id);

        var res = new ResponseEntity(null, null, 204);
        return res;

    }

    @PutMapping
    public ResponseEntity update (@RequestBody MerchantUserInputDTO dto) {
        MerchantUser merchantUser = new MerchantUser();
        
        merchantUser = service.update(dto);
        var res = new ResponseEntity<>(merchantUser, null,200);


        return res;
    }
    
}

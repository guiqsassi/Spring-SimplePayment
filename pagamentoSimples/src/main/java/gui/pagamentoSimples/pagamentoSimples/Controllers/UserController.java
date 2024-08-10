package gui.pagamentoSimples.pagamentoSimples.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gui.pagamentoSimples.pagamentoSimples.DTO.UserInputDTO;
import gui.pagamentoSimples.pagamentoSimples.Models.User;
import gui.pagamentoSimples.pagamentoSimples.Services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    
      
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity create(@RequestBody UserInputDTO dto) {
        
        User user = new User();
        user = service.create(dto);
        ResponseEntity<User> res = new ResponseEntity<User>(user, null, 201);
        return res;
    }

    @GetMapping
    public ResponseEntity list() {

        List<User> Users = new ArrayList<User>();

        Users = service.list();

        var res = new ResponseEntity<List<User>>(Users, null, 200);
        return res;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        
        User user = new User();
        user = service.read(id);

        var res = new ResponseEntity<>(user, null, 200);
        return res;

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        
        service.delete(id);

        var res = new ResponseEntity(null, null, 204);
        return res;

    }

    @PutMapping
    public ResponseEntity update (@RequestBody UserInputDTO dto) {
        User user = new User();
        
        user = service.update(dto);
        var res = new ResponseEntity<>(user, null,200);


        return res;
    }
    
}

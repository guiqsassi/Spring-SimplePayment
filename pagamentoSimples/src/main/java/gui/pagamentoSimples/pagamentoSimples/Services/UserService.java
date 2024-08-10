package gui.pagamentoSimples.pagamentoSimples.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gui.pagamentoSimples.pagamentoSimples.DTO.UserInputDTO;
import gui.pagamentoSimples.pagamentoSimples.Models.User;
import gui.pagamentoSimples.pagamentoSimples.Repositories.UserRepository;

@Service
public class UserService{
    @Autowired
    UserRepository repository;

    public User create(UserInputDTO dto){
        User userCreate = new User(dto);

        return repository.save(userCreate);
    }

    public User read(Long id){
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }else{
            return null;
        }
    }
    
    public List<User> list(){
        return repository.findAll();
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(UserInputDTO dto){
        User userCreate = new User(dto);

        if(userCreate.getId() != null){
            return repository.save(userCreate);
        }else{
            return null;
        }

    }


}
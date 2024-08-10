package gui.pagamentoSimples.pagamentoSimples.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gui.pagamentoSimples.pagamentoSimples.DTO.MerchantUserInputDTO;
import gui.pagamentoSimples.pagamentoSimples.Models.MerchantUser;
import gui.pagamentoSimples.pagamentoSimples.Repositories.MerchantUserRepository;

@Service
public class MerchantUserService {
    @Autowired
    MerchantUserRepository repository;

    public MerchantUser create(MerchantUserInputDTO dto){
        MerchantUser merchantUserCreate = MerchantUserInputDTOtoMerchantUser(dto);

        return repository.save(merchantUserCreate);
    }

    public MerchantUser read(Long id){
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }else{
            return null;
        }
    }
    
    public List<MerchantUser> list(){
        return repository.findAll();
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }

    public MerchantUser update(MerchantUserInputDTO dto){
        MerchantUser merchantUserCreate = MerchantUserInputDTOtoMerchantUser(dto);

        if(merchantUserCreate.getId() != null){
            return repository.save(merchantUserCreate);
        }else{
            return null;
        }
    }

    public MerchantUser MerchantUserInputDTOtoMerchantUser(MerchantUserInputDTO dto){
        MerchantUser merchantUser = new MerchantUser();
        merchantUser.setId(dto.id());
        merchantUser.setEmail(dto.email());
        merchantUser.setPassword(dto.password());
        merchantUser.setCNPJ(dto.CNPJ());
        merchantUser.setCPF(dto.CPF());
        merchantUser.setBalance(dto.balance());
        return merchantUser;
    }
}

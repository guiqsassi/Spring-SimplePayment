package gui.pagamentoSimples.pagamentoSimples.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gui.pagamentoSimples.pagamentoSimples.Models.MerchantUser;

public interface MerchantUserRepository extends JpaRepository<MerchantUser, Long>{
    
}

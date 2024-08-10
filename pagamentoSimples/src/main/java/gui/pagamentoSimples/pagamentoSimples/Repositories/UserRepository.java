package gui.pagamentoSimples.pagamentoSimples.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gui.pagamentoSimples.pagamentoSimples.Models.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}

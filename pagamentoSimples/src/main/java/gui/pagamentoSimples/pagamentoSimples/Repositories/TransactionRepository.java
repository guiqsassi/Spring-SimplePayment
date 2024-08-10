package gui.pagamentoSimples.pagamentoSimples.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gui.pagamentoSimples.pagamentoSimples.Models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}

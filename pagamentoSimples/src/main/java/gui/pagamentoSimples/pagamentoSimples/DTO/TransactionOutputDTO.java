package gui.pagamentoSimples.pagamentoSimples.DTO;

import gui.pagamentoSimples.pagamentoSimples.Models.User;

public record TransactionOutputDTO(
    Double value,
    Long payer,
    Long payee
) {
    
    public void TransactionOutputDTO(Double value, Long payer, Long payee){
        this.TransactionOutputDTO(value, payer, payee);
    }
}

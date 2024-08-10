package gui.pagamentoSimples.pagamentoSimples.DTO;


public record TransactionInputDTO(
    Long id,
    UserInputDTO payer,
    UserInputDTO payee,
    Double value
) {
    public void TransactionInputDTO(Long id, UserInputDTO payer, UserInputDTO payee, Double value){
        this.TransactionInputDTO(id, payer, payee, value);
    }
}

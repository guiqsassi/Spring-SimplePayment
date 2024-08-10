package gui.pagamentoSimples.pagamentoSimples.DTO;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record MerchantUserInputDTO(
    Long id,
    @Email
    String email,
    String password,
    @org.hibernate.validator.constraints.br.CNPJ
    String CNPJ,
    @CPF
    String CPF,
    @NotNull
    Double balance
) {
    void MerchantUserInputDTO(Integer id, String email, String password, String CNPJ, String CPF, Double balance){
        this.MerchantUserInputDTO(id, email, password, CNPJ, CPF, balance);
    }
}

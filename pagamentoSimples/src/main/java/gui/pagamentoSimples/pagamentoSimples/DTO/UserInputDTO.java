package gui.pagamentoSimples.pagamentoSimples.DTO;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserInputDTO(
    Long id,
    @Email
    String email,
    @NotBlank
    String password,
    @CPF
    String CPF,
    @NotNull
    Double balance
) {
    void UserInputDTO(Integer id, String email, String password, String cpf, Double balance){
        this.UserInputDTO(id, email, password, cpf, balance);
    }
}

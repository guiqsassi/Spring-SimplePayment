package gui.pagamentoSimples.pagamentoSimples.Models;

import jakarta.persistence.GenerationType;
import gui.pagamentoSimples.pagamentoSimples.DTO.UserInputDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private Double balance;
    @Column(unique = true, length = 11)
    private String CPF;


    public User(UserInputDTO dto){
        this.setId(dto.id());
        this.setCPF(dto.CPF());
        this.setEmail(dto.email());
        this.setPassword(dto.password());
        this.setBalance(dto.balance());
      
    }
}

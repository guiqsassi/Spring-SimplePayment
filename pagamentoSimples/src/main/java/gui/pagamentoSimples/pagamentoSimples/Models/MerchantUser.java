package gui.pagamentoSimples.pagamentoSimples.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class MerchantUser extends User{
    @Column(unique = true, length = 14)
    private String CNPJ;
}

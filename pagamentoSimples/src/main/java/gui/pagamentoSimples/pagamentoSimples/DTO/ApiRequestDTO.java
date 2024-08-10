package gui.pagamentoSimples.pagamentoSimples.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ApiRequestDTO {
    private String status;
    private dataDTO data;
}


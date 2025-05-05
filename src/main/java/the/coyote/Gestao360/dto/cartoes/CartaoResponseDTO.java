package the.coyote.Gestao360.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartaoResponseDTO {

    private String numeroCartao;
    private String dataVencimento;
    private BigDecimal limite;
    private BigDecimal saldo;
    private int diaVencimento;
    private String contaCorrenteNumero;
    private String createdBy;
    private String createdAt;

}
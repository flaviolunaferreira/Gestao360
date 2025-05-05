package the.coyote.Gestao360.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartaoRequestDTO {

    @NotBlank(message = "O número do cartão não pode estar em branco")
    private String numeroCartao;

    @NotBlank(message = "A data de vencimento não pode estar em branco")
    @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{4}$", message = "A data de vencimento deve estar no formato MM/yyyy")
    private String dataVencimento;

    @NotNull(message = "O limite não pode ser nulo")
    @PositiveOrZero(message = "O limite deve ser maior ou igual a zero")
    private BigDecimal limite;

    @NotNull(message = "O saldo não pode ser nulo")
    @PositiveOrZero(message = "O saldo deve ser maior ou igual a zero")
    private BigDecimal saldo;

    @NotNull(message = "O dia de vencimento não pode ser nulo")
    @Min(value = 1, message = "O dia de vencimento deve ser entre 1 e 31")
    @Max(value = 31, message = "O dia de vencimento deve ser entre 1 e 31")
    private int diaVencimento;

    @NotBlank(message = "O número da conta corrente não pode estar em branco")
    private String contaCorrenteNumero;

}
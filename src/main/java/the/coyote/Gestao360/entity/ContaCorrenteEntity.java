package the.coyote.Gestao360.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.*;
import the.coyote.Gestao360.enumeration.TipoConta;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContaCorrenteEntity extends BasicEntity {

    @Id
    @NotBlank(message = "O número da conta não pode estar em branco")
    private String numero;

    @NotNull(message = "A data de abertura não pode ser nula")
    private LocalDate dataAbertura;

    private LocalDate dataUltimoLancamento;

    @NotNull(message = "O banco associado não pode ser nulo")
    @ManyToOne
    private BancoEntity banco;

    @NotNull(message = "O tipo de conta não pode ser nulo")
    private TipoConta tipoConta;

    @NotBlank(message = "A agência não pode estar em branco")
    private String agencia;

    @NotBlank(message = "O nome do titular não pode estar em branco")
    private String titular;

    @NotBlank(message = "O CPF/CNPJ do titular não pode estar em branco")
    private String cpfCnpjTitular;

    private BigDecimal saldo;

    @PositiveOrZero(message = "O limite não pode ser negativo")
    private BigDecimal limite;

    public ContaCorrenteEntity(String numero, LocalDate dataAbertura, BancoEntity banco, TipoConta tipoConta,  String agencia,  String titular, String cpfCnpjTitular, BigDecimal saldo, BigDecimal limite) {
        this.setNumero(numero);
        this.setDataAbertura(dataAbertura);
        this.setDataUltimoLancamento(dataUltimoLancamento);
        this.setBanco(banco);
        this.setTipoConta(tipoConta);
        this.setAgencia(agencia);
        this.setTitular(titular);
        this.setCpfCnpjTitular(cpfCnpjTitular);
        this.setSaldo(saldo);
        this.setLimite(limite);
    }
}
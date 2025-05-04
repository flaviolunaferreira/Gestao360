package the.coyote.Gestao360.dto.conta;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.stereotype.Repository;
import the.coyote.Gestao360.entity.BancoEntity;
import the.coyote.Gestao360.entity.ContaCorrenteEntity;
import the.coyote.Gestao360.enumeration.TipoConta;
import the.coyote.Gestao360.repository.BancoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ContaCorrenteRequestDTO {

    @NotBlank(message = "O número da conta não pode estar em branco")
    private String numero;

    @NotNull(message = "A data de abertura não pode ser nula")
    private LocalDate dataAbertura;

    @NotNull(message = "O banco associado não pode ser nulo")
    private Long bancoId;

    @NotNull(message = "O tipo de conta não pode ser nulo")
    private TipoConta tipoConta;

    @NotBlank(message = "A agência não pode estar em branco")
    private String agencia;

    @NotBlank(message = "O nome do titular não pode estar em branco")
    private String titular;

    @NotBlank(message = "O CPF/CNPJ do titular não pode estar em branco")
    private String cpfCnpjTitular;

    @NotNull(message = "O saldo não pode ser nulo")
    private BigDecimal saldo;

    @NotNull(message = "O limite não pode ser nulo")
    @PositiveOrZero(message = "O limite não pode ser negativo")
    private BigDecimal limite;

    public ContaCorrenteEntity novaContaCorrente(BancoRepository bancoRepository) {
        BancoEntity banco = bancoRepository.findById(bancoId).get();
        return new ContaCorrenteEntity(
                numero, dataAbertura, banco, tipoConta, agencia, titular, cpfCnpjTitular, saldo, limite
        );
    }
}
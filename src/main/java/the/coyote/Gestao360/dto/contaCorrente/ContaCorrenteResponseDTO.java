package the.coyote.Gestao360.dto.conta;

import lombok.Data;
import the.coyote.Gestao360.entity.ContaCorrenteEntity;
import the.coyote.Gestao360.enumeration.TipoConta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ContaCorrenteResponseDTO {

    private String numero;
    private LocalDate dataAbertura;
    private LocalDate dataUltimoLancamento;
    private String bancoNome;
    private TipoConta tipoConta;
    private String agencia;
    private String titular;
    private String cpfCnpjTitular;
    private BigDecimal saldo;
    private BigDecimal limite;
    private String createdBy;
    private LocalDateTime createdAt;

    public ContaCorrenteResponseDTO(ContaCorrenteEntity entity) {
        this.setNumero(entity.getNumero());
        this.setDataAbertura(entity.getDataAbertura());
        this.setDataUltimoLancamento(entity.getDataUltimoLancamento());
        this.setBancoNome(entity.getBanco().getNome());
        this.setTipoConta(entity.getTipoConta());
        this.setAgencia(entity.getAgencia());
        this.setTitular(entity.getTitular());
        this.setCpfCnpjTitular(entity.getCpfCnpjTitular());
        this.setSaldo(entity.getSaldo());
        this.setLimite(entity.getLimite());
        this.setCreatedBy(entity.getCreatedBy());
        this.setCreatedAt(entity.getCreatedAt());
    }

}
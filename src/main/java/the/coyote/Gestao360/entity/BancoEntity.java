package the.coyote.Gestao360.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class BancoEntity extends BasicEntity {

    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @NotNull(message = "Nome do banco não pode ser nulo")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "Código ISPB do banco não pode ser nulo")
    @Column(nullable = false, unique = true)
    private String codigoISPB;

}
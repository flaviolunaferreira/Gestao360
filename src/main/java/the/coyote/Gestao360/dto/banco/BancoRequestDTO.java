package the.coyote.Gestao360.dto.banco;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BancoRequestDTO {

    @NotNull(message = "ID do banco não pode ser nulo")
    private Long id;

    @NotNull(message = "Nome do banco não pode ser nulo")
    private String nome;

    @NotNull(message = "Código ISPB do banco não pode ser nulo")
    private String codigoISPB;

}

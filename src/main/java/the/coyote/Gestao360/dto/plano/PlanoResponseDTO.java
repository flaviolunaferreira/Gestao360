package the.coyote.Gestao360.dto.plano;

import lombok.Data;
import the.coyote.Gestao360.dto.modulo.ModuloResponseDTO;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PlanoResponseDTO {

    private Long id;
    private String nome;
    private BigDecimal precoBasePorLoja;
    private Boolean gratuito;
    private Integer tempoDuracaoEmMeses;
    private List<ModuloResponseDTO> modulos;

}
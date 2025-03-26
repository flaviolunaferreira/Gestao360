package the.coyote.Gestao360.dto.plano;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PlanoRequestDTO {

    private String nome;
    private BigDecimal precoBasePorLoja;
    private Boolean gratuito;
    private Integer tempoDuracaoEmMeses;
    private List<Long> modulosIds;

}
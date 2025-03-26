package the.coyote.Gestao360.dto.modulo;

import lombok.Data;
import the.coyote.Gestao360.entity.ModuloEntity;

@Data
public class ModuloRequestDTO {

    private String nome;
    private Double percentualCusto; // Porcentagem do custo total do sistema

    public ModuloEntity newModulo() {
        return new ModuloEntity(nome, percentualCusto);
    }
}
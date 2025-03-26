package the.coyote.Gestao360.dto.loja;

import lombok.Data;

@Data
public class LojaRequestDTO {

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    private Long empresaId;
}
package the.coyote.Gestao360.dto.empresa;

import lombok.Data;

@Data
public class EmpresaRequestDTO {

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    private Long planoId;

}
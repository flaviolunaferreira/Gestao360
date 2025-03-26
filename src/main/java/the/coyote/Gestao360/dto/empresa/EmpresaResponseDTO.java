package the.coyote.Gestao360.dto.empresa;

import lombok.Data;

@Data
public class EmpresaResponseDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    private Long planoId; // ID do plano associado à empresa
}
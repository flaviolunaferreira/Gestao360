package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class LojaEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    private String endereco;
    private String telefone;
    private String email;

    @Column(nullable = false)
    private Integer quantidadeTerminais; // Número de terminais na loja

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaEntity empresa;
}
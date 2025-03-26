package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class EmpresaEntity extends BasicEntity {

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

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private PlanoEntity plano;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LojaEntity> lojas;

    @Column(nullable = false)
    private LocalDate dataInicio; // Data de início do plano
}
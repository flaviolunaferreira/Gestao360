package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ModuloEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private Double percentualCusto;

    @ManyToMany(mappedBy = "modulos")
    private List<PlanoEntity> planos;

    public ModuloEntity(String nome, Double percentualCusto) {
        this.nome = nome;
        this.percentualCusto = percentualCusto;
    }
}
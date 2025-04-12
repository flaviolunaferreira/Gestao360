package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import the.coyote.Gestao360.dto.config.FormField;

import java.util.List;


@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ModuloEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FormField(label = "Nome", required = true, minLength = 3, maxLength = 100, showInTable = true, filterable = true)
    @Column(nullable = false, unique = true)
    private String nome;

    @FormField(label = "Percentual de Custo", required = true, minLength = 1, maxLength = 10, showInTable = true, filterable = true)
    @Column(nullable = false)
    private Double percentualCusto;

    @ManyToMany(mappedBy = "modulos")
    private List<PlanoEntity> planos;

    public ModuloEntity(String nome, Double percentualCusto) {
        this.nome = nome;
        this.percentualCusto = percentualCusto;
    }
}
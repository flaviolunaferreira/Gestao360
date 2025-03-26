package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class PlanoEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private BigDecimal precoBasePorLoja;

    @Column(nullable = false)
    private Boolean gratuito; // Indica se o plano é gratuito

    private Integer tempoDuracaoEmMeses; // Prazo para planos promocionais

    @ManyToMany
    @JoinTable(
            name = "plano_modulo",
            joinColumns = @JoinColumn(name = "plano_id"),
            inverseJoinColumns = @JoinColumn(name = "modulo_id")
    )
    private List<ModuloEntity> modulos;
}
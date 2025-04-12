package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import the.coyote.Gestao360.dto.config.FormField;

import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class PlanoEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FormField(label = "Nome", required = true, minLength = 3, maxLength = 100)
    @Column(nullable = false, unique = true)
    private String nome;

    @FormField(label = "Descrição", required = true, minLength = 10, maxLength = 500)
    @Column(nullable = false)
    private BigDecimal precoBasePorLoja;

    @Column(nullable = false)
    @FormField(label = "Gratuito", required = true, minLength = 1, maxLength = 10)
    private Boolean gratuito; // Indica se o plano é gratuito

    @FormField(label = "Duração em Meses", required = false, minLength = 1, maxLength = 10)
    private Integer tempoDuracaoEmMeses; // Prazo para planos promocionais

    @ManyToMany
    @JoinTable(name = "plano_modulo", joinColumns = @JoinColumn(name = "plano_id"), inverseJoinColumns = @JoinColumn(name = "modulo_id"))
    private List<ModuloEntity> modulos;
}
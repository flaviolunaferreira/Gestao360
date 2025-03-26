package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PlanoModuloEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private PlanoEntity plano;

    @ManyToOne
    @JoinColumn(name = "modulo_id", nullable = false)
    private ModuloEntity modulo;

    @Column(nullable = false)
    private Double percentualCusto; // Porcentagem do custo para este plano
}
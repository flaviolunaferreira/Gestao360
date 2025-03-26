package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DescontoEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidadeMinimaLojas; // Número mínimo de lojas para aplicar o desconto

    @Column(nullable = false)
    private Double percentualDesconto; // Porcentagem de desconto
}
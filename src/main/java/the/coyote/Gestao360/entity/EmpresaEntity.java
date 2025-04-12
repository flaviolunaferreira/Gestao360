package the.coyote.Gestao360.entity;

import jakarta.persistence.*;
import lombok.Data;
import the.coyote.Gestao360.dto.config.FormField;
import the.coyote.Gestao360.enumeration.FieldType;
import the.coyote.Gestao360.service.impl.plano.PlanoOptionsProvider;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class EmpresaEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @FormField(label = "ID", showInForm = false, maxLength = 10)
    private Long id;

    @FormField(label = "Nome", required = true, minLength = 3, maxLength = 100)
    @Column(nullable = false)
    private String nome;

    @FormField(label = "CNPJ", required = true, minLength = 14, maxLength = 14, pattern = "\\d{14}", mascara = "99.999.999/9999-99")
    @Column(nullable = false, unique = true)
    private String cnpj;

    @FormField(label = "Endereço", maxLength = 200)
    private String endereco;

    @FormField(label = "Telefone", minLength = 10, maxLength = 15, pattern = "\\d{10,15}", mascara = "(99) 99999-9999", showInForm = true, showInTable = true)
    private String telefone;

    @FormField(label = "Email", required = true, maxLength = 100, pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", showInForm = true, showInTable = true)
    private String email;

    @FormField(label = "Plano", type = FieldType.SELECT, optionsProvider = PlanoOptionsProvider.class, maxLength = 50, showInForm = true, showInTable = true)
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private PlanoEntity plano;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LojaEntity> lojas;

    @Column(nullable = false)
    private LocalDate dataInicio;
}
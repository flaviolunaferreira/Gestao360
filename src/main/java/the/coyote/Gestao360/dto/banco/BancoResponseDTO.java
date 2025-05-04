package the.coyote.Gestao360.dto.banco;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BancoResponseDTO {
    private Long id;
    private String nome;
    private String codigoISPB;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
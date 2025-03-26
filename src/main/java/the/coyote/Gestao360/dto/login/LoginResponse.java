package the.coyote.Gestao360.dto.login;

import the.coyote.Gestao360.enumeration.UsuarioTipo;
import java.util.List;

public record LoginResponse(
        String token,
        String email,
        UsuarioTipo tipo,
        Long empresaId,
        List<String> modulos // Lista de módulos acessíveis
) {
    // Construtor simplificado para ADMIN
    public LoginResponse(String token, String email, UsuarioTipo tipo, Long empresaId) {
        this(token, email, tipo, empresaId, null);
    }
}
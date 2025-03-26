package the.coyote.Gestao360.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import the.coyote.Gestao360.dto.login.LoginRequest;
import the.coyote.Gestao360.dto.login.LoginResponse;
import the.coyote.Gestao360.entity.ModuloEntity;
import the.coyote.Gestao360.entity.UsuarioEntity;
import the.coyote.Gestao360.service.impl.JwtService;
import the.coyote.Gestao360.service.impl.UsuarioDetailsService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioDetailsService usuarioDetailsService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        UsuarioEntity usuario = (UsuarioEntity) usuarioDetailsService.loadUserByUsername(request.email());
        String jwtToken = jwtService.generateToken(usuario);

        return ResponseEntity.ok(new LoginResponse(
                jwtToken,
                usuario.getEmail(),
                usuario.getTipo(),
                usuario.getEmpresa() != null ? usuario.getEmpresa().getId() : null,
                usuario.getModulosLiberados().stream().map(ModuloEntity::getNome).toList()
        ));
    }
}
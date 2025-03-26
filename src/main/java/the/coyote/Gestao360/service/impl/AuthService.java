package the.coyote.Gestao360.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import the.coyote.Gestao360.dto.login.LoginRequest;
import the.coyote.Gestao360.dto.login.LoginResponse;
import the.coyote.Gestao360.entity.*;
import the.coyote.Gestao360.enumeration.UsuarioTipo;
import the.coyote.Gestao360.repository.ModuloRepository;
import the.coyote.Gestao360.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDetailsService userDetailsService;
    private final UsuarioRepository usuarioRepository;
    private final ModuloRepository moduloRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        UsuarioEntity usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow();

        String jwtToken = jwtService.generateToken(usuario);

        return new LoginResponse(
                jwtToken,
                usuario.getEmail(),
                usuario.getTipo(),
                usuario.getEmpresa() != null ? usuario.getEmpresa().getId() : null,
                usuario.getModulosLiberados().stream().map(ModuloEntity::getNome).toList()
        );
    }

    // Registro específico para ADMIN (você)
    public UsuarioEntity registrarAdmin(String email, String senha) {
        UsuarioEntity admin = UsuarioEntity.builder()
                .email(email)
                .senha(passwordEncoder.encode(senha))
                .tipo(UsuarioTipo.ADMIN)
                .modulosLiberados(moduloRepository.findAll()) // Acesso total
                .build();

        return usuarioRepository.save(admin);
    }
}
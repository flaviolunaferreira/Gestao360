package the.coyote.Gestao360.componentes;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;
import the.coyote.Gestao360.entity.UsuarioEntity;
import the.coyote.Gestao360.enumeration.UsuarioTipo;
import the.coyote.Gestao360.repository.UsuarioRepository;

@Configuration
@RequiredArgsConstructor
public class AdminUserInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!usuarioRepository.existsByEmail("thecoyote@gmail.com")) {
            UsuarioEntity admin = UsuarioEntity.builder()
                    .email("thecoyote@gmail.com")
                    .senha(passwordEncoder.encode("Chacal-301200"))
                    .tipo(UsuarioTipo.ADMIN)
                    .build();

            usuarioRepository.save(admin);
        }
    }
}
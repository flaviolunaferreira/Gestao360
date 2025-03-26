package the.coyote.Gestao360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.coyote.Gestao360.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmail(String email);

    boolean existsByEmail(String mail);
}

package the.coyote.Gestao360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.coyote.Gestao360.entity.BancoEntity;

import java.util.Optional;

public interface BancoRepository extends JpaRepository<BancoEntity, Long> {
    Optional<BancoEntity> findById(Long bancoId);
}
package the.coyote.Gestao360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.coyote.Gestao360.entity.BancoEntity;

public interface BancoRepository extends JpaRepository<BancoEntity, Long> {
}
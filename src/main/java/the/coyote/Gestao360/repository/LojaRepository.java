package the.coyote.Gestao360.repository;

import the.coyote.Gestao360.entity.LojaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<LojaEntity, Long> {
}
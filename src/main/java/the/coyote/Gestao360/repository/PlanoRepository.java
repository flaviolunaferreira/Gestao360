package the.coyote.Gestao360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.coyote.Gestao360.entity.PlanoEntity;

public interface PlanoRepository extends JpaRepository<PlanoEntity, Long> {
}

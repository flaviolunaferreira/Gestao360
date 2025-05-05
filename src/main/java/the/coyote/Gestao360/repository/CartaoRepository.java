package the.coyote.Gestao360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.coyote.Gestao360.entity.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, String> {
}

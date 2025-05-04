package the.coyote.Gestao360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.coyote.Gestao360.entity.ContaCorrenteEntity;

import java.util.List;
import java.util.Optional;

public interface ContaCorrenteRepository extends JpaRepository <ContaCorrenteEntity, String> {
    Optional<ContaCorrenteEntity> findByNumero(String numero);
    List<ContaCorrenteEntity> findAll();
    void deleteByNumero(String numero);
}

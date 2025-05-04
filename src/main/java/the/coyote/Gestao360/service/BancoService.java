package the.coyote.Gestao360.service;

import the.coyote.Gestao360.dto.banco.BancoRequestDTO;
import the.coyote.Gestao360.dto.banco.BancoResponseDTO;
import java.util.List;

public interface BancoService {

    BancoResponseDTO saveBanco(BancoRequestDTO bancoRequestDTO);

    BancoResponseDTO findById(Long id);

    List<BancoResponseDTO> findAll();

    BancoResponseDTO updateBanco(Long id, BancoRequestDTO bancoRequestDTO);

    void deleteBanco(Long id);
}
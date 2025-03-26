package the.coyote.Gestao360.service;

import the.coyote.Gestao360.dto.plano.PlanoRequestDTO;
import the.coyote.Gestao360.dto.plano.PlanoResponseDTO;

import java.util.List;

public interface PlanoService {

    PlanoResponseDTO savePlano(PlanoRequestDTO planoRequestDTO);
    PlanoResponseDTO findById(Long id);
    List<PlanoResponseDTO> findAll();
    PlanoResponseDTO updatePlano(Long id, PlanoRequestDTO planoRequestDTO);
    void deletePlano(Long id);

}

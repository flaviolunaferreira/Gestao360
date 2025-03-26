package the.coyote.Gestao360.service;

import the.coyote.Gestao360.dto.modulo.ModuloRequestDTO;
import the.coyote.Gestao360.dto.modulo.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {

    ModuloResponseDTO saveModulo(ModuloRequestDTO moduloRequestDTO);
    ModuloResponseDTO findById(Long id);
    List<ModuloResponseDTO> findAll();
    ModuloResponseDTO updateModulo(Long id, ModuloRequestDTO moduloRequestDTO);
    void deleteModulo(Long id);
}
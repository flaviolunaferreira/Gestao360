package the.coyote.Gestao360.service;

import the.coyote.Gestao360.dto.loja.LojaRequestDTO;
import the.coyote.Gestao360.dto.loja.LojaResponseDTO;

import java.util.List;

public interface LojaService {

    LojaResponseDTO saveLoja(LojaRequestDTO lojaRequestDTO);
    LojaResponseDTO findById(Long id);
    List<LojaResponseDTO> findAll();
    LojaResponseDTO updateLoja(Long id, LojaRequestDTO lojaRequestDTO);
    void deleteLoja(Long id);
}
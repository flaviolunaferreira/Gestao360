package the.coyote.Gestao360.service;

import the.coyote.Gestao360.dto.conta.ContaCorrenteRequestDTO;
import the.coyote.Gestao360.dto.conta.ContaCorrenteResponseDTO;

import java.util.List;

public interface ContaCorrenteService {

    ContaCorrenteResponseDTO saveContaCorrente(ContaCorrenteRequestDTO requestDTO);

    ContaCorrenteResponseDTO findByNumero(String numero);

    List<ContaCorrenteResponseDTO> findAll();

    ContaCorrenteResponseDTO updateContaCorrente(String numero, ContaCorrenteRequestDTO requestDTO);

    void deleteContaCorrente(String numero);
}
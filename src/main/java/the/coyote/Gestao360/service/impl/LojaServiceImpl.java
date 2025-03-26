package the.coyote.Gestao360.service.impl;

import the.coyote.Gestao360.dto.loja.LojaRequestDTO;
import the.coyote.Gestao360.dto.loja.LojaResponseDTO;
import the.coyote.Gestao360.entity.LojaEntity;
import the.coyote.Gestao360.repository.LojaRepository;
import the.coyote.Gestao360.service.LojaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LojaServiceImpl implements LojaService {

    private final LojaRepository lojaRepository;

    @Override
    @Transactional
    public LojaResponseDTO saveLoja(LojaRequestDTO lojaRequestDTO) {
        LojaEntity lojaEntity = new LojaEntity();
        // Mapear os dados do DTO para a entidade
        lojaEntity.setNome(lojaRequestDTO.getNome());
        lojaEntity.setCnpj(lojaRequestDTO.getCnpj());
        lojaEntity.setEndereco(lojaRequestDTO.getEndereco());
        lojaEntity.setTelefone(lojaRequestDTO.getTelefone());
        lojaEntity.setEmail(lojaRequestDTO.getEmail());
        // Salvar a entidade
        LojaEntity savedLoja = lojaRepository.save(lojaEntity);
        // Retornar o DTO de resposta
        return mapToResponseDTO(savedLoja);
    }

    @Override
    public LojaResponseDTO findById(Long id) {
        LojaEntity lojaEntity = lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
        return mapToResponseDTO(lojaEntity);
    }

    @Override
    public List<LojaResponseDTO> findAll() {
        return lojaRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LojaResponseDTO updateLoja(Long id, LojaRequestDTO lojaRequestDTO) {
        LojaEntity lojaEntity = lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
        // Atualizar os dados da entidade
        lojaEntity.setNome(lojaRequestDTO.getNome());
        lojaEntity.setCnpj(lojaRequestDTO.getCnpj());
        lojaEntity.setEndereco(lojaRequestDTO.getEndereco());
        lojaEntity.setTelefone(lojaRequestDTO.getTelefone());
        lojaEntity.setEmail(lojaRequestDTO.getEmail());
        // Salvar a entidade atualizada
        LojaEntity updatedLoja = lojaRepository.save(lojaEntity);
        // Retornar o DTO de resposta
        return mapToResponseDTO(updatedLoja);
    }

    @Override
    @Transactional
    public void deleteLoja(Long id) {
        lojaRepository.deleteById(id);
    }

    private LojaResponseDTO mapToResponseDTO(LojaEntity lojaEntity) {
        LojaResponseDTO responseDTO = new LojaResponseDTO();
        responseDTO.setId(lojaEntity.getId());
        responseDTO.setNome(lojaEntity.getNome());
        responseDTO.setCnpj(lojaEntity.getCnpj());
        responseDTO.setEndereco(lojaEntity.getEndereco());
        responseDTO.setTelefone(lojaEntity.getTelefone());
        responseDTO.setEmail(lojaEntity.getEmail());
        responseDTO.setEmpresaId(lojaEntity.getEmpresa().getId()); // Assumindo que LojaEntity tem um relacionamento com EmpresaEntity
        return responseDTO;
    }
}
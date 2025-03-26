package the.coyote.Gestao360.service.impl;

import the.coyote.Gestao360.dto.modulo.ModuloRequestDTO;
import the.coyote.Gestao360.dto.modulo.ModuloResponseDTO;
import the.coyote.Gestao360.entity.ModuloEntity;
import the.coyote.Gestao360.repository.ModuloRepository;
import the.coyote.Gestao360.service.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;

    @Override
    @Transactional
    public ModuloResponseDTO saveModulo(ModuloRequestDTO moduloRequestDTO) {
        return mapToResponseDTO( moduloRepository.save(moduloRequestDTO.newModulo()));
    }

    @Override
    public ModuloResponseDTO findById(Long id) {
        ModuloEntity moduloEntity = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo não encontrado"));
        return mapToResponseDTO(moduloEntity);
    }

    @Override
    public List<ModuloResponseDTO> findAll() {
        return moduloRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ModuloResponseDTO updateModulo(Long id, ModuloRequestDTO moduloRequestDTO) {
        ModuloEntity moduloEntity = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo não encontrado"));
        // Atualizar os dados da entidade
        moduloEntity.setNome(moduloRequestDTO.getNome());
        // Salvar a entidade atualizada
        ModuloEntity updatedModulo = moduloRepository.save(moduloEntity);
        // Retornar o DTO de resposta
        return mapToResponseDTO(updatedModulo);
    }

    @Override
    @Transactional
    public void deleteModulo(Long id) {
        moduloRepository.deleteById(id);
    }

    private ModuloResponseDTO mapToResponseDTO(ModuloEntity moduloEntity) {
        ModuloResponseDTO responseDTO = new ModuloResponseDTO();
        responseDTO.setId(moduloEntity.getId());
        responseDTO.setNome(moduloEntity.getNome());
        responseDTO.setPercentualCusto(moduloEntity.getPercentualCusto());
        return responseDTO;
    }
}
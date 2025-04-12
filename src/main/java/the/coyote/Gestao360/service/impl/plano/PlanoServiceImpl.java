package the.coyote.Gestao360.service.impl.plano;

import the.coyote.Gestao360.dto.plano.PlanoRequestDTO;
import the.coyote.Gestao360.dto.plano.PlanoResponseDTO;
import the.coyote.Gestao360.entity.PlanoEntity;
import the.coyote.Gestao360.repository.PlanoRepository;
import the.coyote.Gestao360.service.PlanoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanoServiceImpl implements PlanoService {

    private final PlanoRepository planoRepository;

    @Override
    @Transactional
    public PlanoResponseDTO savePlano(PlanoRequestDTO planoRequestDTO) {
        PlanoEntity planoEntity = new PlanoEntity();
        // Mapear os dados do DTO para a entidade
        planoEntity.setNome(planoRequestDTO.getNome());
        planoEntity.setPrecoBasePorLoja(planoRequestDTO.getPrecoBasePorLoja());
        // Salvar a entidade
        PlanoEntity savedPlano = planoRepository.save(planoEntity);
        // Retornar o DTO de resposta
        return mapToResponseDTO(savedPlano);
    }

    @Override
    public PlanoResponseDTO findById(Long id) {
        PlanoEntity planoEntity = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
        return mapToResponseDTO(planoEntity);
    }

    @Override
    public List<PlanoResponseDTO> findAll() {
        return planoRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PlanoResponseDTO updatePlano(Long id, PlanoRequestDTO planoRequestDTO) {
        PlanoEntity planoEntity = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
        // Atualizar os dados da entidade
        planoEntity.setNome(planoRequestDTO.getNome());
        planoEntity.setPrecoBasePorLoja(planoRequestDTO.getPrecoBasePorLoja());
        // Salvar a entidade atualizada
        PlanoEntity updatedPlano = planoRepository.save(planoEntity);
        // Retornar o DTO de resposta
        return mapToResponseDTO(updatedPlano);
    }

    @Override
    @Transactional
    public void deletePlano(Long id) {
        planoRepository.deleteById(id);
    }

    private PlanoResponseDTO mapToResponseDTO(PlanoEntity planoEntity) {
        PlanoResponseDTO responseDTO = new PlanoResponseDTO();
        responseDTO.setId(planoEntity.getId());
        responseDTO.setNome(planoEntity.getNome());
        responseDTO.setPrecoBasePorLoja(planoEntity.getPrecoBasePorLoja());
        // Mapear os módulos, se necessário
        return responseDTO;
    }
}
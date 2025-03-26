package the.coyote.Gestao360.service.impl;

import the.coyote.Gestao360.dto.empresa.EmpresaRequestDTO;
import the.coyote.Gestao360.dto.empresa.EmpresaResponseDTO;
import the.coyote.Gestao360.entity.EmpresaEntity;
import the.coyote.Gestao360.repository.EmpresaRepository;
import the.coyote.Gestao360.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    @Transactional
    public EmpresaResponseDTO saveEmpresa(EmpresaRequestDTO empresaRequestDTO) {
        EmpresaEntity empresaEntity = new EmpresaEntity();
        // Mapear os dados do DTO para a entidade
        empresaEntity.setNome(empresaRequestDTO.getNome());
        empresaEntity.setCnpj(empresaRequestDTO.getCnpj());
        empresaEntity.setEndereco(empresaRequestDTO.getEndereco());
        empresaEntity.setTelefone(empresaRequestDTO.getTelefone());
        empresaEntity.setEmail(empresaRequestDTO.getEmail());
        // Salvar a entidade
        EmpresaEntity savedEmpresa = empresaRepository.save(empresaEntity);
        // Retornar o DTO de resposta
        return mapToResponseDTO(savedEmpresa);
    }

    @Override
    public EmpresaResponseDTO findById(Long id) {
        EmpresaEntity empresaEntity = empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        return mapToResponseDTO(empresaEntity);
    }

    @Override
    public List<EmpresaResponseDTO> findAll() {
        return empresaRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmpresaResponseDTO updateEmpresa(Long id, EmpresaRequestDTO empresaRequestDTO) {
        EmpresaEntity empresaEntity = empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        // Atualizar os dados da entidade
        empresaEntity.setNome(empresaRequestDTO.getNome());
        empresaEntity.setCnpj(empresaRequestDTO.getCnpj());
        empresaEntity.setEndereco(empresaRequestDTO.getEndereco());
        empresaEntity.setTelefone(empresaRequestDTO.getTelefone());
        empresaEntity.setEmail(empresaRequestDTO.getEmail());
        // Salvar a entidade atualizada
        EmpresaEntity updatedEmpresa = empresaRepository.save(empresaEntity);
        // Retornar o DTO de resposta
        return mapToResponseDTO(updatedEmpresa);
    }

    @Override
    @Transactional
    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }

    private EmpresaResponseDTO mapToResponseDTO(EmpresaEntity empresaEntity) {
        EmpresaResponseDTO responseDTO = new EmpresaResponseDTO();
        responseDTO.setId(empresaEntity.getId());
        responseDTO.setNome(empresaEntity.getNome());
        responseDTO.setCnpj(empresaEntity.getCnpj());
        responseDTO.setEndereco(empresaEntity.getEndereco());
        responseDTO.setTelefone(empresaEntity.getTelefone());
        responseDTO.setEmail(empresaEntity.getEmail());
        responseDTO.setPlanoId(empresaEntity.getPlano().getId()); // Assumindo que EmpresaEntity tem um relacionamento com PlanoEntity
        return responseDTO;
    }
}
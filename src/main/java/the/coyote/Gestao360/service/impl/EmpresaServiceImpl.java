package the.coyote.Gestao360.service.impl;

import org.springframework.context.ApplicationContext;
import the.coyote.Gestao360.dto.config.FieldConfig;
import the.coyote.Gestao360.dto.config.FormField;
import the.coyote.Gestao360.dto.empresa.EmpresaRequestDTO;
import the.coyote.Gestao360.dto.empresa.EmpresaResponseDTO;
import the.coyote.Gestao360.entity.EmpresaEntity;
import the.coyote.Gestao360.enumeration.FieldType;
import the.coyote.Gestao360.repository.EmpresaRepository;
import the.coyote.Gestao360.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ApplicationContext applicationContext;

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

    public List<FieldConfig> getFieldConfigs() {
        List<FieldConfig> configs = new ArrayList<>();
        Field[] fields = EmpresaEntity.class.getDeclaredFields();

        for (Field field : fields) {
            FormField formField = field.getAnnotation(FormField.class);
            if (formField != null) {
                FieldConfig config = new FieldConfig();
                config.setName(field.getName());
                config.setLabel(formField.label());
                config.setType(convertType(formField.type()));
                config.setDataType(getDataType(field.getType()));
                config.setRequired(formField.required());
                config.setMinLength(formField.minLength());
                config.setMaxLength(formField.maxLength());
                config.setPattern(formField.pattern());
                config.setShowInTable(formField.showInTable());
                config.setFilterable(formField.filterable());

                // Se for um dropdown, adiciona as opções
                if (formField.type() == FieldType.SELECT) {
                    // Você precisaria implementar a lógica para obter as opções
                    // do optionsProvider ou optionsEndpoint
                }

                configs.add(config);
            }
        }
        System.out.println("Field Configs: " + configs);
        return configs;
    }

    private String convertType(FieldType fieldType) {
        switch (fieldType) {
            case INPUT: return "input";
            case SELECT: return "dropdown";
            case CHECKBOX: return "checkbox";
            case DATE: return "date";
            case TEXTAREA: return "textarea";
            default: return "input";
        }
    }

    private String getDataType(Class<?> type) {
        if (type == String.class) return "string";
        if (type == Integer.class || type == int.class ||
                type == Long.class || type == long.class ||
                type == Double.class || type == double.class) return "number";
        if (type == Boolean.class || type == boolean.class) return "boolean";
        if (type == java.time.LocalDate.class) return "date";
        return "string";
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
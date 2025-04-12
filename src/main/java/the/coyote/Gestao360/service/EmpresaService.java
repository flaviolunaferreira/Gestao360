package the.coyote.Gestao360.service;

import the.coyote.Gestao360.dto.config.FieldConfig;
import the.coyote.Gestao360.dto.empresa.EmpresaRequestDTO;
import the.coyote.Gestao360.dto.empresa.EmpresaResponseDTO;

import java.util.List;

public interface EmpresaService {

    EmpresaResponseDTO saveEmpresa(EmpresaRequestDTO empresaRequestDTO);
    EmpresaResponseDTO findById(Long id);
    List<EmpresaResponseDTO> findAll();
    EmpresaResponseDTO updateEmpresa(Long id, EmpresaRequestDTO empresaRequestDTO);
    void deleteEmpresa(Long id);
    public List<FieldConfig> getFieldConfigs();
}
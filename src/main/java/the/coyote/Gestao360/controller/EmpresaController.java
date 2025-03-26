package the.coyote.Gestao360.controller;

import the.coyote.Gestao360.dto.empresa.EmpresaRequestDTO;
import the.coyote.Gestao360.dto.empresa.EmpresaResponseDTO;
import the.coyote.Gestao360.service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> createEmpresa(@RequestBody EmpresaRequestDTO empresaRequestDTO) {
        EmpresaResponseDTO empresaResponseDTO = empresaService.saveEmpresa(empresaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> getEmpresaById(@PathVariable Long id) {
        EmpresaResponseDTO empresaResponseDTO = empresaService.findById(id);
        return ResponseEntity.ok(empresaResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> getAllEmpresas() {
        List<EmpresaResponseDTO> empresas = empresaService.findAll();
        return ResponseEntity.ok(empresas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> updateEmpresa(@PathVariable Long id, @RequestBody EmpresaRequestDTO empresaRequestDTO) {
        EmpresaResponseDTO empresaResponseDTO = empresaService.updateEmpresa(id, empresaRequestDTO);
        return ResponseEntity.ok(empresaResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
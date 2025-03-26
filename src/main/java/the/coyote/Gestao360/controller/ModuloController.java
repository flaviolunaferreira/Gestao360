package the.coyote.Gestao360.controller;

import the.coyote.Gestao360.dto.modulo.ModuloRequestDTO;
import the.coyote.Gestao360.dto.modulo.ModuloResponseDTO;
import the.coyote.Gestao360.service.ModuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modulos")
@CrossOrigin(origins = "*")
public class ModuloController {

    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @PostMapping
    public ResponseEntity<ModuloResponseDTO> createModulo(@RequestBody ModuloRequestDTO moduloRequestDTO) {
        ModuloResponseDTO moduloResponseDTO = moduloService.saveModulo(moduloRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(moduloResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloResponseDTO> getModuloById(@PathVariable Long id) {
        ModuloResponseDTO moduloResponseDTO = moduloService.findById(id);
        return ResponseEntity.ok(moduloResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ModuloResponseDTO>> getAllModulos() {
        List<ModuloResponseDTO> modulos = moduloService.findAll();
        return ResponseEntity.ok(modulos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuloResponseDTO> updateModulo(@PathVariable Long id, @RequestBody ModuloRequestDTO moduloRequestDTO) {
        ModuloResponseDTO moduloResponseDTO = moduloService.updateModulo(id, moduloRequestDTO);
        return ResponseEntity.ok(moduloResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModulo(@PathVariable Long id) {
        moduloService.deleteModulo(id);
        return ResponseEntity.noContent().build();
    }
}
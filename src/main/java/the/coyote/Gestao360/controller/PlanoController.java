package the.coyote.Gestao360.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.coyote.Gestao360.dto.plano.PlanoRequestDTO;
import the.coyote.Gestao360.dto.plano.PlanoResponseDTO;
import the.coyote.Gestao360.service.PlanoService;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @PostMapping
    public ResponseEntity<PlanoResponseDTO> createPlano(@RequestBody PlanoRequestDTO planoRequestDTO) {
        PlanoResponseDTO planoResponseDTO = planoService.savePlano(planoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(planoResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoResponseDTO> getPlanoById(@PathVariable Long id) {
        PlanoResponseDTO planoResponseDTO = planoService.findById(id);
        return ResponseEntity.ok(planoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PlanoResponseDTO>> getAllPlanos() {
        List<PlanoResponseDTO> planos = planoService.findAll();
        return ResponseEntity.ok(planos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoResponseDTO> updatePlano(@PathVariable Long id, @RequestBody PlanoRequestDTO planoRequestDTO) {
        PlanoResponseDTO planoResponseDTO = planoService.updatePlano(id, planoRequestDTO);
        return ResponseEntity.ok(planoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlano(@PathVariable Long id) {
        planoService.deletePlano(id);
        return ResponseEntity.noContent().build();
    }
}

package the.coyote.Gestao360.controller;

import the.coyote.Gestao360.dto.loja.LojaRequestDTO;
import the.coyote.Gestao360.dto.loja.LojaResponseDTO;
import the.coyote.Gestao360.service.LojaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping
    public ResponseEntity<LojaResponseDTO> createLoja(@RequestBody LojaRequestDTO lojaRequestDTO) {
        LojaResponseDTO lojaResponseDTO = lojaService.saveLoja(lojaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(lojaResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LojaResponseDTO> getLojaById(@PathVariable Long id) {
        LojaResponseDTO lojaResponseDTO = lojaService.findById(id);
        return ResponseEntity.ok(lojaResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<LojaResponseDTO>> getAllLojas() {
        List<LojaResponseDTO> lojas = lojaService.findAll();
        return ResponseEntity.ok(lojas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LojaResponseDTO> updateLoja(@PathVariable Long id, @RequestBody LojaRequestDTO lojaRequestDTO) {
        LojaResponseDTO lojaResponseDTO = lojaService.updateLoja(id, lojaRequestDTO);
        return ResponseEntity.ok(lojaResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoja(@PathVariable Long id) {
        lojaService.deleteLoja(id);
        return ResponseEntity.noContent().build();
    }
}
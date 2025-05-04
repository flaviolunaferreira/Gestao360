package the.coyote.Gestao360.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.coyote.Gestao360.dto.banco.BancoRequestDTO;
import the.coyote.Gestao360.dto.banco.BancoResponseDTO;
import the.coyote.Gestao360.service.BancoService;

import java.util.List;

@RestController
@RequestMapping("/api/bancos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class BancoController {

    private final BancoService bancoService;

    @PostMapping
    public ResponseEntity<BancoResponseDTO> createBanco(@RequestBody BancoRequestDTO bancoRequestDTO) {
        BancoResponseDTO bancoResponseDTO = bancoService.saveBanco(bancoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bancoResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoResponseDTO> getBancoById(@PathVariable Long id) {
        BancoResponseDTO bancoResponseDTO = bancoService.findById(id);
        return ResponseEntity.ok(bancoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<BancoResponseDTO>> getAllBancos() {
        List<BancoResponseDTO> bancos = bancoService.findAll();
        return ResponseEntity.ok(bancos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BancoResponseDTO> updateBanco(@PathVariable Long id, @RequestBody BancoRequestDTO bancoRequestDTO) {
        BancoResponseDTO bancoResponseDTO = bancoService.updateBanco(id, bancoRequestDTO);
        return ResponseEntity.ok(bancoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanco(@PathVariable Long id) {
        bancoService.deleteBanco(id);
        return ResponseEntity.noContent().build();
    }
}
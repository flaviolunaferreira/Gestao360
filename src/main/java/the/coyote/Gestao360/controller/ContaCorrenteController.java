package the.coyote.Gestao360.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.coyote.Gestao360.dto.conta.ContaCorrenteRequestDTO;
import the.coyote.Gestao360.dto.conta.ContaCorrenteResponseDTO;
import the.coyote.Gestao360.service.ContaCorrenteService;

import java.util.List;

@RestController
@RequestMapping("/api/contas-correntes")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    @PostMapping
    public ResponseEntity<ContaCorrenteResponseDTO> createContaCorrente(@RequestBody ContaCorrenteRequestDTO requestDTO) {
        ContaCorrenteResponseDTO responseDTO = contaCorrenteService.saveContaCorrente(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<ContaCorrenteResponseDTO> getContaCorrenteByNumero(@PathVariable String numero) {
        ContaCorrenteResponseDTO responseDTO = contaCorrenteService.findByNumero(numero);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ContaCorrenteResponseDTO>> getAllContasCorrentes() {
        List<ContaCorrenteResponseDTO> contas = contaCorrenteService.findAll();
        return ResponseEntity.ok(contas);
    }

    @PutMapping("/{numero}")
    public ResponseEntity<ContaCorrenteResponseDTO> updateContaCorrente(@PathVariable String numero, @RequestBody ContaCorrenteRequestDTO requestDTO) {
        ContaCorrenteResponseDTO responseDTO = contaCorrenteService.updateContaCorrente(numero, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Void> deleteContaCorrente(@PathVariable String numero) {
        contaCorrenteService.deleteContaCorrente(numero);
        return ResponseEntity.noContent().build();
    }
}
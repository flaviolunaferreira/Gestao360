package the.coyote.Gestao360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.coyote.Gestao360.dto.CartaoRequestDTO;
import the.coyote.Gestao360.dto.CartaoResponseDTO;
import the.coyote.Gestao360.service.CartaoService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<CartaoResponseDTO> createCartao(@Valid @RequestBody CartaoRequestDTO request) {
        CartaoResponseDTO response = cartaoService.saveCartao(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<CartaoResponseDTO> getCartao(@PathVariable String numeroCartao) {
        CartaoResponseDTO response = cartaoService.findById(numeroCartao);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartaoResponseDTO>> getAllCartoes() {
        List<CartaoResponseDTO> response = cartaoService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{numeroCartao}")
    public ResponseEntity<CartaoResponseDTO> updateCartao(@PathVariable String numeroCartao, @Valid @RequestBody CartaoRequestDTO request) {
        CartaoResponseDTO response = cartaoService.updateCartao(numeroCartao, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{numeroCartao}")
    public ResponseEntity<Void> deleteCartao(@PathVariable String numeroCartao) {
        cartaoService.deleteCartao(numeroCartao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
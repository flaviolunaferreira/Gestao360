package the.coyote.Gestao360.service;

import the.coyote.Gestao360.dto.CartaoRequestDTO;
import the.coyote.Gestao360.dto.CartaoResponseDTO;

import java.util.List;

public interface CartaoService {

    CartaoResponseDTO saveCartao(CartaoRequestDTO request);
    CartaoResponseDTO findById(String numeroCartao);
    List<CartaoResponseDTO> findAll();
    CartaoResponseDTO updateCartao(String numeroCartao, CartaoRequestDTO request);
    void deleteCartao(String numeroCartao);

}
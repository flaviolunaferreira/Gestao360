package the.coyote.Gestao360.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.coyote.Gestao360.dto.CartaoRequestDTO;
import the.coyote.Gestao360.dto.CartaoResponseDTO;
import the.coyote.Gestao360.entity.CartaoEntity;
import the.coyote.Gestao360.entity.ContaCorrenteEntity;
import the.coyote.Gestao360.repository.CartaoRepository;
import the.coyote.Gestao360.repository.ContaCorrenteRepository;
import the.coyote.Gestao360.service.CartaoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartaoServiceImpl implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Override
    public CartaoResponseDTO saveCartao(CartaoRequestDTO request) {
        ContaCorrenteEntity contaCorrente = contaCorrenteRepository.findById(request.getContaCorrenteNumero())
                .orElseThrow(() -> new IllegalArgumentException("Conta corrente não encontrada: " + request.getContaCorrenteNumero()));

        CartaoEntity cartao = CartaoEntity.builder()
                .numeroCartao(request.getNumeroCartao())
                .dataVencimento(request.getDataVencimento())
                .limite(request.getLimite())
                .saldo(request.getSaldo())
                .diaVencimento(request.getDiaVencimento())
                .contaCorrente(contaCorrente)
                .build();

        cartao = cartaoRepository.save(cartao);
        return mapToResponseDTO(cartao);
    }

    @Override
    public CartaoResponseDTO findById(String numeroCartao) {
        CartaoEntity cartao = cartaoRepository.findById(numeroCartao)
                .orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado: " + numeroCartao));
        return mapToResponseDTO(cartao);
    }

    @Override
    public List<CartaoResponseDTO> findAll() {
        return cartaoRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CartaoResponseDTO updateCartao(String numeroCartao, CartaoRequestDTO request) {
        CartaoEntity cartao = cartaoRepository.findById(numeroCartao)
                .orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado: " + numeroCartao));

        ContaCorrenteEntity contaCorrente = contaCorrenteRepository.findById(request.getContaCorrenteNumero())
                .orElseThrow(() -> new IllegalArgumentException("Conta corrente não encontrada: " + request.getContaCorrenteNumero()));

        cartao.setDataVencimento(request.getDataVencimento());
        cartao.setLimite(request.getLimite());
        cartao.setSaldo(request.getSaldo());
        cartao.setDiaVencimento(request.getDiaVencimento());
        cartao.setContaCorrente(contaCorrente);

        cartao = cartaoRepository.save(cartao);
        return mapToResponseDTO(cartao);
    }

    @Override
    public void deleteCartao(String numeroCartao) {
        if (!cartaoRepository.existsById(numeroCartao)) {
            throw new IllegalArgumentException("Cartão não encontrado: " + numeroCartao);
        }
        cartaoRepository.deleteById(numeroCartao);
    }

    private CartaoResponseDTO mapToResponseDTO(CartaoEntity cartao) {
        return CartaoResponseDTO.builder()
                .numeroCartao(cartao.getNumeroCartao())
                .dataVencimento(cartao.getDataVencimento())
                .limite(cartao.getLimite())
                .saldo(cartao.getSaldo())
                .diaVencimento(cartao.getDiaVencimento())
                .contaCorrenteNumero(cartao.getContaCorrente().getNumero())
                .build();
    }
}
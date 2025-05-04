package the.coyote.Gestao360.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import the.coyote.Gestao360.dto.conta.ContaCorrenteRequestDTO;
import the.coyote.Gestao360.dto.conta.ContaCorrenteResponseDTO;
import the.coyote.Gestao360.entity.BancoEntity;
import the.coyote.Gestao360.entity.ContaCorrenteEntity;
import the.coyote.Gestao360.repository.BancoRepository;
import the.coyote.Gestao360.repository.ContaCorrenteRepository;
import the.coyote.Gestao360.service.ContaCorrenteService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    private final ContaCorrenteRepository contaCorrenteRepository;
    private final BancoRepository bancoRepository;

    @Override
    public ContaCorrenteResponseDTO saveContaCorrente(ContaCorrenteRequestDTO requestDTO) {
        Optional<ContaCorrenteEntity> contaCorrente = contaCorrenteRepository.findByNumero(requestDTO.getNumero());
        if (contaCorrente.isPresent()) {
            throw new RuntimeException("Já existe uma conta corrente com esse número");
        }
        return new ContaCorrenteResponseDTO(contaCorrenteRepository.save(requestDTO.novaContaCorrente(bancoRepository)));
    }

    @Override
    public ContaCorrenteResponseDTO findByNumero(String numero) {
        ContaCorrenteEntity conta =  contaCorrenteRepository.findByNumero(numero).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        return new ContaCorrenteResponseDTO(conta);
    }

    @Override
    public List<ContaCorrenteResponseDTO> findAll() {
        return contaCorrenteRepository.findAll().stream()
                .map(ContaCorrenteResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ContaCorrenteResponseDTO updateContaCorrente(String numero, ContaCorrenteRequestDTO requestDTO) {
        ContaCorrenteEntity entity = contaCorrenteRepository.findById(numero)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        BancoEntity banco = bancoRepository.findById(requestDTO.getBancoId()).orElseThrow(() -> new RuntimeException("Banco não encontrado!"));

        entity.setBanco(banco);
        entity.setTipoConta(requestDTO.getTipoConta());
        entity.setAgencia(requestDTO.getAgencia());
        entity.setTitular(requestDTO.getTitular());
        entity.setCpfCnpjTitular(requestDTO.getCpfCnpjTitular());
        entity.setLimite(requestDTO.getLimite());

        entity = contaCorrenteRepository.save(entity);

        return new ContaCorrenteResponseDTO(entity);
    }

    @Override
    public void deleteContaCorrente(String numero) {
        contaCorrenteRepository.deleteById(numero);
    }

}
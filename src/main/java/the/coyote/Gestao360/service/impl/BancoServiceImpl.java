package the.coyote.Gestao360.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import the.coyote.Gestao360.dto.banco.BancoRequestDTO;
import the.coyote.Gestao360.dto.banco.BancoResponseDTO;
import the.coyote.Gestao360.entity.BancoEntity;
import the.coyote.Gestao360.repository.BancoRepository;
import the.coyote.Gestao360.service.BancoService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BancoServiceImpl implements BancoService {

    private final BancoRepository bancoRepository;

    @Override
    public BancoResponseDTO saveBanco(BancoRequestDTO bancoRequestDTO) {
        BancoEntity bancoEntity = new BancoEntity();
        bancoEntity.setId(bancoRequestDTO.getId());
        bancoEntity.setNome(bancoRequestDTO.getNome());
        bancoEntity.setCodigoISPB(bancoRequestDTO.getCodigoISPB());
        BancoEntity savedBanco = bancoRepository.save(bancoEntity);
        return mapToResponseDTO(savedBanco);
    }

    @Override
    public BancoResponseDTO findById(Long id) {
        BancoEntity bancoEntity = bancoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banco não encontrado com ID: " + id));
        return mapToResponseDTO(bancoEntity);
    }

    @Override
    public List<BancoResponseDTO> findAll() {
        return bancoRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BancoResponseDTO updateBanco(Long id, BancoRequestDTO bancoRequestDTO) {
        BancoEntity bancoEntity = bancoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banco não encontrado com ID: " + id));
        bancoEntity.setNome(bancoRequestDTO.getNome());
        bancoEntity.setCodigoISPB(bancoRequestDTO.getCodigoISPB());
        BancoEntity updatedBanco = bancoRepository.save(bancoEntity);
        return mapToResponseDTO(updatedBanco);
    }

    @Override
    public void deleteBanco(Long id) {
        BancoEntity bancoEntity = bancoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banco não encontrado com ID: " + id));
        bancoRepository.delete(bancoEntity);
    }

    private BancoResponseDTO mapToResponseDTO(BancoEntity bancoEntity) {
        return new BancoResponseDTO(
                bancoEntity.getId(),
                bancoEntity.getNome(),
                bancoEntity.getCodigoISPB(),
                bancoEntity.getCreatedAt(),
                bancoEntity.getUpdatedAt()
        );
    }
}
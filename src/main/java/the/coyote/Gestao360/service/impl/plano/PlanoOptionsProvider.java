// PlanoOptionsProvider.java
package the.coyote.Gestao360.service.impl.plano;

import the.coyote.Gestao360.dto.config.FieldOptionsProvider;
import the.coyote.Gestao360.dto.config.OptionDTO;
import the.coyote.Gestao360.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanoOptionsProvider implements FieldOptionsProvider {

    private final PlanoRepository planoRepository;

    public PlanoOptionsProvider(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Override
    public List<OptionDTO> getOptions() {
        return planoRepository.findAll().stream()
                .map(plano -> new OptionDTO(plano.getId(), plano.getNome()))
                .collect(Collectors.toList());
    }
}
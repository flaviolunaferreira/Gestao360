package the.coyote.Gestao360.dto.config;

import java.util.Collections;
import java.util.List;

public class DefaultOptionsProvider implements FieldOptionsProvider {
    @Override
    public List<OptionDTO> getOptions() {
        return Collections.emptyList();
    }
}
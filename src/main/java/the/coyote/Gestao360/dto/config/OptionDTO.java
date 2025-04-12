
package the.coyote.Gestao360.dto.config;

import lombok.Data;

@Data
public class OptionDTO {
    private Object value;
    private String label;

    public OptionDTO() {}

    public OptionDTO(Object value, String label) {
        this.value = value;
        this.label = label;
    }
}
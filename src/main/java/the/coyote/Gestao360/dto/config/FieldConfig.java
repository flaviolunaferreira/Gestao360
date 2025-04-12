package the.coyote.Gestao360.dto.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldConfig {
    private String name;
    private String label;
    private String type; // "input", "dropdown", "checkbox", "date", "textarea"
    private String dataType; // "string", "number", "boolean", "enum", "date"
    private boolean required;
    private Integer minLength;
    private Integer maxLength;
    private Integer minValue;
    private Integer maxValue;
    private String pattern;
    private List<String> options; // Para dropdown
    private boolean showInTable;
    private boolean filterable;
    private Object defaultValue;

}
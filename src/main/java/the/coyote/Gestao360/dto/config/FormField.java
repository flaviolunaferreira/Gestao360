package the.coyote.Gestao360.dto.config;

import the.coyote.Gestao360.enumeration.FieldType;

import java.lang.annotation.*;

/**
 * Anotação para definir campos de formulário em entidades.
 * Utilizada para configurar a exibição e validação de campos em formulários.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FormField {

    /**
     * Rótulo do campo a ser exibido no formulário.
     * @return o rótulo do campo
     */
    String label();

    /**
     * Tipo do campo no formulário. O padrão é FieldType.INPUT.
     * @return o tipo do campo
     */
    FieldType type() default FieldType.INPUT;

    /**
     * Indica se o campo é obrigatório.
     * @return true se o campo for obrigatório, false caso contrário
     */
    boolean required() default false;

    /**
     * Comprimento mínimo do valor do campo.
     * @return o comprimento mínimo
     */
    int minLength() default 0;

    /**
     * Comprimento máximo do valor do campo.
     * @return o comprimento máximo
     */
    int maxLength() default Integer.MAX_VALUE;

    /**
     * Padrão regex para validação do campo.
     * @return o padrão regex
     */
    String pattern() default "";

    /**
     * Indica se o campo deve ser exibido na tabela.
     * @return true se o campo for exibido na tabela, false caso contrário
     */
    boolean showInTable() default true;

    /**
     * Indica se o campo deve ser exibido no formulário.
     * @return true se o campo for exibido no formulário, false caso contrário
     */
    boolean showInForm() default true;

    /**
     * Indica se o campo é filtrável na tabela.
     * @return true se o campo for filtrável, false caso contrário
     */
    boolean filterable() default false;

    /**
     * Provedor de opções para campos do tipo seleção.
     * @return a classe do provedor de opções
     */
    Class<? extends FieldOptionsProvider> optionsProvider() default DefaultOptionsProvider.class;

    /**
     * Endpoint para obter opções para campos do tipo seleção.
     * @return o endpoint de opções
     */
    String optionsEndpoint() default "";

    /**
     * Máscara de entrada para o campo.
     * @return a máscara de entrada
     */
    String mascara() default "";
}
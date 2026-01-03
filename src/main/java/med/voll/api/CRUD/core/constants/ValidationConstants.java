package med.voll.api.CRUD.core.constants;

public class ValidationConstants {

    private ValidationConstants() {
        throw new UnsupportedOperationException("Classe utilitária");
    }

    public static final String CRM_REGEX =
            "^CRM[- ]?[A-Z]{2}[- ]?\\d{1,6}$";

    public static final String CRM_MENSAGEM_INVALIDA =
            "CRM inválido. Use o formato: CRM-UF 123456";

    public static final String TELEFONE_MENSAGEM_INVALIDA =
            "Telefone inválido. Use DDD + número (10 ou 11 dígitos)";
}

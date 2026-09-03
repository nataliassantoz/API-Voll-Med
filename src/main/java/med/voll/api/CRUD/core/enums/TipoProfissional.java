package med.voll.api.CRUD.core.enums;

public enum TipoProfissional {

    CLINICO_GERAL(10, "CLINICO_GERAL"),
    CARDIOLOGIA(11, "CARDIOLOGIA"),
    DERMATOLOGIA(12, "DERMATOLOGIA"),
    GASTROENTEROLOGIA(13, "GASTROENTEROLOGIA"),
    NEUROLOGIA(14, "NEUROLOGIA"),
    ORTOPEDIA(15, "ORTOPEDIA"),
    GINECOLOGIA(16, "GINECOLOGIA"),
    PEDIATRIA(17, "PEDIATRIA"),
    PSIQUIATRIA(18, "PSIQUIATRIA"),
    PSICOLOGIA(19, "PSICOLOGIA");

    private final Integer codigo;
    private final String descricao;

    TipoProfissional(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

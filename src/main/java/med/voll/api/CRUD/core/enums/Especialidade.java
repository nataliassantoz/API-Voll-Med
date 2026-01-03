package med.voll.api.CRUD.core.enums;

import lombok.Getter;

@Getter
public enum Especialidade {
    CLINICO_GERAL(10, "CLINICO_GERAL"),
    CARDIOLOGIA(11, "CARDIOLOGIA"),
    DERMATOLOGIA(12, "DERMATOLOGIA"),
    PEDIATRIA(13, "PEDIATRIA"),
    GINECOLOGIA(14, "GINECOLOGIA"),
    ORTOPEDIA(15, "ORTOPEDIA"),
    OFTALMOLOGIA(16, "OFTALMOLOGIA"),
    PSIQUIATRIA(17, "PSIQUIATRIA"),
    NEUROLOGIA(18, "NEUROLOGIA"),
    ENDOCRINOLOGIA(19, "ENDOCRINOLOGIA"),
    OTORRINOLARINGOLOGIA(20, "OTORRINOLARINGOLOGIA"),
    UROLOGIA(21, "UROLOGIA");

    private final Integer codigo;
    private final String descricao;

    Especialidade(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

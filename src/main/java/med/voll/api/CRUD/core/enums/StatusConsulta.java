package med.voll.api.CRUD.core.enums;

public enum StatusConsulta {

    AGENDADA(1, "AGENDADA"),
    CONFIRMADA(2, "CONFIRMADA"),
    CANCELADA(3, "CANCELADA"),
    REALIZADA(5, "REALIZADA"),
    NAO_COMPARECEU(6, "NAO COMPARECEU");

    private final Integer codigo;
    private final String descricao;

    StatusConsulta(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

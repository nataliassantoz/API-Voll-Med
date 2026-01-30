package med.voll.api.CRUD.core.enums;

public enum StatusConsulta {

    AGENDADA(1, "Agendada"),
    CONFIRMADA(2, "Confirmada"),
    CANCELADA(3, "Cancelada"),
    EM_ANDAMENTO(4, "Em andamento"),
    REALIZADA(5, "Realizada"),
    NAO_COMPARECEU(6, "Não compareceu");

    private final Integer codigo;
    private final String descricao;

    StatusConsulta(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

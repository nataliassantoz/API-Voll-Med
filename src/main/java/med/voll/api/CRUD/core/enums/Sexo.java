package med.voll.api.CRUD.core.enums;


import lombok.Getter;

@Getter
public enum Sexo {
    MASCULINO(1),
    FEIMINO(2);

    private final Integer codigo;

    Sexo(Integer codigo){
        this.codigo = codigo;
    }
}

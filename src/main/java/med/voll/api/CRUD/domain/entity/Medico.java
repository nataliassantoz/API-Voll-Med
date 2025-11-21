package med.voll.api.CRUD.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import med.voll.api.CRUD.core.enums.Especialidade;

@Data
@Entity
@Table(schema = "MED", name = "TB_MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Column(unique = true)
    private String email;

    private String telefone;

    private Boolean ativo = true;
}

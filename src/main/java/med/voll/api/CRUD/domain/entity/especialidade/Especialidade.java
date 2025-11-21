package med.voll.api.CRUD.domain.entity.especialidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "MED", name = "TB_ESPECIALIDADE")
public class Especialidade {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true)
    private String descricao;
}

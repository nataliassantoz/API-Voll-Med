package med.voll.api.CRUD.domain.entity.medico;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import med.voll.api.CRUD.core.enums.Especialidade;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDICO")
    private Long id;

    @Column(name = "NOME_MEDICO")
    private String nome;

    @Column(unique = true,name = "CRM_MEDICO")
    private String crm;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "id_especialidade")
    private Especialidade especialidade;

    @Column(unique = true, name = "EMAIL_MEDICO")
    private String email;

    @Column(name = "TELEFONE_MEDICO")
    private String telefone;

    @Column(name = "FLATIVO_MEDICO")
    private Boolean ativo = true;

    @Column(name = "DT_CADASTRO", updatable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    private void prePersist() {
        this.dataCadastro = LocalDateTime.now();
        this.ativo = true;
    }
}

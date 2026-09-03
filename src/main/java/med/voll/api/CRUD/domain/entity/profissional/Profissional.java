package med.voll.api.CRUD.domain.entity.profissional;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import med.voll.api.CRUD.core.enums.Especialidade;
import med.voll.api.CRUD.core.enums.TipoProfissional;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_PROFISSIONAL")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFISSISONAL")
    private Long id;

    @Column(name = "NOME_PROFISSISONAL")
    private String dsNome;

    @Column(unique = true,name = "CPF_PROFISSISONAL")
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "ID_ESPECIALIDADE")
    private Especialidade dsEspecialidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_PROFISSIONAL")
    private TipoProfissional tpProfissional;

    @Column(unique = true, name = "EMAIL_PROFISSISONAL")
    private String dsEmail;

    @Column(name = "TELEFONE_PROFISSISONAL")
    private String nrTelefone;

    @Column(name = "FLATIVO_PROFISSISONAL")
    private Boolean flAtivo = true;

    @Column(name = "DT_CADASTRO", updatable = false)
    private LocalDateTime dtCadastro;

    @Column(name = "DS_CONSELHO")
    private String dsConselho;

    @Column(name = "REGISTRO_PROFISSIONAL")
    private String nrRegistro;

    @PrePersist
    private void prePersist() {
        this.dtCadastro = LocalDateTime.now();
        this.flAtivo = true;
    }
}

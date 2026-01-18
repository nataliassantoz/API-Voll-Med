package med.voll.api.CRUD.domain.entity.paciente;

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
import med.voll.api.CRUD.core.enums.Sexo;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PACIENTE")
    private Long id;

    @Column(name = "NOME_PACIENTE", nullable = false)
    private String nome;

    @Column(name = "CPF_PACIENTE", nullable = false, unique = true)
    private String cpf;

    @Column(name = "EMAIL_PACIENTE", nullable = false, unique = true)
    private String email;

    @Column(name = "TELEFONE_PACIENTE", nullable = false)
    private String telefone;

    @Column(name = "ENDERECO_PACIENTE", nullable = false)
    private String endereco;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO_PACIENTE")
    private Sexo sexo;

    @Column(name = "PLANO_PACIENTE")
    private String planoSaude;

    @Column(name = "FL_ATIVO")
    private Boolean ativo = true;

    @Column(name = "DT_CADASTRO", updatable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    private void prePersist() {
        this.dataCadastro = LocalDateTime.now();
        this.ativo = true;
    }

}

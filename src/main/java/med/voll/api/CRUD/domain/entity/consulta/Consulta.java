package med.voll.api.CRUD.domain.entity.consulta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import med.voll.api.CRUD.core.enums.StatusConsulta;
import med.voll.api.CRUD.domain.entity.medico.Medico;
import med.voll.api.CRUD.domain.entity.paciente.Paciente;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_CONSULTA")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Long id;

    @Column(name = "DT_HORA_CONSULTA", updatable = false, nullable = false)
    private LocalDateTime dataHoraConsulta;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_CONSULTA")
    private StatusConsulta statusConsulta;

    @Column(name = "OBSERVACAO", length = 500)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MEDICO", nullable = false)
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PACIENTE", nullable = false)
    private Paciente paciente;

}

package med.voll.api.CRUD.domain.repository.consulta;

import med.voll.api.CRUD.domain.entity.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByMedicoIdAndDtConsultaAndHrInicioConsultaAndStatusConsultaIn(
            Long idMedico,
            LocalDate dtConsulta,
            LocalTime hrInicioConsulta,
            List<String> status
    );
}

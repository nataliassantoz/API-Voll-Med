package med.voll.api.CRUD.domain.repository.consulta;

import med.voll.api.CRUD.domain.entity.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

import static med.voll.api.CRUD.domain.repository.consulta.ConsultaRepositoryImpl.EXISTE_CONSULTA_CONFLITANTE;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query(nativeQuery = true, value = EXISTE_CONSULTA_CONFLITANTE)
    boolean existeConsultaConflitante(
            Long idMedico,
            LocalDateTime inicio,
            LocalDateTime fim,
            List<String> status
    );
}


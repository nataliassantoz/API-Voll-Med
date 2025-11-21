package med.voll.api.CRUD.domain.repository.medico;

import med.voll.api.CRUD.domain.entity.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {


Optional<Medico> findById(Long id);
}

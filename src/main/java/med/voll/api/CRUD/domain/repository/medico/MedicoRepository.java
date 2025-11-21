package med.voll.api.CRUD.domain.repository.medico;

import med.voll.api.CRUD.api.dto.MedicoDTO;
import med.voll.api.CRUD.domain.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {



}

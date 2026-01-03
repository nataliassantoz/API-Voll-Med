package med.voll.api.CRUD.domain.repository.medico;

import med.voll.api.CRUD.core.enums.Especialidade;
import med.voll.api.CRUD.domain.entity.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {


Optional<Medico> findById(Long id);
Optional<Medico> findByCrm(String crm);
Optional<Medico> findByNome(String nome);
Optional<Medico> findByEmail(String dsEmail);
Page<Medico> findByEspecialidadeAndAtivoTrue(Especialidade especialidade, Pageable pageable);
Page<Medico> findAll(Pageable pageable);
Page<Medico> findByAtivoTrue(Pageable pageable);
}

package med.voll.api.CRUD.domain.repository.paciente;

import med.voll.api.CRUD.domain.entity.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{


    Optional<Paciente> findByCpf(String cpf);
    Page<Paciente> findByNomeContainingIgnoreCaseAndAtivoTrue(String nome, Pageable pageable);
    Optional<Paciente> findByEmail(String dsEmail);
}

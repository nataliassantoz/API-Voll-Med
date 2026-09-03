package med.voll.api.CRUD.domain.repository.profissional;

import med.voll.api.CRUD.domain.entity.profissional.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static med.voll.api.CRUD.domain.repository.profissional.impl.ProfissionalRepositoryImpl.BUSCAR;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @Query(nativeQuery = true, value = BUSCAR)
    void buscar(Long id, String dsNome, String cpf, String dsEspecialidade, String tpProfissional, String dsEmail,
             String nrTelefone, Boolean flAtivo, LocalDateTime dtCadastro, String dsConselho, String nrRegistro);
}

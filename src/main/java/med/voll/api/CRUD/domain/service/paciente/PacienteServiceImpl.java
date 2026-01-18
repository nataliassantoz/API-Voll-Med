package med.voll.api.CRUD.domain.service.paciente;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.api.dto.PacienteDTO;
import med.voll.api.CRUD.api.dto.PacienteMapper;
import med.voll.api.CRUD.api.exception.ServiceException;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.core.response.ApiResultUtil;
import med.voll.api.CRUD.domain.entity.paciente.Paciente;
import med.voll.api.CRUD.domain.repository.paciente.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@Transactional
@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService{

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;
    private final ApiResultUtil<PacienteDTO.Response.Paciente> api;

    @Override
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> cadastrar(PacienteDTO.Request.Paciente pacienteReq){

        Optional<Paciente> pacienteOpt = pacienteRepository.findByCpf(pacienteReq.getNrCpf());

        if(pacienteOpt.isPresent()){
            throw new ServiceException(
                    "Paciente " +  pacienteReq.getDsNome() + " - CPF " + pacienteReq.getNrCpf() + " já cadastrado na base de dados."
            );
        }

        if (pacienteRepository.findByEmail(pacienteReq.getDsEmail()).isPresent()) {
            throw new ServiceException(
                    "E-mail " + pacienteReq.getDsEmail() + " já cadastrado na base de dados."
            );
        }

        Paciente paciente = new Paciente();

        paciente.setNome(pacienteReq.getDsNome());
        paciente.setCpf(pacienteReq.getNrCpf());
        paciente.setEmail(pacienteReq.getDsEmail());
        paciente.setTelefone(pacienteReq.getNrTelefone());
        paciente.setDataNascimento(LocalDate.parse(pacienteReq.getDtNascimento()));
        paciente.setEndereco(pacienteReq.getDsEndereco());
        paciente.setSexo(pacienteReq.getTpSexo());
        paciente.setPlanoSaude(pacienteReq.getDsPlanoSaude());

        pacienteRepository.save(paciente);

        PacienteDTO.Response.Paciente response = pacienteMapper.toResponse(paciente);
        return api.resultSucesso(OK, response);
    }
}

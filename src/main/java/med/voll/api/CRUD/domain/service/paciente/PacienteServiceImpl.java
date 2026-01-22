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

        validarPacienteNaoExistente(pacienteReq.getNrCpf(), pacienteReq.getDsNome());

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
        paciente.setDataNascimento(pacienteReq.getDtNascimento());
        paciente.setEndereco(pacienteReq.getDsEndereco());
        paciente.setSexo(pacienteReq.getTpSexo());
        paciente.setPlanoSaude(pacienteReq.getDsPlanoSaude());

        pacienteRepository.save(paciente);

        PacienteDTO.Response.Paciente response = pacienteMapper.toResponse(paciente);
        return api.resultSucesso(OK, response);
    }

    @Override
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> atualizar(PacienteDTO.Request.Paciente pacienteReq){

        Paciente paciente = buscarPacienteExistente(pacienteReq.getNrCpf());

        paciente.setEndereco(pacienteReq.getDsEndereco());
        paciente.setTelefone(pacienteReq.getNrTelefone());
        paciente.setPlanoSaude(pacienteReq.getDsPlanoSaude());
        paciente.setEmail(pacienteReq.getDsEmail());

        pacienteRepository.save(paciente);
        PacienteDTO.Response.Paciente response = pacienteMapper.toResponse(paciente);
        return api.resultSucesso(OK, response);
    }

    @Override
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> buscarPaciente(String cpf) {
        Paciente paciente = buscarPacienteExistente(cpf);
        PacienteDTO.Response.Paciente response = pacienteMapper.toResponse(paciente);
        return api.resultSucesso(OK, response);
    }

    @Override
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> desativarPaciente(String cpf) {
        return alterarStatusPaciente(cpf, false);
    }

    @Override
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> ativarPaciente(String cpf) {
        return alterarStatusPaciente(cpf, true);
    }

    private void validarPacienteNaoExistente(String cpf, String nome) {
        if (pacienteRepository.findByCpf(cpf).isPresent()) {
            throw new ServiceException("Paciente %s - CPF: %s já cadastrado na base de dados.".formatted(nome, cpf));
        }
    }

    private Paciente buscarPacienteExistente(String cpf) {
        return pacienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new ServiceException("Paciente - CPF: %s não encontrado na base de dados.".formatted(cpf)));
    }

    private ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> alterarStatusPaciente(
            String cpf, boolean ativo) {

        Paciente paciente = buscarPacienteExistente(cpf);
        paciente.setAtivo(ativo);
        pacienteRepository.save(paciente);

        PacienteDTO.Response.Paciente response = pacienteMapper.toResponse(paciente);
        return api.resultSucesso(OK, response);
    }



}

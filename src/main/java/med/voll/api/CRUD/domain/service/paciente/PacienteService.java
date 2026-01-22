package med.voll.api.CRUD.domain.service.paciente;

import med.voll.api.CRUD.api.dto.PacienteDTO;
import med.voll.api.CRUD.core.response.ApiResult;
import org.springframework.http.ResponseEntity;

public interface PacienteService {

    ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> cadastrar(PacienteDTO.Request.Paciente pacienteReq);
    ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> atualizar(PacienteDTO.Request.Paciente pacienteReq);
    ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> buscarPaciente(String cpf);
    ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> desativarPaciente(String cpf);
    ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> ativarPaciente(String cpf);



    }

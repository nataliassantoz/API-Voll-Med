package med.voll.api.CRUD.domain.service.paciente;

import med.voll.api.CRUD.api.dto.PacienteDTO;
import med.voll.api.CRUD.core.response.ApiResult;
import org.springframework.http.ResponseEntity;

public interface PacienteService {

    ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> cadastrar(PacienteDTO.Request.Paciente pacienteReq);
}

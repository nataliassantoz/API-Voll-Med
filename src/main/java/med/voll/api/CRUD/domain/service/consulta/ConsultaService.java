package med.voll.api.CRUD.domain.service.consulta;

import med.voll.api.CRUD.api.dto.ConsultaDTO;
import med.voll.api.CRUD.core.response.ApiResult;
import org.springframework.http.ResponseEntity;

public interface ConsultaService {
    ResponseEntity<ApiResult<ConsultaDTO.Response.Consulta>> agendarConsulta(ConsultaDTO.Request.Consulta consulta);
}

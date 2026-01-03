package med.voll.api.CRUD.domain.service.medico;

import med.voll.api.CRUD.api.dto.MedicoDTO;
import med.voll.api.CRUD.api.dto.common.PageResponse;
import med.voll.api.CRUD.core.enums.Especialidade;
import med.voll.api.CRUD.core.response.ApiResult;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MedicoService {

    ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> cadastrar (MedicoDTO.Request.Medico medico);
    ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> atualizar (MedicoDTO.Request.Medico medicoReq);
    ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> buscar (String crm);
    ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> ativarMedico (String crm);
    ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> desativarMedico (String crm);
    ResponseEntity<ApiResult<PageResponse<MedicoDTO.Response.Medico>>> listarMedicos (Pageable pageable);
    ResponseEntity<ApiResult<PageResponse<MedicoDTO.Response.Medico>>> buscarPorEspecialidade
            (Especialidade especialidade, Pageable pageable);
    ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> buscarPeloNome (String nome);

    }

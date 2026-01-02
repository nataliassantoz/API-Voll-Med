package med.voll.api.CRUD.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.api.dto.MedicoDTO;
import med.voll.api.CRUD.api.dto.common.PageResponse;
import med.voll.api.CRUD.core.enums.Especialidade;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.domain.entity.medico.Medico;
import med.voll.api.CRUD.domain.service.medico.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value = "medico", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;


    @PostMapping(value = "cadastrar")
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> cadastrar (@RequestBody @Valid MedicoDTO.Request.Medico medico){
        return medicoService.cadastrar(medico);
    }

    @PatchMapping(value = "atualizar")
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> atualizar (@RequestBody @Valid MedicoDTO.Request.Medico medico){
        return medicoService.atualizar(medico);
    }

    @GetMapping(value = "buscar")
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> buscar (MedicoDTO.CdCrm crm){
        return medicoService.buscar(crm);
    }

    @GetMapping(value = "ativarMedico")
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> ativarMedico (MedicoDTO.CdCrm crm){
        return medicoService.ativarMedico(crm);
    }

    @GetMapping(value = "desativarMedico")
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> desativarMedico (MedicoDTO.CdCrm crm){
        return medicoService.desativarMedico(crm);
    }

    @GetMapping(value = "listarTodosMedicos")
    public ResponseEntity<ApiResult<PageResponse<MedicoDTO.Response.Medico>>> listarMedicos (Pageable pageable){
        return medicoService.listarMedicos(pageable);
    }





    }

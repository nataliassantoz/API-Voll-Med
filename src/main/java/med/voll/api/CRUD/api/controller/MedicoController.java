package med.voll.api.CRUD.api.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.api.dto.MedicoDTO;
import med.voll.api.CRUD.api.dto.common.PageResponse;
import med.voll.api.CRUD.core.enums.Especialidade;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.domain.service.medico.MedicoService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static med.voll.api.CRUD.core.constants.ValidationConstants.CRM_MENSAGEM_INVALIDA;
import static med.voll.api.CRUD.core.constants.ValidationConstants.CRM_REGEX;

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
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> buscar (
            @Pattern(regexp = CRM_REGEX, message = CRM_MENSAGEM_INVALIDA) @RequestParam String crm){
        return medicoService.buscar(crm);
    }

    @PatchMapping(value = "ativarMedico")
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> ativarMedico (
            @Pattern(regexp = CRM_REGEX, message = CRM_MENSAGEM_INVALIDA)
            @RequestParam String crm){
        return medicoService.ativarMedico(crm);
    }

    @PatchMapping(value = "desativarMedico")
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> desativarMedico (
            @Pattern(regexp = CRM_REGEX, message = CRM_MENSAGEM_INVALIDA)
            @RequestParam String crm){
    return medicoService.desativarMedico(crm);
    }

    @GetMapping(value = "listarTodosMedicos")
    public ResponseEntity<ApiResult<PageResponse<MedicoDTO.Response.Medico>>> listarMedicos (Pageable pageable){
        return medicoService.listarMedicos(pageable);
    }

    @GetMapping(value = "listarMedicosPorEspecialidade")
    public ResponseEntity<ApiResult<PageResponse<MedicoDTO.Response.Medico>>> buscarPorEspecialidade
            (@RequestParam Especialidade especialidade, Pageable pageable){
        return medicoService.buscarPorEspecialidade(especialidade, pageable);
    }

    @GetMapping(value = "buscarPorNome")
    ResponseEntity<ApiResult<PageResponse<MedicoDTO.Response.Medico>>> buscarPeloNome (
            @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
            @RequestParam String nome, Pageable pageable){
        return medicoService.buscarPeloNome(nome, pageable);
    }

}

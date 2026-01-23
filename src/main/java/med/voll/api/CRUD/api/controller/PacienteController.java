package med.voll.api.CRUD.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.api.dto.PacienteDTO;
import med.voll.api.CRUD.api.swagger.responses.ResponseCreateOk;
import med.voll.api.CRUD.api.swagger.responses.ResponseGetOk;
import med.voll.api.CRUD.api.swagger.responses.ResponseUpdateOk;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.domain.service.paciente.PacienteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pacientes", description = "Endpoints para gerenciamento de pacientes da clínica")
@Validated
@RestController
@RequestMapping(value = "pacientes", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @ResponseCreateOk
    @PostMapping("/cadastrar")
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> cadastrar (
            @RequestBody @Valid PacienteDTO.Request.Paciente paciente){
        return pacienteService.cadastrar(paciente);
    }

    @ResponseUpdateOk
    @PatchMapping("/atualizar")
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> atualizar (
            @RequestBody @Valid PacienteDTO.Request.Paciente paciente){
        return pacienteService.atualizar(paciente);
    }

    @ResponseGetOk
    @GetMapping("/{cpf}")
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> buscar (@PathVariable String cpf){
        return pacienteService.buscarPaciente(cpf);
    }

    @ResponseUpdateOk
    @PatchMapping("/{cpf}/desativar")
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> desativarPaciente(@PathVariable String cpf){
        return pacienteService.desativarPaciente(cpf);
    }

    @ResponseUpdateOk
    @PatchMapping("/{cpf}/ativar")
    public ResponseEntity<ApiResult<PacienteDTO.Response.Paciente>> ativarPaciente(@PathVariable String cpf){
        return pacienteService.ativarPaciente(cpf);
    }
}

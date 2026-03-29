package med.voll.api.CRUD.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.api.dto.ConsultaDTO;
import med.voll.api.CRUD.api.swagger.responses.ResponseCreateOk;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.domain.service.consulta.ConsultaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value = "consulta", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;


    @ResponseCreateOk
    @PostMapping(value = "agendar")
    public ResponseEntity<ApiResult<ConsultaDTO.Response.Consulta>> cadastrar (@RequestBody @Valid ConsultaDTO.Request.Consulta consulta){
        return consultaService.agendarConsulta(consulta);
    }
}

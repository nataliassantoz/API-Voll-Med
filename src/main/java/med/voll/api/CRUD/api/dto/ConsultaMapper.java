package med.voll.api.CRUD.api.dto;

import med.voll.api.CRUD.domain.entity.consulta.Consulta;
import org.mapstruct.Mapping;

public interface ConsultaMapper {

    @Mapping(source = "id", target = "idConsulta")
    @Mapping(source = "dataConsulta", target = "dtConsulta")
    @Mapping(source = "horaInicioConsulta", target = "hrInicioConsulta")
    @Mapping(source = "horaFimConsulta", target = "hrFimConsulta")
    @Mapping(source = "statusConsulta", target = "statusConsulta")
    @Mapping(source = "observacao", target = "dsObservacao")
    @Mapping(source = "medico", target = "medico")
    @Mapping(source = "paciente", target = "paciente")
    ConsultaDTO.Response.Consulta toResponse(Consulta entity);

    @Mapping(source = "idConsulta", target = "id")
    @Mapping(source = "dtConsulta", target = "dataConsulta")
    @Mapping(source = "hrInicioConsulta", target = "horaInicioConsulta")
    @Mapping(source = "hrFimConsulta", target = "horaFimConsulta")
    @Mapping(source = "statusConsulta", target = "statusConsulta")
    @Mapping(source = "dsObservacao", target = "observacao")
    @Mapping(source = "medico", target = "medico")
    @Mapping(source = "paciente", target = "paciente")
    Consulta toEntity(ConsultaDTO.Request.Consulta consulta);
}

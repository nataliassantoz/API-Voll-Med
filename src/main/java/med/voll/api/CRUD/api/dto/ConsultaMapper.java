package med.voll.api.CRUD.api.dto;

import med.voll.api.CRUD.domain.entity.consulta.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    @Mapping(source = "id", target = "idConsulta")
    @Mapping(source = "observacao", target = "dsObservacao")
    @Mapping(source = "medico.id", target = "medico.idMedico")
    @Mapping(source = "medico.nome", target = "medico.dsNome")
    @Mapping(source = "medico.especialidade", target = "medico.dsEspecialidade")
    @Mapping(source = "paciente.cpf", target = "paciente.nrCpf")
    @Mapping(source = "paciente.nome", target = "paciente.dsNome")
    ConsultaDTO.Response.Consulta toResponse(Consulta entity);


    @Mapping(source = "dsObservacao", target = "observacao")
    @Mapping(source = "statusConsulta", target = "statusConsulta")
    @Mapping(source = "dataHoraConsulta", target = "dataHoraConsulta")
    @Mapping(target = "medico", ignore = true)
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "id", ignore = true)
    Consulta toEntity(ConsultaDTO.Request.Consulta consulta);
}

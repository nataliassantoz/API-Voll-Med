package med.voll.api.CRUD.api.dto;

import med.voll.api.CRUD.domain.entity.medico.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

        @Mapping(source = "dsNome", target = "nome")
        @Mapping(source = "cdCrm", target = "crm")
        @Mapping(source = "dsEspecialidade", target = "especialidade")
        @Mapping(source = "dsEmail", target = "email")
        @Mapping(source = "nrTelefone", target = "telefone")
        Medico toEntity(MedicoDTO.Request.Medico request);

        @Mapping(source = "nome", target = "dsNome")
        @Mapping(source = "crm", target = "cdCrm")
        @Mapping(source = "especialidade", target = "dsEspecialidade")
        @Mapping(source = "email", target = "dsEmail")
        @Mapping(source = "telefone", target = "nrTelefone")
        @Mapping(source = "ativo", target = "flAtivo")
        MedicoDTO.Response.Medico toResponse(Medico entity);
    }

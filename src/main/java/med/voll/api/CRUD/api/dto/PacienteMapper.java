package med.voll.api.CRUD.api.dto;

import med.voll.api.CRUD.domain.entity.paciente.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    @Mapping(source = "dsNome", target = "nome")
    @Mapping(source = "nrCpf", target = "cpf")
    @Mapping(source = "dsEmail", target = "email")
    @Mapping(source = "nrTelefone", target = "telefone")
    @Mapping(source = "dsEndereco", target = "endereco")
    @Mapping(source = "tpSexo", target = "sexo")
    @Mapping(source = "dsPlanoSaude", target = "planoSaude")
    @Mapping(target = "dataNascimento", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCadastro", ignore = true)
    Paciente toEntity(PacienteDTO.Request.Paciente request);

    @Mapping(source = "nome", target = "dsNome")
    @Mapping(source = "cpf", target = "nrCpf")
    @Mapping(source = "email", target = "dsEmail")
    @Mapping(source = "telefone", target = "nrTelefone")
    @Mapping(source = "endereco", target = "dsEndereco")
    @Mapping(source = "sexo", target = "tpSexo")
    @Mapping(source = "planoSaude", target = "dsPlanoSaude")
    @Mapping(source = "ativo", target = "ativo")
    @Mapping(target = "dtNascimento", ignore = true)
    PacienteDTO.Response.Paciente toResponse(Paciente entity);
}

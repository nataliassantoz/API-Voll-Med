package med.voll.api.CRUD.api.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import med.voll.api.CRUD.core.enums.Especialidade;
import med.voll.api.CRUD.core.enums.TipoProfissional;
import med.voll.api.CRUD.core.validation.CpfValido;

import java.util.List;

public enum ProfissionalDTO {;

    public interface DsNome{

        @Schema(example = "Maria Silva")
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        String getDsNome();
    }

    public interface DsEspecialidade{

        @Schema(example = "CARDIOLOGIA")
        @NotNull(message = "Especialidade é obrigatória")
        Especialidade getDsEspecialidade();
    }

    public interface DsEmail {

        @Schema(example = "maria.silva@clinica.com")
        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail inválido. Ex: nome@dominio.com")
        String getDsEmail();
    }

    public interface NrTelefone {

        @Schema(example = "11987654321")
        @NotBlank(message = "Telefone é obrigatório")
        @Pattern(regexp = "^\\d{10,11}$",message = "Telefone inválido. Use DDD + número (10 ou 11 dígitos)")
        String getNrTelefone();
    }

    public interface FlAtivo {

        @NotNull
        Boolean getFlAtivo();
    }

    public interface Cpf{

        @Schema(example = "01234567899")
        @NotBlank(message = "Cpf é obrigatório")
        @CpfValido
        String getCpf();
    }

    public interface TpProfissional {

        @Schema(example = "MEDICO")
        @NotNull(message = "Tipo do profissional é obrigatório")
        TipoProfissional getTpProfissional();
    }

    public interface DsConselho {

        @Schema(example = "CRM")
        @NotBlank(message = "Conselho é obrigatório")
        String getDsConselho();
    }

    public interface NrRegistro {

        @Schema(example = "123456")
        @NotBlank(message = "Número do registro é obrigatório")
        String getNrRegistro();
    }

    public enum Request {;

        @Data
        public static class Profissional implements DsNome, DsEspecialidade, TpProfissional, DsEmail, NrTelefone,
                DsConselho, NrRegistro, Cpf {

            private String dsNome;
            private Especialidade dsEspecialidade;
            private TipoProfissional tpProfissional;
            private String dsEmail;
            private String nrTelefone;
            private String dsConselho;
            private String nrRegistro;
            private String cpf;

        }
    }

    public enum Response{;

        @Data
        public static class Profissional implements DsNome, DsEspecialidade, TpProfissional, DsEmail, NrTelefone,
                DsConselho, NrRegistro, FlAtivo {

            private String dsNome;
            private Especialidade dsEspecialidade;
            private TipoProfissional tpProfissional;
            private String dsEmail;
            private String nrTelefone;
            private String dsConselho;
            private String nrRegistro;
            private Boolean flAtivo;
        }

        public record PageResponse<T>(
                List<T> content,
                int page,
                int size,
                long totalElements,
                int totalPages
        ) {}
    }
}

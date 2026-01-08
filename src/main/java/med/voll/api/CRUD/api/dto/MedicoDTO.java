package med.voll.api.CRUD.api.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import med.voll.api.CRUD.core.enums.Especialidade;

import java.util.List;


public enum MedicoDTO {;

    public interface DsNome{

        @Schema(example = "Maria Silva")
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        String getDsNome();
    }

    public interface CdCrm{

        @Schema(example = "CRM-SP 123456")
        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "^CRM[- ]?[A-Z]{2}[- ]?\\d{1,6}$", message = "CRM inválido. Use o formato: CRM-UF 123456")
        String getCdCrm();
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

    public enum Request {;

        @Data
        public static class Medico
                implements DsNome, CdCrm, DsEspecialidade, DsEmail, NrTelefone {

            private String dsNome;
            private String cdCrm;
            private Especialidade dsEspecialidade;
            private String dsEmail;
            private String nrTelefone;
        }
    }

    public enum Response{;

        @Data
        public static class Medico
                implements DsNome, CdCrm, DsEspecialidade, DsEmail, NrTelefone, FlAtivo {

            private String dsNome;
            private String cdCrm;
            private Especialidade dsEspecialidade;
            private String dsEmail;
            private String nrTelefone;
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

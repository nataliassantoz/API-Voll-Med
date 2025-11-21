package med.voll.api.CRUD.api.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;
import med.voll.api.CRUD.core.enums.Especialidade;


public enum MedicoDTO {;

    public interface DsNome{

        @Schema(example = "Maria Silva")
        @NotBlank
        String getDsNome();
    }

    public interface CdCrm{

        @Schema(example = "ABC321DF")
        @NotBlank
        String getCdCrm();
    }

    public interface DsEspecialidade{

        @Schema(example = "CARDIOLOGIA")
        @NotBlank
        Especialidade getDsEspecialidade();
    }

    public interface DsEmail {

        @Schema(example = "maria.silva@clinica.com")
        @NotBlank
        @Email
        String getDsEmail();
    }

    public interface NrTelefone {

        @Schema(example = "11987654321")
        @NotBlank
        String getNrTelefone();
    }

    public enum Response{;

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
}

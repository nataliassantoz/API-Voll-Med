package med.voll.api.CRUD.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import med.voll.api.CRUD.core.enums.Sexo;
import med.voll.api.CRUD.core.validation.CpfValido;

import java.time.LocalDate;

public enum PacienteDTO {;

    public interface DsNome{

        @Schema(example = "Maria Silva")
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        String getDsNome();
    }

    public interface NrCpf{

        @Schema(example = "01234567899")
        @NotBlank(message = "Cpf é obrigatório")
        @CpfValido
        String getNrCpf();
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

    public interface DsEndereco{

        @Schema(example = "Rua Ruby 401")
        @NotBlank(message = "Endereço é obrigatório")
        String getDsEndereco();
    }

    public interface DtNascimento{

        @Schema(example = "1998-05-21", description = "Data de nascimento no formato ISO (yyyy-MM-dd)")
        @NotNull(message = "Data de nascimento é obrigatória")
        @Past(message = "Data de nascimento deve ser uma data passada")
        LocalDate getDtNascimento();
    }

    public interface TpSexo {

        @Schema(example = "FEMININO")
        @NotNull(message = "Sexo é obrigatório")
        Sexo getTpSexo();
    }

    public interface DsPlanoSaude {

        @Schema(example = "UNIMED")
        @NotBlank(message = "Plano de saúde é obrigatório")
        String getDsPlanoSaude();
    }

    public enum Request {;

        @Data
        public static class Paciente
                implements DsNome, NrCpf, DsEmail, NrTelefone, DsEndereco,DtNascimento,TpSexo, DsPlanoSaude {

            private String dsNome;
            private String nrCpf;
            private String dsEmail;
            private String nrTelefone;
            private String dsEndereco;
            private LocalDate dtNascimento;
            private Sexo tpSexo;
            private String dsPlanoSaude;
        }
    }

    public enum Response {;

        @Data
        public static class Paciente implements DsNome, NrCpf, DsEmail, NrTelefone, DsEndereco, DtNascimento, TpSexo, DsPlanoSaude {

            private String dsNome;
            private String nrCpf;
            private Sexo tpSexo;
            private String dsPlanoSaude;
            private Boolean isAtivo;
            private String dsEmail;
            private String dsEndereco;
            private String nrTelefone;
            private LocalDate dtNascimento;
        }
    }
}


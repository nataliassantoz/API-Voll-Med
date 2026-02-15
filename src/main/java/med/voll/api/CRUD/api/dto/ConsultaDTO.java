package med.voll.api.CRUD.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import med.voll.api.CRUD.core.enums.StatusConsulta;
import med.voll.api.CRUD.core.validation.CpfValido;

import java.time.LocalDate;
import java.time.LocalTime;

public enum ConsultaDTO {;

    public interface DtConsulta{

        @Schema(example = "2026-02-05", description = "Data da consulta no formato ISO (yyyy-MM-dd)")
        @NotNull(message = "Data da consulta é obrigatória")
        @Future(message = "Data da consulta deve ser uma data futura")
        LocalDate getDtConsulta();
    }

    public interface HrInicioConsulta {

        @Schema(example = "14:30", description = "Hora da consulta no formato HH:mm")
        @NotNull(message = "Hora da consulta é obrigatória")
        LocalTime getHrInicioConsulta();
    }

    public interface HrFimConsulta {

        @Schema(example = "15:00", description = "Hora de término da consulta no formato HH:mm")
        @NotNull(message = "Hora fim da consulta é obrigatória")
        LocalTime getHrFimConsulta();
    }

    public interface StConsulta {

        @Schema(example = "AGENDADA", description = "Status atual da consulta")
        @NotNull(message = "Status da consulta é obrigatório")
        String getStatusConsulta();
    }

    public interface DsObservacao {

        @Schema( example = "Paciente relatou dor abdominal há 3 dias", description = "Observações gerais sobre a consulta")
        @Size(max = 500, message = "Observação deve ter no máximo 500 caracteres")
        String getDsObservacao();
    }

    public interface IdMedico {

        @Schema(example = "1", description = "Identificador do médico")
        @NotNull(message = "Médico é obrigatório")
        Long getIdMedico();
    }

    public interface NrCpfPaciente {

        @Schema(example = "12345678901", description = "CPF do paciente (somente números)")
        @NotBlank(message = "CPF do paciente é obrigatório")
        @CpfValido
        String getNrCpfPaciente();
    }

    public interface IdConsulta {

        @Schema(example = "100", description = "Identificador da consulta")
        @NotNull(message = "Id da consulta é obrigatório")
        Long getIdConsulta();
    }

    public interface MedicoResumo {

        @Schema(description = "Dados resumidos do médico")
        Medico getMedico();

        @Data
        class Medico {
            private Long idMedico;
            private String dsNome;
            private String dsEspecialidade;
        }
    }

    public interface PacienteResumo {

        @Schema(description = "Dados resumidos do paciente")
        Paciente getPaciente();

        @Data
        class Paciente {
            private String nrCpf;
            private String dsNome;
        }
    }


    public enum Request {;

        @Data
        public static class Consulta implements
                DtConsulta, HrInicioConsulta, HrFimConsulta, IdMedico, NrCpfPaciente, DsObservacao, StConsulta {

            private LocalDate dtConsulta;
            private LocalTime hrInicioConsulta;
            private LocalTime hrFimConsulta;
            private Long idMedico;
            private String nrCpfPaciente;
            private String dsObservacao;
            private String statusConsulta;
        }
    }

    public enum Response {;

        @Data
        public static class Consulta implements
                IdConsulta,DtConsulta, HrInicioConsulta,HrFimConsulta, StConsulta,DsObservacao,MedicoResumo, PacienteResumo {

            private Long idConsulta;
            private LocalDate dtConsulta;
            private LocalTime hrInicioConsulta;
            private LocalTime hrFimConsulta;
            private StatusConsulta statusConsulta;
            private String dsObservacao;
            private MedicoResumo.Medico medico;
            private PacienteResumo.Paciente paciente;
        }
    }
}


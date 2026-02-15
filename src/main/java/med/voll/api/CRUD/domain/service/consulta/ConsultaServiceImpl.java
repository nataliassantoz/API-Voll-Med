package med.voll.api.CRUD.domain.service.consulta;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.api.dto.ConsultaDTO;
import med.voll.api.CRUD.api.dto.ConsultaMapper;
import med.voll.api.CRUD.api.dto.common.PageResponse;
import med.voll.api.CRUD.api.exception.ServiceException;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.core.response.ApiResultUtil;
import med.voll.api.CRUD.domain.entity.consulta.Consulta;
import med.voll.api.CRUD.domain.repository.consulta.ConsultaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static med.voll.api.CRUD.core.enums.StatusConsulta.AGENDADA;
import static med.voll.api.CRUD.core.enums.StatusConsulta.CONFIRMADA;
import static org.springframework.http.HttpStatus.OK;


@Transactional
@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService{

    private final ConsultaRepository consultaRepository;
    private final Consulta consulta;
    private final ConsultaMapper consultaMapper;
    private final ApiResultUtil<ConsultaDTO.Response.Consulta> api;
    private final ApiResultUtil<PageResponse<ConsultaDTO.Response.Consulta>> apiPage;

    @Override
    public ResponseEntity<ApiResult<ConsultaDTO.Response.Consulta>> agendarConsulta(ConsultaDTO.Request.Consulta consulta){

        boolean horarioOcupado = consultaRepository
                .existsByMedicoIdAndDtConsultaAndHrInicioConsultaAndStatusConsultaIn(
                        consulta.getIdMedico(),
                        consulta.getDtConsulta(),
                        consulta.getHrInicioConsulta(),
                        List.of(AGENDADA.getDescricao(), CONFIRMADA.getDescricao())
                );

        if(horarioOcupado){
            throw new ServiceException("O médico já possui uma consulta agendada nesse horário. " +
                    "Por favor, escolha outro horário disponível."
            );
        }

        consulta.setStatusConsulta(AGENDADA.getDescricao());

        Consulta consultaAgenda = consultaMapper.toEntity(consulta);
        consultaRepository.save(consultaAgenda);

        ConsultaDTO.Response.Consulta response = consultaMapper.toResponse(consultaAgenda);
        return api.resultSucesso(OK, response);
    }




}

package med.voll.api.CRUD.domain.service.medico;

import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.api.dto.MedicoDTO;
import med.voll.api.CRUD.api.dto.MedicoMapper;
import med.voll.api.CRUD.api.dto.common.PageResponse;
import med.voll.api.CRUD.api.exception.ServiceException;
import med.voll.api.CRUD.core.enums.Especialidade;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.core.response.ApiResultUtil;
import med.voll.api.CRUD.domain.entity.medico.Medico;
import med.voll.api.CRUD.domain.repository.medico.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class MedicoServiceImpl implements MedicoService{

    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;
    private final ApiResultUtil<MedicoDTO.Response.Medico> api;
    private final ApiResultUtil<PageResponse<MedicoDTO.Response.Medico>> apiPage;

    @Override
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> cadastrar(MedicoDTO.Request.Medico medicoReq){

        Optional<Medico> medicoOpt = medicoRepository.findByCrm(medicoReq.getCdCrm());

        if (medicoOpt.isPresent()) {
            throw new ServiceException(
                    "Médico " +  medicoReq.getDsNome() + "- CRM " + medicoReq.getCdCrm() + " já cadastrado na base de dados."
            );
        }

        Medico medico = new Medico();
        medico.setNome(medicoReq.getDsNome());
        medico.setCrm(medicoReq.getCdCrm());
        medico.setEspecialidade(medicoReq.getDsEspecialidade());
        medico.setEmail(medicoReq.getDsEmail());
        medico.setTelefone(medicoReq.getNrTelefone());

        Medico medicoSalvo = medicoRepository.save(medico);

        MedicoDTO.Response.Medico response =
                medicoMapper.toResponse(medicoSalvo);

        return api.resultSucesso(OK, response);
    }

    @Override
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> atualizar (MedicoDTO.Request.Medico medicoReq){

        Medico medico = buscarMedicoPorCrm(medicoReq.getCdCrm());

        medico.setEspecialidade(medicoReq.getDsEspecialidade());
        medico.setEmail(medicoReq.getDsEmail());
        medico.setTelefone(medicoReq.getNrTelefone());

        Medico medicoSalvo = medicoRepository.save(medico);
        MedicoDTO.Response.Medico response =
                medicoMapper.toResponse(medicoSalvo);

        return api.resultSucesso(OK, response);
    }

    @Override
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> buscar (MedicoDTO.CdCrm crm){

        Medico medico = buscarMedicoPorCrm(crm.getCdCrm());

        MedicoDTO.Response.Medico response =
                medicoMapper.toResponse(medico);
        return api.resultSucesso(OK, response);
    }

    @Override
    public ResponseEntity<ApiResult<PageResponse<MedicoDTO.Response.Medico>>> buscarPorEspecialidade
            (Especialidade especialidade, Pageable pageable){

        Page<Medico> page;
        page = medicoRepository.findByEspecialidadeAndAtivoTrue(
                especialidade, pageable);

        PageResponse<MedicoDTO.Response.Medico> response =
                PageResponse.from(page, medicoMapper::toResponse);
        return apiPage.resultSucesso(OK, response);
    }

    @Override
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> ativarMedico (MedicoDTO.CdCrm crm){
        Medico medico = buscarMedicoPorCrm(crm.getCdCrm());

        medico.setAtivo(true);
        medicoRepository.save(medico);
        return api.resultSucesso(OK);
    }

    @Override
    public ResponseEntity<ApiResult<MedicoDTO.Response.Medico>> desativarMedico (MedicoDTO.CdCrm crm){
        Medico medico = buscarMedicoPorCrm(crm.getCdCrm());

        medico.setAtivo(false);
        medicoRepository.save(medico);
        return api.resultSucesso(OK);
    }

    @Override
    public ResponseEntity<ApiResult<PageResponse<MedicoDTO.Response.Medico>>> listarMedicos (Pageable pageable){

        Page<Medico> page = medicoRepository.findByAtivoTrue(pageable);

        PageResponse<MedicoDTO.Response.Medico> response =
                PageResponse.from(page, medicoMapper::toResponse);

        return apiPage.resultSucesso(OK, response);
    }



    private Medico buscarMedicoPorCrm(String crm) {
        return medicoRepository.findByCrm(crm)
                .orElseThrow(() -> new ServiceException(
                        "Médico - CRM " + crm + " não encontrado na base de dados."
                ));
    }











}

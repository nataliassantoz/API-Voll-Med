package med.voll.api.CRUD.domain.repository.consulta;

public class ConsultaRepositoryImpl {

    public static final String EXISTE_CONSULTA_CONFLITANTE = """
        SELECT COUNT(*) > 0
                FROM tb_consulta c
                WHERE c.id_medico = :idMedico
                  AND c.status_consulta IN (:status)
                  AND c.dt_hora_consulta < :fim
                  AND c.dt_hora_consulta >= :inicio;
    """;
}

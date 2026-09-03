package med.voll.api.CRUD.domain.repository.profissional.impl;

public class ProfissionalRepositoryImpl {

    public static final String BUSCAR = """
        SELECT
            P.ID_PROFISSISONAL      AS id,
            P.NOME_PROFISSISONAL    AS dsNome,
            P.CPF_PROFISSISONAL     AS cpf,
            P.ID_ESPECIALIDADE      AS dsEspecialidade,
            P.TP_PROFISSIONAL       AS tpProfissional,
            P.EMAIL_PROFISSISONAL   AS dsEmail,
            P.TELEFONE_PROFISSISONAL AS nrTelefone,
            P.DS_CONSELHO           AS dsConselho,
            P.REGISTRO_PROFISSIONAL AS nrRegistro,
            P.FLATIVO_PROFISSISONAL AS flAtivo,
            P.DT_CADASTRO           AS dtCadastro
        FROM TB_PROFISSIONAL P
        WHERE  (:id IS NULL OR P.ID_PROFISSISONAL = :id)
            AND (:dsNome IS NULL OR UPPER(TRIM(P.NOME_PROFISSISONAL))
                            LIKE '%' || UPPER(TRIM(:dsNome)) || '%')

            AND (:cpf IS NULL OR UPPER(TRIM(P.CPF_PROFISSISONAL))
                            LIKE '%' || UPPER(TRIM(:cpf)) || '%')

            AND (:dsEspecialidade IS NULL OR P.ID_ESPECIALIDADE = :dsEspecialidade)

            AND (:tpProfissional IS NULL OR P.TP_PROFISSIONAL = :tpProfissional)

            AND (:dsEmail IS NULL OR UPPER(TRIM(P.EMAIL_PROFISSISONAL))
                  LIKE '%' || UPPER(TRIM(:dsEmail)) || '%')

            AND (:nrTelefone IS NULL OR UPPER(TRIM(P.TELEFONE_PROFISSISONAL))
                  LIKE '%' || UPPER(TRIM(:nrTelefone)) || '%')

            AND (:dsConselho IS NULL OR UPPER(TRIM(P.DS_CONSELHO))
                  LIKE '%' || UPPER(TRIM(:dsConselho)) || '%')

            AND (:nrRegistro IS NULL OR UPPER(TRIM(P.REGISTRO_PROFISSIONAL))
                  LIKE '%' || UPPER(TRIM(:nrRegistro)) || '%')

            AND (:flAtivo IS NULL OR P.FLATIVO_PROFISSISONAL = :flAtivo)

            AND (:dtCadastro IS NULL OR P.DT_CADASTRO = :dtCadastro)
    """;
}

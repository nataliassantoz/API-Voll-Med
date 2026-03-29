CREATE UNIQUE INDEX uk_consulta_medico_data_hora_ativa
ON tb_consulta (id_medico, dt_hora_consulta)
WHERE status_consulta IN ('AGENDADA', 'CONFIRMADA');
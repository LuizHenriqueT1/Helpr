/*Montagem da Proc para relatório semanal de tarefas encerradas pelo cliente*/

DELIMITER //
CREATE PROCEDURE sps_tarefas_encerradas_cliente_semanal(
IN cliente INT,
IN dt_busca_hoje DATE
)
BEGIN
    CREATE TEMPORARY TABLE tmp_tarefas_encerradas_semana AS
    SELECT *
    FROM chamado WHERE cliente_id=cliente AND status=2 AND (data_fechamento BETWEEN (dt_busca_hoje - INTERVAL 7 DAY) AND dt_busca_hoje);
    SELECT * FROM tmp_tarefas_encerradas_semana;
    DROP TABLE tmp_tarefas_encerradas_semana;
END //
DELIMITER ;

CALL sps_tarefas_encerradas_cliente_semanal(10, "2022-07-04");
DROP PROCEDURE sps_tarefas_encerradas_cliente_semanal;

select * from chamado;
select * from pessoa;
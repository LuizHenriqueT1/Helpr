DELIMITER //
CREATE PROCEDURE sps_relatorio_chamado_aberto_andamento(IN data_hoje DATE)
BEGIN
    CREATE TEMPORARY TABLE tmp_relatorio_chamado AS
    SELECT *
    FROM chamado WHERE data_abertura = data_hoje AND status = 0 OR status = 1;
    SELECT * FROM tmp_relatorio_chamado;
    DROP TABLE tmp_relatorio_chamado;
END //
DELIMITER ;

CALL  sps_relatorio_chamado_aberto_andamento("2022-06-27");
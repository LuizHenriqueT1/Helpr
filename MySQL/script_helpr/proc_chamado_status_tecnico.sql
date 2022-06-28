DELIMITER //
    CREATE PROCEDURE sps_verifica_chamado_status(IN tec_id INT,  IN dt_busca_init DATETIME, IN dt_busca_fim DATETIME)
    BEGIN
        CREATE TEMPORARY TABLE tmp_chamados_status
            SELECT tecnico_id, status, COUNT(status)as quantidade_status FROM chamado 
            WHERE tecnico_id = tec_id AND data_abertura BETWEEN dt_busca_init AND dt_busca_fim 
            GROUP BY status;
            select * from tmp_chamados_status;
            drop table tmp_chamados_status;
    END //
DELIMITER ;

CALL sps_verifica_chamado_status(1,"2022-06-13","2022-06-30");

use helpr_hyrsa;
DELIMITER //
    CREATE PROCEDURE sps_verifica_chamado_status(IN IdCliente INT,  IN dt_busca_init DATETIME, IN dt_busca_fim DATETIME)
    BEGIN
        CREATE TEMPORARY TABLE tmp_chamados_status
            SELECT cliente_id, status, COUNT(status)as quantidade_status FROM chamado 
            WHERE cliente_id = IdCliente AND data_abertura BETWEEN dt_busca_init AND dt_busca_fim 
            GROUP BY status;
            select * from tmp_chamados_status;
            drop table tmp_chamados_status;
    END //
DELIMITER ;
DROP PROCEDURE sps_verifica_chamado_status;

CALL sps_verifica_chamado_status(9,"2022-06-13","2022-06-30");


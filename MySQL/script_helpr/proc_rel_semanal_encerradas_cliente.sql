DELIMITER //
CREATE PROCEDURE sps_rel_semanal_chamados_enc_cliente(
IN idCliente INT,
IN dataAtual DATE
)
BEGIN
    CREATE TEMPORARY TABLE tmp_rel_semanal_cliente AS
    SELECT *
    FROM chamado WHERE cliente_id=idCliente AND status=2 AND (data_fechamento BETWEEN (dataAtual - INTERVAL 7 DAY) AND dataAtual);
    SELECT * FROM tmp_rel_semanal_cliente;
    DROP TABLE tmp_rel_semanal_cliente;
END //
DELIMITER ;

CALL sps_rel_semanal_chamados_enc_cliente(idCliente, "dataAtual");
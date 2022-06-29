DELIMITER //
CREATE PROCEDURE sps_chamados_abertos_cliente(
IN cliente INT
)
BEGIN
	CREATE TEMPORARY TABLE tmp_chamados_abertos_cliente AS
    SELECT * FROM chamado WHERE cliente=cliente_id AND status=0;
    SELECT * FROM tmp_chamados_abertos_cliente;
    DROP TABLE tmp_chamados_abertos_cliente;
END
//
DELIMITER ;
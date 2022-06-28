USE helpr_hyrsa;

DELIMITER //
CREATE PROCEDURE sps_tecnicos_andamento(
IN tecnicos_andamento INT
)
BEGIN
	CREATE TEMPORARY TABLE tmp_tecnico_andamento
    SELECT * FROM chamado WHERE tecnicos_andamento = tecnico_id AND status = 1;
    SELECT * FROM tmp_tecnico_andamento;
    DROP TABLE tmp_tecnico_andamento;
END
//
DELIMITER ;

CALL sps_tecnicos_andamento(1);
USE helpr_hyrsa;

DELIMITER //
CREATE PROCEDURE sps_relatorio_status(
IN status_busca INT,
IN data_inicial_busca DATETIME,
IN data_final_busca DATETIME
)
BEGIN
	CREATE TEMPORARY TABLE tmp_relatorio_status
    SELECT * FROM chamado
    WHERE status=status_busca AND data_abertura BETWEEN data_inicial_busca AND data_final_busca
    ORDER BY data_abertura ASC;
    SELECT * FROM tmp_relatorio_status;
    DROP TABLE tmp_relatorio_status;
END
//
DELIMITER ;

CALL sps_relatorio_status(2,"2022-06-13","2022-06-18");
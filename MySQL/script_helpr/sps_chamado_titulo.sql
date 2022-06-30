USE helpr_hyrsa;

DELIMITER //
CREATE PROCEDURE sps_chamado_titulo(
IN titulo_busca VARCHAR(200)
)
BEGIN
    CREATE TEMPORARY TABLE tmp_chamado_titulo
    SELECT * FROM chamado WHERE LOWER(titulo) LIKE LOWER(CONCAT('%', titulo_busca, '%'));
    SELECT * FROM tmp_chamado_titulo;
    DROP TABLE tmp_chamado_titulo;
END
//
DELIMITER ;

CALL sps_chamado_titulo("bug");
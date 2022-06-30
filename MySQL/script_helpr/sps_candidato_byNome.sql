USE helpr_hyrsa;

DELIMITER //
CREATE PROCEDURE sps_candidato_byNome(
IN candidato_byNome VARCHAR(255)
)
BEGIN
	CREATE TEMPORARY TABLE tmp_candidato_byNome
    SELECT * FROM candidato WHERE nome LIKE LOWER(CONCAT('%', candidato_byNome, '%'));
    SELECT * FROM tmp_candidato_byNome;
    DROP TABLE tmp_candidato_byNome;
END
//
DELIMITER ;

CALL sps_candidato_byNome("Paulo");
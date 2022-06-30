 use helpr_hyrsa;
 
DELIMITER //
CREATE PROCEDURE sps_tecnicos_nomes(
IN tecnicos_nomes VARCHAR(200)
)
BEGIN
    CREATE TEMPORARY TABLE tmp_tecnico_nomes
     SELECT * FROM pessoa WHERE nome LIKE LOWER(CONCAT('%', tecnicos_nomes, '%')) AND dtype = "Tecnico";
    SELECT * FROM tmp_tecnico_nomes;
    DROP TABLE tmp_tecnico_nomes;
END
//
DELIMITER ;

CALL sps_tecnicos_nomes("Victor");

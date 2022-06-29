DELIMITER //
CREATE PROCEDURE sps_rel_chamados_enc_hoje_tecnicos()
BEGIN
    CREATE TEMPORARY TABLE tmp_rel_enc_tecnicos AS
    SELECT *
    FROM chamado WHERE STATUS=2 AND data_fechamento = CURRENT_DATE ;
    SELECT * FROM tmp_rel_enc_tecnicos ;
    DROP TABLE tmp_rel_enc_tecnicos ;
END //
DELIMITER ;

CALL sps_rel_chamados_enc_hoje_tecnicos ();
use helpr_hyrsa;
DELIMITER //
CREATE PROCEDURE sps_chamados_abertos_soma_dia_tecnico(
IN tecnico INT,
IN dataAtual DATE
)
BEGIN
CREATE TEMPORARY TABLE tmp_soma_dia_tecnico AS
SELECT * FROM chamado WHERE tecnico_id=tecnico AND status=1 AND data_abertura=dataAtual;
SELECT COUNT(id) AS n_abertos FROM tmp_soma_dia_tecnico;
DROP TABLE tmp_soma_dia_tecnico;
END
//
DELIMITER ;
CALL sps_chamados_abertos_soma_dia_tecnico(1, "2022-06-02");
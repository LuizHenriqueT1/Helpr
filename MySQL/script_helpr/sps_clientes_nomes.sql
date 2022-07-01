DELIMITER //
CREATE PROCEDURE sps_clientes_nomes(
IN clientes_nomes VARCHAR(200)
)
BEGIN
     CREATE TEMPORARY TABLE tmp_cliente_nomes
	 SELECT * FROM pessoa WHERE nome LIKE LOWER(CONCAT('%',clientes_nomes,'%')) AND dtype = "Cliente";
	 SELECT * FROM tmp_cliente_nomes;
	 DROP TABLE tmp_cliente_nomes;
END
//
DELIMITER ;

CALL sps_clientes_nomes("Tony");

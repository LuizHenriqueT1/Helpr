CREATE TABLE log_chamado_Perfil(
id INT NOT NULL AUTO_INCREMENT,
dt_alteracao DATETIME NOT NULL,
dado_alterado VARCHAR(250) NOT NULL,
novo_dado VARCHAR(250) NOT NULL,
id_pessoa INT NOT NULL,
PRIMARY KEY(id)
);

DELIMITER //
CREATE TRIGGER tg_log_chamado_Perfil BEFORE UPDATE ON pessoa
FOR EACH ROW 
BEGIN
	IF(NEW.dtype <> OLD.dtype) THEN
		INSERT INTO log_chamado_Perfil(dt_alteracao, dado_alterado,novo_dado, id_pessoa)
        VALUES(NOW(), OLD.dtype, NEW.dtype, NEW.id);
    END IF;
END //
DELIMITER ;

select * from log_chamado_Perfil;
select * from pessoa;
UPDATE pessoa SET dtype = "Tecnico" where id = 9;
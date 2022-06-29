DELIMITER //
CREATE TRIGGER tg_log_tecnico_exclusao BEFORE DELETE ON pessoa
FOR EACH ROW 
BEGIN
	IF(OLD.dtype="Tecnico") THEN
		INSERT log_tecnico_exclusao(data_exclusao, id_tecnico, nome_tecnico)
        VALUES(NOW(), OLD.id, OLD.nome);
    END IF;
END //
DELIMITER ;
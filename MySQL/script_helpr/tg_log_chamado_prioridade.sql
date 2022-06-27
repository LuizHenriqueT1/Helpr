use helpr_hyrsa;
DELIMITER //
CREATE TRIGGER tg_log_prioridade_chamado BEFORE UPDATE 
ON chamado
FOR EACH ROW
BEGIN
	IF(OLD.prioridade <> NEW.prioridade) THEN
		INSERT INTO log_chamado_prioridade(data_alteracao, dado_alterado, dado_novo, dev_correcao)
        VALUES(NOW(), OLD.prioridade, NEW.prioridade, NULL);
	END IF;
END //
DELIMITER ;

use helpr_hyrsa;
select * from log_chamado_prioridade;
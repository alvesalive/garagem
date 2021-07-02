CREATE DATABASE titan;

USE titan;

CREATE TABLE `titan`.`tbl_movimentacao` ( `id` INT NULL AUTO_INCREMENT , `placa` VARCHAR(8) NULL , `modelo` VARCHAR(15) NULL , `data_entrada` DATE NOT NULL , `data_saida` DATE NOT NULL , `tempo` FLOAT NOT NULL , `valor_pago` FLOAT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;


CREATE TABLE `titan`.`tbl_usuario` ( `id` INT NULL AUTO_INCREMENT , `nome` VARCHAR(50) NULL , `usuario` VARCHAR NULL , `senha` INT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;


CREATE TABLE `titan`.`tbl_valor` ( `id` INT NULL AUTO_INCREMENT , `valor_primeira_hora` FLOAT NULL , `valor_demais_horas` FLOAT NOT NULL , `data_fim` DATE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;


INSERT INTO `tbl_valor` (`id`, `valor_primeira_hora`, `valor_demais_horas`, `data_fim`) VALUES ('1', '6.00', '4.00', '')

INSERT INTO `tbl_usuario` (`id`, `nome`, `usuario`, `senha`) VALUES ('1', 'admin', 'admin', '123456');


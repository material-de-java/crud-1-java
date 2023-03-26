-- DROP PROCEDURE IF EXISTS db1.SelectEmpleados;

CREATE PROCEDURE SelectEmpleados(IN var varchar(100) )
BEGIN
	
	SET @qry = CONCAT('SELECT * FROM empleados WHERE CONCAT(nombre, \' \',apellido) LIKE \'%', var, '%\'');
	PREPARE stmt FROM @qry;
	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;


	
END

-- CALL SelectEmpleados(); 





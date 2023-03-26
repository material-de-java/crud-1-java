-- **************************************************************

-- DROP PROCEDURE IF EXISTS db1.SelectEmpleados;

CREATE PROCEDURE SelectEmpleados(IN var varchar(100) )
BEGIN
	
	SET @qry = CONCAT('SELECT * FROM empleados WHERE CONCAT(nombre, \' \',apellido) LIKE \'%', var, '%\'');
	PREPARE stmt FROM @qry;
	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;
END

-- CALL SelectEmpleados(); 
-- **************************************************************

-- DROP PROCEDURE IF EXISTS db1.InsertEmpleados;

CREATE PROCEDURE InsertEmpleados(IN nom varchar(100), IN ape varchar(100), IN dir varchar(100), IN tel varchar(100) )
BEGIN
	INSERT INTO empleados (nombre,apellido,direccion,telefono)
	VALUES (nom,ape,dir,tel);
END

-- CALL InsertEmpleados('paco','montes','calle19','999'); 
-- **************************************************************

-- DROP PROCEDURE IF EXISTS db1.UpdateEmpleados;

CREATE PROCEDURE UpdateEmpleados(IN nom varchar(100), IN ape varchar(100), IN dir varchar(100), IN tel varchar(100), IN idin int )
BEGIN
	UPDATE empleados SET nombre=nom,apellido=ape,direccion=dir,telefono=tel
	WHERE id=idin;
END

-- CALL UpdateEmpleados('nuevo','valor','calle000','77777',1);
-- **************************************************************

-- DROP PROCEDURE IF EXISTS db1.DeleteEmpleados;

CREATE PROCEDURE DeleteEmpleados(IN idin int )
BEGIN
	DELETE FROM empleados
	WHERE id=idin;
END

-- CALL DeleteEmpleados(1);
-- **************************************************************

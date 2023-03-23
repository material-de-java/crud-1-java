CREATE TABLE db1.empleados (
	id INT auto_increment NULL,
	nombre VARCHAR(100) NOT NULL,
	apellido VARCHAR(100) NOT NULL,
	direccion varchar(100) NOT NULL,
	telefono varchar(100) NOT NULL,
	CONSTRAINT empleados_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


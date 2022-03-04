DROP TABLE IF exists tienen;
DROP TABLE IF exists producen;
DROP TABLE IF exists alergias;
DROP TABLE IF exists realiza_peticiones;
DROP TABLE IF exists platos;
DROP TABLE IF exists categorias;
DROP TABLE IF exists ordenes;
DROP TABLE IF exists usuarios;
DROP TABLE IF exists roles;

CREATE TABLE roles (
id int AUTO_INCREMENT PRIMARY KEY,
nombre varchar (50) NOT NULL
);

CREATE TABLE usuarios (
id int AUTO_INCREMENT PRIMARY KEY,
usuario varchar (20) NOT NULL,
pass_usuario varchar (255) NOT NULL,
email varchar (50),
id_rol int,
FOREIGN KEY(id_rol) REFERENCES roles(id) ON DELETE CASCADE ON UPDATE CASCADE
);
    
CREATE TABLE ordenes (
id int AUTO_INCREMENT PRIMARY KEY,
fecha DATE NOT NULL,
id_usuario int,
FOREIGN KEY(id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE
);
 
CREATE TABLE categorias (
id int AUTO_INCREMENT PRIMARY KEY,
nombre varchar (50) NOT NULL
);

CREATE TABLE platos (
id int AUTO_INCREMENT PRIMARY KEY,
nombre varchar (75) NOT NULL,
foto Blob,
id_categoria int,
FOREIGN KEY(id_categoria) REFERENCES categorias(id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*TABLA REALCIONAL: PLATOS - ORDENES */

CREATE TABLE realiza_peticiones (
id int AUTO_INCREMENT PRIMARY KEY,
id_orden int,
id_plato int,
FOREIGN KEY(id_orden) REFERENCES ordenes(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(id_plato) REFERENCES platos(id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*TABLA ALERGIAS, VERIFICAR LOS ATRIBUTOS */
 
CREATE TABLE alergias (
id int AUTO_INCREMENT PRIMARY KEY,
nombre varchar (50) NOT NULL
);

/*TABLA REALCIONAL: PLATOS - ALERGIAS */

CREATE TABLE producen (
id int AUTO_INCREMENT PRIMARY KEY,
id_plato int,
id_alergia int,
FOREIGN KEY(id_plato) REFERENCES platos(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(id_alergia) REFERENCES alergias(id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*TABLA REALCIONAL: USUARIOS - ALERGIAS, VERIFICAR EL VERBO */

CREATE TABLE tienen (
id int AUTO_INCREMENT PRIMARY KEY,
id_usuario int,
id_alergia int,
FOREIGN KEY(id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(id_alergia) REFERENCES alergias(id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*  RECABAR DEFINICIÓN DE LOS ROLES, TANTO PARA ADMINISTRADOR COMO PARA USUARIO*/
insert into roles (nombre) VALUES ('Usuario');
insert into roles (nombre) VALUES ('Administrador');
    
insert into usuarios (usuario, pass_usuario, email, id_rol) VALUES
	('Carl19', '123A', 'carl@fantasymail.com', 1),
    ('Friedrich20', '123B', 'friedrich@fantasymail.com', 2),
    ('Ludwig11','123C', 'ludwig@fantasymail.com', 1),
    ('Lou', '123D', 'lou@fantasymail.com', 1),
    ('Fiodor', '123E', 'fiodor@fantasymail.com', 1);


insert into ordenes (fecha, id_usuario) VALUES
	('1997-12-06', 1),
    ('1997-12-06', 2),
    ('1997-12-06', 3),
    ('1997-12-06', 4),
    ('1997-12-06', 5);
    
insert into categorias (nombre) VALUES
	('carnes'),
    ('postres'),
    ('sopas'),
    ('pescados'),
    ('entrepanes');
    
insert into platos (nombre, id_categoria) VALUES
	('carne al grill', 1),
    ('postre de melocoton', 2),
    ('sopas de champiñones', 3),
    ('pescados sin espinas', 4),
    ('entrepanes al ajillo', 5);
    
insert into realiza_peticiones (id_orden, id_plato) VALUES
	(1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);
    
insert into alergias (nombre) VALUES
	('alergia a la carne'),
    ('alergia a los mariscos'),
    ('alergia al gluten'),
    ('alergia a los dátiles'),
    ('alergia a la lactosa');
    
insert into producen (id_plato, id_alergia) VALUES
	(1 , 1),
    (2 , 2),
    (3 , 3),
    (4 , 4),
    (5 , 5);
    
insert into tienen (id_usuario, id_alergia) VALUES
	(1 , 1),
    (2 , 2),
    (3 , 3),
    (4 , 4),
    (5 , 5);
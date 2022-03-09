DROP SCHEMA IF EXISTS el_imperio;

CREATE SCHEMA el_imperio;
USE el_imperio;

CREATE TABLE cliente(id INT PRIMARY KEY,
		   nombre VARCHAR(50) NOT NULL,
                    especie VARCHAR(50) NOT NULL,
                    genero VARCHAR(50) NOT NULL
                    );

CREATE TABLE vehiculo  (matricula INT AUTO_INCREMENT PRIMARY KEY, 
			nombre VARCHAR(25) NOT NULL, 
                        velocidad DOUBLE, 
                        longitud DOUBLE
                        ) AUTO_INCREMENT = 5001;
                        
CREATE TABLE ligero	(matricula INT PRIMARY KEY,  
                        color VARCHAR(15),  
                        androide VARCHAR(15),  
                        FOREIGN KEY (matricula) REFERENCES vehiculo(matricula)
                        );

CREATE TABLE transporte	(matricula INT PRIMARY KEY, 
			tripulantes INT NOT NULL, 
                        pasajeros INT NOT NULL, 
                        FOREIGN KEY(matricula) REFERENCES vehiculo(matricula)
                        );
                        
CREATE TABLE capitan	(licencia INT AUTO_INCREMENT PRIMARY KEY, 
						nombre VARCHAR(50) NOT NULL, 
						especie VARCHAR(50) NOT NULL, 
						v_matricula INT NOT NULL, 
						FOREIGN KEY(v_matricula) REFERENCES transporte(matricula)
						) AUTO_INCREMENT = 1001;
                    
CREATE TABLE alquiler	(alquiler_id INT AUTO_INCREMENT PRIMARY KEY, 
						cliente_id INT NOT NULL, 
						vehiculo INT NOT NULL, 
						fecha DATETIME NOT NULL, 
						ocasion VARCHAR(50) NOT NULL, 
						duracion INT NOT NULL, 
						costo DOUBLE NOT NULL, 
						FOREIGN KEY(cliente_id) REFERENCES cliente(id), 
						FOREIGN KEY(vehiculo) REFERENCES vehiculo(matricula)
						) AUTO_INCREMENT = 7001;

INSERT INTO cliente VALUES(4561, "Luke Skywalker", "Humano", "Masculino");
INSERT INTO cliente VALUES(9872, "Leia Organa", "Humano", "Femenino");
INSERT INTO cliente VALUES(3543, "Rey Skywalker", "Humano", "Femenino");
INSERT INTO cliente VALUES(5074, "Obi-Wan Kenobi", "Humano", "Masculino");
INSERT INTO cliente VALUES(8135, "Maz Kanata", "Humanoide", "Femenino");
INSERT INTO cliente VALUES(3726, "Anakin Skywalker", "Humano", "Masculino");
INSERT INTO cliente VALUES(1277, "Yoda", "Yoda", "Masculino");
INSERT INTO cliente VALUES(2228, "Ahsoka Tano", "Togruta", "Femenino");
INSERT INTO cliente VALUES(9179, "Grogu", "Yoda", "Masculino");
INSERT INTO cliente VALUES(7510, "Aayla Secura", "Twi'lek", "Femenino");
INSERT INTO cliente VALUES(1881, "Chewbacca", "Wookiee", "Masculino");
INSERT INTO cliente VALUES(6142, "Wicket W. Warrick", "Ewok", "Masculino");

INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Halcón Milenario", 75, 34.37);
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Ala-X", 100, 12.5);
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Ala-Y", 80, 14);
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Ala-A", 120, 9.6);
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Interceptor TIE", 105, 9.2);				
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Esclavo 1", 70, 21.1);
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Destructor Estelar", 60, 1600);
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Estrella de la Muerte", 10, 120000);
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Transbordador Imperial", 50, 20);
INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES("Ejecutor", 40, 19000);

INSERT INTO ligero VALUES(5002, "BLANCO/ROJO", "R2-D2");
INSERT INTO ligero VALUES(5003, "AMARILLO", "C-3PO");
INSERT INTO ligero VALUES(5004, "ROJO", NULL);
INSERT INTO ligero VALUES(5005, "NEGRO", "Androide TIE");

INSERT INTO transporte VALUES(5001, 4, 6);
INSERT INTO transporte VALUES(5006, 1, 6);
INSERT INTO transporte VALUES(5007, 47060, 0);
INSERT INTO transporte VALUES(5008, 342953, 843342);
INSERT INTO transporte VALUES(5009, 6, 20);
INSERT INTO transporte VALUES(5010, 279144, 38000);

INSERT INTO capitan VALUES(1001, "Han Solo", "Humano", 5001);
INSERT INTO capitan VALUES(1002, "Jango Fett", "Mandaloriano", 5006);
INSERT INTO capitan VALUES(1003, "General Grievous", "Androide", 5007);
INSERT INTO capitan VALUES(1004, "Grand Moff Tarkin", "Humano", 5008);
INSERT INTO capitan VALUES(1005, "Darth Vader", "Humano/Androide", 5009);
INSERT INTO capitan VALUES(1006, "Kendal Ozzel", "Humano", 5010);

INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(4561, 5006, '2005-05-19 00:00:00', "La Venganza de los Sith", 4, 238.03);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(9872, 5006, '2018-05-25 00:00:00', "Han Solo", 10, 252.99);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(3543, 5009, '2015-12-18 00:00:00', "El Despertar de la Fuerza", 14, 1095.27);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(4561, 5001, '2018-05-25 00:00:00', "Han Solo", 15, 374.64);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(5074, 5008, '1999-05-19 00:00:00', "La Amenaza Fantasma", 18, 1145.38);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(9872, 5009, '2018-05-25 00:00:00', "Han Solo", 17, 839.24);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(8135, 5010, '2017-12-15 00:00:00', "Los Últimos JEDI", 17, 1396.31);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(3543, 5006, '1999-05-19 00:00:00', "La Amenaza Fantasma", 24, 826.54);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(4561, 5003, '1999-05-19 00:00:00', "La Amenaza Fantasma", 9, 427.71);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(3726, 5006, '2018-05-25 00:00:00', "Han Solo", 7, 556.67);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(5074, 5006, '2015-12-18 00:00:00', "El Despertar de la Fuerza", 9, 451.35);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(9872, 5008, '1977-05-25 00:00:00', "Una nueva esperanza", 9, 395.32);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(1277, 5005, '2018-05-25 00:00:00', "Han Solo", 13, 1099.22);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(8135, 5002, '2002-05-16 00:00:00', "El Ataque de los Clones", 11, 833.2);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(3543, 5008, '2019-12-20 00:00:00', "El Ascenso de Skywalker", 23, 528.94);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(2228, 5010, '1983-05-25 00:00:00', "El Retorno del JEDI", 11, 207.56);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(3726, 5004, '2017-12-15 00:00:00', "Los Últimos JEDI", 15, 492.47);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(5074, 5008, '2016-12-16 00:00:00', "Rogue One", 11, 742.71);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(9179, 5010, '2016-12-16 00:00:00', "Rogue One", 24, 175.44);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(1277, 5002, '1983-05-25 00:00:00', "El Retorno del JEDI", 13, 1016.47);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(8135, 5004, '2016-12-16 00:00:00', "Rogue One", 7, 19.04);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(7510, 5001, '2019-12-20 00:00:00', "El Ascenso de Skywalker", 24, 387.95);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(2228, 5008, '2002-05-16 00:00:00', "El Ataque de los Clones", 19, 1024.49);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(3726, 5004, '2002-05-16 00:00:00', "El Ataque de los Clones", 20, 444.75);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(9179, 5004, '2005-05-19 00:00:00', "La Venganza de los Sith", 4, 69.09);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(1277, 5003, '1999-05-19 00:00:00', "La Amenaza Fantasma", 7, 556.8);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(7510, 5006, '2018-05-25 00:00:00', "Han Solo", 20, 272.61);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(2228, 5009, '2016-12-16 00:00:00', "Rogue One", 6, 116.87);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(9179, 5006, '1977-05-25 00:00:00', "Una nueva esperanza", 4, 285.43);
INSERT INTO alquiler(cliente_id, vehiculo, fecha, ocasion, duracion, costo) VALUES(7510, 5006, '1980-05-21 00:00:00', "El Imperio contraataca", 28, 1377.01);

-- SELECT * FROM capitan;
-- SELECT vehiculo.matricula AS "Matrícula",
-- 		vehiculo.nombre AS Nombre, 
--         velocidad AS Velocidad, 
--         longitud AS "Tamaño", 
--         IF(ligero.matricula = vehiculo.matricula, "Ligero", IF(transporte.matricula = vehiculo.matricula, "Transporte", "No Definido")) AS Tipo,
--         IF(ligero.matricula = vehiculo.matricula, IFNULL(ligero.androide, "Ninguno"), IF(transporte.matricula = vehiculo.matricula, IFNULL(capitan.nombre,"Ninguno"), "Ninguno")) AS "Androide/Capitan"
--         FROM vehiculo 
--         LEFT JOIN ligero ON vehiculo.matricula = ligero.matricula 
--         LEFT JOIN capitan ON vehiculo.matricula = capitan.v_matricula 
--         LEFT JOIN transporte ON transporte.matricula = vehiculo.matricula WHERE vehiculo.matricula = 5025;

-- SELECT LAST_INSERT_ID();
-- SELECT MAX(matricula) FROM vehiculo;

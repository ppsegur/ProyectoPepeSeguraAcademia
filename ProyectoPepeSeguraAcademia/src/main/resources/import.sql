

INSERT INTO Material (id_material, nombre, tipo, url ) VALUES(1,'material a1 ingles','video','https://youtu.be/Jzc4HDOKTKg?si=XGFRehqwEeqfgv99');
ALTER SEQUENCE Material_seq RESTART WITH 51;
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, precio) VALUES(1,'Ingles', 'a1', 25.00);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, precio) VALUES(2,'Ingles', 'a2', 25.00);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, precio) VALUES(3,'Ingles', 'b1', 25.00);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, precio) VALUES(4,'Ingles', 'b2', 25.00);


ALTER SEQUENCE Curso_seq RESTART WITH 51;

INSERT INTO Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante) VALUES(1,'pepe321', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'Pepe', 'González Pérez', 'pepe@example.com', '12345678A','2003-03-01', 'Masculino', true);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante) VALUES(2, 'marialoma', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'María', 'López Martínez', 'marialLopez@example.com', '87654321B','2002-04-01','Femenino',false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante) VALUES(3, 'user', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'Juan jose', 'López Martínez', 'Juanjp2001@example.com', '87654321B','2003-06-10','Masculino',false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante) VALUES(4, 'admin', '{bcrypt}$2a$12$yyJmcpUq.jrMOtPgRVrUVOnuIgUya/VWdQyS9KGUKGFs6sAGoiF2q', 'Zacarías', 'López Martínez', 'maria@email.com', '87654321B','2004-01-09','Masculino',true);

ALTER SEQUENCE Estudiante_seq RESTART WITH 54;














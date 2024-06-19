






INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(1,'Ingles', 'a1', '2 semanas' ,25.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(2,'Ingles', 'a2', '2 semanas' ,25.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(3,'Ingles', 'b1', '2 semanas', 40.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(4,'Ingles', 'b2', '2 semanas' ,40.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(5,'Frances', 'a1','2 semanas' , 25.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(6,'Frances', 'a2','2 semanas' , 25.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(7,'Español', 'a1','2 semanas' , 25.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(8,'Español', 'a2','2 semanas' , 25.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(9,'Español', 'b1','2 semanas' , 40.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(10,'Español', 'b2','2 semanas' , 40.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(11,'Frances', 'b1','2 semanas' , 40.00, false);
INSERT INTO Curso (id_curso,nombre,nivel_dificultad, duracion, precio, comprado) VALUES(12,'Frances', 'b2','2 semanas' , 40.00, false);
ALTER SEQUENCE Curso_seq RESTART WITH 62;

INSERT INTO Material ( id_material ,nombre,  url ,id_curso) VALUES(1,'material a1 ingles','https://youtu.be/Jzc4HDOKTKg?si=XGFRehqwEeqfgv99',1);
ALTER SEQUENCE Material_seq RESTART WITH 51;

INSERT INTO Certificado(id_certificado, nombreC, id_curso) VALUES(1,'Inglés A1',1);
INSERT INTO Certificado(id_certificado, nombreC, id_curso) VALUES(2,'Inglés A2',2);
INSERT INTO Certificado(id_certificado, nombreC, id_curso) VALUES(3,'Inglés B1',3);
INSERT INTO Certificado(id_certificado, nombreC, id_curso) VALUES(4,'Inglés B2',4);
INSERT INTO Certificado(id_certificado, nombreC,id_curso) VALUES(5,'Francés A1',5);
INSERT INTO Certificado(id_certificado, nombreC, id_curso) VALUES(6,'Francés A2',6);
ALTER SEQUENCE Certificado_seq RESTART WITH 56;

INSERT INTO Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante, suscrito) VALUES(1,'pepe321', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'Pepe', 'González Pérez', 'pepe@gmail.com', '12345678A','2003-03-01', 'Masculino', true,false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(2, 'marialoma', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'María', 'López Martínez', 'marialLopez@gmail.com', '87654321B','2002-04-01','Femenino',false, false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(3, 'user', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'Juan jose', 'López Martínez', 'Juanjp2001@gmail.com', '87657771B','2003-06-10','Masculino',false, false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(4, 'admin', '{bcrypt}$2a$12$yyJmcpUq.jrMOtPgRVrUVOnuIgUya/VWdQyS9KGUKGFs6sAGoiF2q', 'Zacarías', 'López Martínez', 'maria@email.com', '74624321B','2004-01-09','Masculino',true, false);
INSERT INTO Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(5,'Jose1', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'Jose', 'Segura Pérez', 'jose123@hotmail.com', '98765432R','2005-02-01', 'Masculino', false, false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(6, 'MariCruz', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'María Crus', 'Sanchéz Molina', 'maria1Cruz@gmail.com', '12345678I','2007-04-01','Femenino',false, false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(7, 'usuario1', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'Juan', 'Peréz Martinéz', 'usuario@gmail.com', '89817321B','2004-10-10','Masculino',false, false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(8, 'Laura', '{bcrypt}$2a$12$yyJmcpUq.jrMOtPgRVrUVOnuIgUya/VWdQyS9KGUKGFs6sAGoiF2q', 'Laura', 'Muñoz Seca', 'Lauramuseca@email.com', '77624321B','2005-03-11','Masculino',false, false);
INSERT INTO Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(9,'Mario', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'Mario', 'Cáceres Pérez', 'pmariocape@hotmail.com', '98234567F','2003-05-01', 'Masculino', false, false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(10, 'MariaO', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'María', 'Ortíz Mar', 'mariaortiz@hotmail.com', '34567988P','2004-04-01','Femenino',false, false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(11, 'Carmelo', '{bcrypt}$2a$12$958YgJdm4acEfwUiIwNANuxFHl0CHeuZh0KBkbhuYtm.RGIa54YvG', 'Carmelo', 'Moreno Martínez', 'carmeloMoreno@gmail.com', '12345678P','2007-06-10','Masculino',false, false);
INSERT INTO   Estudiante(id,username,password,nombre,apellidos,correo,dni,fecha_nacimiento,genero,no_estudiante,suscrito) VALUES(12, 'Adolfo', '{bcrypt}$2a$12$yyJmcpUq.jrMOtPgRVrUVOnuIgUya/VWdQyS9KGUKGFs6sAGoiF2q', 'Adolfo', 'Suarez Cencerro', 'asuce@hotmail.com', '1234567P','2007-01-09','Masculino',false, false);
ALTER SEQUENCE Estudiante_seq RESTART WITH 62;














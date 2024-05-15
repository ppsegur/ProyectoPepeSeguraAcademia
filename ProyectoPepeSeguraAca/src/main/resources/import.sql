INSERT INTO Material (id_material, nombre, tipo, url ) VALUES(1,'material a1 ingles','video','https://youtu.be/Jzc4HDOKTKg?si=XGFRehqwEeqfgv99');

ALTER SEQUENCE Material_seq RESTART WITH 51;

INSERT INTO Curso (id_curso,nombre,nivel_dificultad, precio) VALUES(1,'Ingles a1', 'bajo', 25.00);

ALTER SEQUENCE Curso_seq RESTART WITH 51;

INSERT INTO Usuario(id,username,contrasena,nombre,apellidos,correo,dni) VALUES (default,'pepe321', 'pepe123', 'Pepe', 'González Pérez', 'pepe@example.com', '12345678A');

INSERT INTO   Usuario (id,username,contrasena,nombre,apellidos,correo,dni) VALUES (default, 'marialoma', 'contraseña2', 'María', 'López Martínez', 'maria@example.com', '87654321B');

INSERT INTO Estudiante (id, telefono) VALUES (1, '123456789');

INSERT INTO Estudiante (id, telefono) VALUES (2, '987654321');
















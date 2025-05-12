# ProyectoPepeSeguraAcademia

**Proyecto final del primer año del ciclo de Desarrollo de Aplicaciones Multiplataforma (DAM)**.  
Se trata de una plataforma web para una academia de idiomas que permite la visualización y compra de cursos en línea. Implementado con **Spring Boot**, **Java**, **Thymeleaf** y **PostgreSQL**.

---

## 📚 Descripción

Este proyecto simula el funcionamiento básico de una academia online, donde los usuarios pueden:

- Ver cursos disponibles.
- Registrarse y autenticarse.
- Comprar cursos.
- Visualizar los vídeos embebidos desde YouTube.
- Descargar facturas en PDF tras la compra.
- Recibir correos electrónicos de confirmación.

Además, el sistema cuenta con dos tipos de roles: usuario estándar y administrador.

---

## 🛠️ Tecnologías utilizadas

- **Lenguaje principal**: Java 17
- **Framework backend**: Spring Boot
- **Plantillas del frontend**: Thymeleaf
- **Estilos y scripts**: HTML5, CSS3, JavaScript
- **Base de datos**: PostgreSQL
- **Seguridad**: Spring Security + JWT
- **Otros**:
  - Apache PDFBox (para generar facturas en PDF)
  - Spring Mail (para envío de emails)
  - Lombok (para reducir código repetitivo)
  - Bootstrap (para el diseño del frontend)

---

## 🚀 Instalación y ejecución

Sigue estos pasos para levantar el proyecto en local:

### 1. Clonar el repositorio

- git clone https://github.com/ppsegur/ProyectoPepeSeguraAcademia.git
- cd ProyectoPepeSeguraAcademia

### 2. Configurar la base de datos
- Asegúrate de tener PostgreSQL instalado y activo.

- Crea una base de datos con el nombre deseado.

### Modifica el archivo src/main/resources/application.properties con tus credenciales:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tu_basedatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
### 3. Ejecutar el proyecto
Puedes ejecutarlo desde tu IDE favorito (IntelliJ, Eclipse...) o desde consola:

bash
./mvnw spring-boot:run

### 4. Acceder a la aplicación
Abre tu navegador y visita:

http://localhost:8080

### 🔐 Accesos de prueba
Rol	Usuario	Contraseña
Usuario normal	user	1234
Administrador	admin	admin

### 📄 Documentación
Puedes encontrar la documentación completa del proyecto en el siguiente archivo PDF incluido en el repositorio:

📘 Documentacion.pdf

### 🧑‍🎓 Objetivos académicos
Este proyecto fue desarrollado con fines educativos, con los siguientes objetivos:

Aplicar la arquitectura MVC utilizando Spring Boot.

Integrar seguridad web con Spring Security y JWT.

Aprender a usar Thymeleaf como motor de plantillas.

Utilizar PostgreSQL como sistema de persistencia.

Generar documentos PDF desde el backend.

Configurar el envío de correos automáticos.

Desarrollar una experiencia realista de aplicación web empresarial.


### 👨‍💻 Autor
José Rafael Segura Rodríguez

GitHub: @ppsegur

LinkedIn: José Rafael Segura Rodríguez

Correo electrónico: pepesegurarodriguez@gmail.com

### 📌 Licencia
Este proyecto se ha realizado con fines educativos y no posee licencia comercial.

¡Gracias por visitar este proyecto! 🎓

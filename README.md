# Sistema de Registro Académico

Este proyecto es un sistema web que permite registrar profesores y alumnos, asignarles cursos, horarios y secciones. Está dividido en dos partes:

- **Backend**: desarrollado con Spring Boot y MySQL
- **Frontend**: desarrollado con Angular

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Angular 15+
- Docker (opcional)

## 🗂️ Estructura del repositorio

Este repositorio contiene dos ramas principales:

- `backend`: contiene el proyecto backend con Spring Boot y MySQL
- `frontend`: contiene el proyecto frontend con Angular

## 🧑‍🏫 Funcionalidades principales

- Registro de profesores y alumnos
- Asignación de cursos, horarios y secciones
- Gestión de relaciones entre entidades
- Interfaz web para interacción con el sistema

Cómo Empezar
Sigue estos pasos para levantar y ejecutar el proyecto localmente:

Prerequisitos
Java Development Kit (JDK) 17 o superior.
MySQL instalada y en ejecución.
Maven instalado.
Instalación y Ejecución
Clonar el Repositorio:

git clone [https://github.com/sandrocordova99/Proyecto-Spring-Backend.git](https://github.com/sandrocordova99/Proyecto-Spring-Backend.git)
cd Proyecto-Spring-Backend
Configurar la Base de Datos:

Crea una base de datos con el nombre cibertec_db (puedes usar otro nombre si lo prefieres, pero ajústalo en el application.properties).
Abre el archivo src/main/resources/application.properties.
Actualiza las propiedades de conexión a tu base de datos con tus credenciales:
spring.datasource.url=jdbc:mysql://localhost:3306/cibertec_db
spring.datasource.username=tu_usuario_db
spring.datasource.password=tu_password_db
# spring.jpa.hibernate.ddl-auto=update # Descomenta esta línea si quieres que Hibernate cree o actualice las tablas automáticamente
Construir el Proyecto:

mvn clean install
Ejecutar la Aplicación:

Desde tu IDE (IntelliJ, Eclipse, VS Code): Ejecuta la clase principal IntegradorApplication.java (o el nombre de tu clase principal con el método main).
Desde la terminal (después de construir):
java -jar target/integrador-0.0.1-SNAPSHOT.jar
(Nota: el nombre del archivo .jar puede variar ligeramente, verifica el nombre exacto en tu carpeta target después de mvn clean install.)
   

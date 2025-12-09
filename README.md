Gestor Inteligente de Tareas Académicas es una aplicación de escritorio desarrollada en Java con conexión a MySQL, diseñada para facilitar la organización de proyectos y asignaciones académicas mediante un registro estructurado de tareas y subtareas.

La aplicación permite a los usuarios gestionar fácilmente sus pendientes mediante una interfaz sencilla, ofreciendo operaciones CRUD completas (crear, leer, actualizar y eliminar). Cada tarea puede incluir múltiples subtareas y un responsable asignado. En caso de no especificar responsable, el sistema asocia la tarea automáticamente al usuario en sesión.

El sistema está construido bajo la arquitectura Modelo-Vista-Controlador (MVC) y los principios de Programación Orientada a Objetos (POO), garantizando una estructura modular, escalable y mantenible.


# Características principales

  Sistema de login y registro con gestión de múltiples usuarios.
  Registro de tareas y subtareas con relación jerárquica.
  Operaciones CRUD completas (crear, editar, eliminar y consultar).
  Interfaz gráfica clásica desarrollada con Java Swing (Forms).
  Conexión a base de datos MySQL.
  Arquitectura MVC con separación clara entre lógica, vista y datos.
  Preparado para integración futura con inteligencia artificial (procesamiento de texto).


## Futuras mejoras

Integración del módulo Hugging Face para registro automático de tareas a partir de texto.
Implementación de reconocimiento de voz.
Visualización de progreso y estadísticas de productividad.

### Integrantes: 
  Emmanuel Rios Castro
  Amanda Calderón Cordero


Para iniciar el proyecto poner los siguientes comandos en SQL:

--Se crea la base de datos

create database proyecto;
use proyecto

--Se crea la tabla lista_tareas
CREATE TABLE lista_tareas (
    id INT NOT NULL PRIMARY KEY,
    tarea VARCHAR(255),
    fecha DATE,
    responsable VARCHAR(100),
    estado VARCHAR(25),
    descripcion VARCHAR(1000),
    usuario VARCHAR(50)
);



--Se crea tabla usuarios

CREATE TABLE usuarios (
    correo VARCHAR(50) NOT NULL PRIMARY KEY,
    contrasena VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellido1 VARCHAR(255) NOT NULL,
    apellido2 VARCHAR(255) NULL
);


--Datos de ejemplo para tareas:
INSERT INTO lista_tareas (id, tarea, fecha, responsable, estado, descripcion, usuario) VALUES
(1, 'Revisar apuntes de programación intermedia', '2025-01-15', 'Emmanuel', 'Pendiente', 'Revisión general de los apuntes del curso', 'emmanuel@gita.com'),
(2, 'Hacer reporte de investigación', '2025-01-20', 'Amanda', 'Pendiente', 'Redacción del reporte final', 'amanda@gita.com'),
(3, 'Corregir exámenes del grupo A', '2025-01-18', 'Profesor', 'Pendiente', 'Correcciones del examen parcial', 'profesor@gita.com'),
(4, 'Preparar presentación de arquitectura', '2025-01-22', 'Emmanuel', 'Pendiente', 'Preparación de diapositivas', 'emmanuel@gita.com'),
(5, 'Actualizar bitácora del proyecto', '2025-01-16', 'Amanda', 'Pendiente', 'Añadir los avances de la semana', 'amanda@gita.com'),
(6, 'Revisar implementación de base de datos', '2025-01-19', 'Profesor', 'Pendiente', 'Verificar estructura y relaciones', 'profesor@gita.com'),
(7, 'Terminar la interfaz gráfica', '2025-01-25', 'Emmanuel', 'Pendiente', 'Completar módulos visuales', 'emmanuel@gita.com'),
(8, 'Escribir conclusiones del trabajo escrito', '2025-01-23', 'Amanda', 'Pendiente', 'Redactar apartado final', 'amanda@gita.com'),
(9, 'Subir notas al sistema', '2025-01-21', 'Profesor', 'Pendiente', 'Registrar calificaciones finales', 'profesor@gita.com'),
(10, 'Hacer pruebas del módulo de login', '2025-01-17', 'Emmanuel', 'Pendiente', 'Probar validaciones y errores', 'emmanuel@gita.com'),
(11, 'Revisar formato del documento final', '2025-01-27', 'Amanda', 'Pendiente', 'Verificar estilo y forma', 'amanda@gita.com'),
(12, 'Planear actividades para la semana', '2025-01-26', 'Profesor', 'Pendiente', 'Organizar cronograma semanal', 'profesor@gita.com'),
(13, 'Resolver ejercicios de SQL', '2025-01-24', 'Emmanuel', 'Pendiente', 'Ejercicios del capítulo 5', 'emmanuel@gita.com'),
(14, 'Organizar archivos del curso', '2025-01-28', 'Amanda', 'Pendiente', 'Ordenar materiales digitales', 'amanda@gita.com'),
(15, 'Verificar integridad de datos', '2025-01-29', 'Profesor', 'Pendiente', 'Comprobar reglas de consistencia', 'profesor@gita.com'),
(16, 'Escribir documentación técnica', '2025-01-30', 'Emmanuel', 'Pendiente', 'Documentación del sistema', 'emmanuel@gita.com'),
(17, 'Revisar rúbricas de evaluación', '2025-01-31', 'Profesor', 'Pendiente', 'Actualizar criterios', 'profesor@gita.com'),
(18, 'Preparar resumen para exposición', '2025-02-01', 'Amanda', 'Pendiente', 'Crear un resumen claro y breve', 'amanda@gita.com'),
(19, 'Hacer mantenimiento del repositorio', '2025-02-02', 'Emmanuel', 'Pendiente', 'Limpiar ramas y revisar commits', 'emmanuel@gita.com'),
(20, 'Revisar tareas entregadas', '2025-02-03', 'Profesor', 'Pendiente', 'Revisión de tareas del grupo B', 'profesor@gita.com');

-- Datos de ejemplo para usuarios
INSERT INTO usuarios (correo, contrasena, nombre, apellido1, apellido2)
VALUES
('emmanuel@gita.com', '1234', 'Emmanuel', 'Rios', 'Castro'),
('amanda@gita.com', '4567', 'Amanda', 'Calderon', 'Cordero'),
('profesor@gita.com', '7890', 'Profesor', 'Programacion', NULL);


Para abrir el programa se ejecuta el archivo de "Login" y se puede crear un usuario nuevo o usar alguno de los siguientes usuarios:
correo: emmanuel@gita.com
contraseña: 1234

correo:
amanda@gita.com
contraseña: 
4567

correo: profesor@gita.com
7890
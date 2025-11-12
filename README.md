Gestor Inteligente de Tareas Académicas es una aplicación de escritorio desarrollada en Java con conexión a MySQL, diseñada para facilitar la organización de proyectos y asignaciones académicas mediante un registro estructurado de tareas y subtareas.

La aplicación permite a los usuarios gestionar fácilmente sus pendientes mediante una interfaz sencilla, ofreciendo operaciones CRUD completas (crear, leer, actualizar y eliminar). Cada tarea puede incluir múltiples subtareas y un responsable asignado. En caso de no especificar responsable, el sistema asocia la tarea automáticamente al usuario en sesión.

El sistema está construido bajo la arquitectura Modelo-Vista-Controlador (MVC) y los principios de Programación Orientada a Objetos (POO), garantizando una estructura modular, escalable y mantenible.

Además, el proyecto incluye la base para un módulo de análisis inteligente de texto (clase AnalizadorIA), diseñado para integrarse en el futuro con modelos de Hugging Face, permitiendo que el sistema interprete descripciones en lenguaje natural para registrar tareas automáticamente.

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

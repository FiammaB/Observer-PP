
Observer-Pattern

Un proyecto de demostración que implementa el Patrón de Diseño Observer utilizando el robusto sistema de eventos de aplicación de Spring Boot. Este ejemplo ilustra cómo desacoplar componentes y manejar eventos de manera eficiente en una aplicación Spring.

🚀 Funcionalidades

Este proyecto demuestra los siguientes conceptos y funcionalidades:

Implementación del Patrón Observer: Muestra cómo un "sujeto" (el publicador de eventos) puede notificar a múltiples "observadores" (los listeners de eventos) sobre un cambio de estado sin tener conocimiento explícito de ellos.

Eventos Personalizados de Spring: Creación de una clase de evento (UserRegisteredEvent) que extiende ApplicationEvent para transportar información específica.

Publicación de Eventos: Uso de ApplicationEventPublisher en un servicio (UserService) para disparar el evento cuando ocurre una acción relevante (ej. registro de un usuario).

Manejo de Eventos con @EventListener: Creación de múltiples listeners (WelcomeEmailSender, UserActivityLogger) que reaccionan a eventos específicos mediante la anotación @EventListener.

Desacoplamiento de Componentes: Resalta cómo este patrón promueve una arquitectura modular donde los componentes son independientes y reutilizables.

Procesamiento Síncrono/Asíncrono de Eventos: Demostración por defecto de la naturaleza síncrona de los eventos de Spring, con una nota sobre cómo habilitar el procesamiento asíncrono para mejorar el rendimiento en escenarios reales.

🛠️ Tecnologías Utilizadas
Java 17+ 

Spring Boot 

 Gradle

⚙️ Configuración y Ejecución Local
Sigue estos pasos para configurar y ejecutar el proyecto en tu máquina local:

Prerrequisitos
Asegúrate de tener instalado lo siguiente:

JDK (Java Development Kit): Versión 17 o superior.

Maven (si usas Maven) o Gradle (si usas Gradle).

Un IDE como IntelliJ IDEA, Eclipse o VS Code con el soporte adecuado para Spring Boot.

Pasos de Configuración
Clona el Repositorio:

Bash

git clone https://[https://github.com/FiammaB/Observer-PP.git](https://github.com/FiammaB/Observer-PP).git
cd nombre-de-tu-repo


Construye el Proyecto:

Bash

gradle build
Ejecución
Puedes ejecutar la aplicación Spring Boot de varias maneras:

Desde tu IDE:
Abre el proyecto en tu IDE (IntelliJ IDEA, Eclipse, etc.). Busca la clase principal ObserverDemoApplication.java (ubicada en src/main/java/com/example/observerdemo/) y ejecútala como una aplicación Spring Boot.

Desde la Línea de Comandos (usando el JAR ejecutable):
Una vez que hayas construido el proyecto (Paso 2 de "Configuración"), encontrarás un archivo .jar ejecutable en el directorio target/ (para Maven) o build/libs/ (para Gradle).

Bash

java -jar target/ObserverSpringBootApplication.jar
(Ajusta el nombre del archivo .jar según la versión de tu proyecto).

🧪 Demostración del Flujo
Una vez que la aplicación se inicie, el CommandLineRunner en ObserverSpringBootApplication.java se ejecutará automáticamente, simulando el registro de un usuario.

Observarás la siguiente salida en la consola (o similar):

--- Iniciando prueba del patrón Observer ---
Registrando usuario: juanperez con email: juan.perez@example.com
Evento UserRegisteredEvent publicado.
WelcomeEmailSender: Enviando email de bienvenida a juan.perez@example.com para el usuario juanperez
UserActivityLogger: Registrando actividad para el usuario juanperez - Evento: UserRegisteredEvent
--- Prueba del patrón Observer finalizada ---
Esta salida demuestra cómo:

UserService registra al usuario y publica el UserRegisteredEvent.

WelcomeEmailSender y UserActivityLogger (nuestros observadores) escuchan y reaccionan al evento de forma independiente, ejecutando su lógica específica (enviar un correo de bienvenida y registrar actividad, respectivamente).

📂 Estructura del Proyecto
observer-demo/
├── src/main/java/com/example/observerdemo/
│   ├── ObserverDemoApplication.java  # Clase principal de Spring Boot
│   ├── events/
│   │   └── UserRegisteredEvent.java  # Evento personalizado (Sujeto Observable)
│   ├── listeners/
│   │   ├── WelcomeEmailSender.java   # Observador 1: Envía email de bienvenida
│   │   └── UserActivityLogger.java   # Observador 2: Registra actividad del usuario
│   └── service/
│       └── UserService.java          # Publicador del evento (Sujeto)
├── pom.xml                           # Archivo de configuración de Maven (o build.gradle)
└── .gitignore                        # Archivos y directorios ignorados por Git
💡 Consideraciones Adicionales
Asincronicidad: Por defecto, los eventos de Spring son síncronos. Para procesar eventos de forma asíncrona (lo cual es útil para operaciones que no deben bloquear el hilo principal, como el envío de emails), puedes usar las anotaciones @EnableAsync en la clase principal y @Async en los métodos @EventListener.

Manejo de Errores: En una aplicación de producción, deberías implementar un manejo de errores robusto para los listeners de eventos.

Transaccionalidad: Los eventos de Spring pueden integrarse con transacciones. Si un evento se publica dentro de una transacción, puedes configurar los listeners para que reaccionen después de que la transacción se haya completado con éxito.



# Spring JDBC Client

## pom.xml
* Hay que añadir las dependencias de starters de Spring JDBC y SpringBoot MVC
* No hace falta añadir la dependencia de SLF4J, ya que Spring Boot la añade automáticamente al añadir la dependencia de Spring JDBC.
* No hay que añadir la dependencia de gestor de dependencias CDI (Weld), ya que Spring Boot ya tiene su propio gestor de dependencias.
* Hay que añadir la dependencia de Lombok para poder usar anotaciones como @Data, @Builder, etc.
* Hay que añadir la dependencia de MySQL Connector/J para poder conectarnos a la base de datos MySQL.
* Spring proporciona un pool de conexiones a la base de datos (HikariCP) y un gestor de transacciones, por lo que no hace falta añadir dependencias adicionales para ello.

## application.properties
* Hay que configurar la conexión a la base de datos MySQL, indicando el driver, la URL, el usuario y la contraseña.
* Se puede configurar el nivel de logging de Spring JDBC para ver las consultas SQL que se ejecutan

## JdbcClient
* Spring Boot proporciona un cliente JDBC llamado JdbcClient que es una capa de abstracción sobre JDBC.
* JdbcClient nos permite ejecutar consultas SQL de forma más sencilla y con menos código, además de manejar automáticamente la gestión de conexiones y transacciones.
* JdbcClient también nos permite realizar operaciones de persistencia de datos de forma más sencilla y con menos código.

## Spring Boot MVC
* Spring Boot MVC nos permite crear aplicaciones web y APIs REST de forma sencilla y con menos código.
* Spring Boot MVC nos permite crear controladores que manejan las peticiones HTTP y devuelven respuestas HTTP, además de manejar automáticamente la serialización y deserialización de objetos JSON.

### API REST
* Spring Boot MVC nos permite crear APIs REST de forma sencilla y con menos código.
* Un API REST es un conjunto de endpoints que permiten a los clientes interactuar con la aplicación a través de peticiones HTTP.
* Un endpoint es una URL que representa un recurso y que puede ser accedida mediante un método HTTP (GET, POST, PUT, DELETE, etc.).
  * Tabla resumen de los métodos HTTP más comunes y su uso en un API REST:
  
  | Método HTTP | Descripción | Ejemplo de uso | HTTP Status code esperado |
  |-------------|-------------|----------------|---------------------------|
  | GET         | Obtener un recurso o una lista de recursos | GET /pacientes | 200 OK |
  | POST        | Crear un nuevo recurso | POST /pacientes | 201 Created, 400 Bad Request |
  | PUT         | Actualizar un recurso existente | PUT /pacientes/{id} | 200 OK, 400 Bad Request, 404 Not Found |
  | DELETE      | Eliminar un recurso existente | DELETE /pacientes/{id} | 204 No Content, 404 Not Found |
  

### RestController
* Es una clase que maneja las peticiones HTTP y devuelve respuestas HTTP en formato JSON.
* Se anota con @RestController y sus métodos se anotan con @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, etc. para indicar el método HTTP que manejan y la URL del endpoint que representan.
* Puede recibir parámetros de la URL, del cuerpo de la petición o de los encabezados de la petición mediante anotaciones como @PathVariable, @RequestParam, @RequestBody, @RequestHeader, etc.
* Puede devolver objetos Java que serán serializados automáticamente a JSON mediante la librería Jackson que viene incluida en Spring Boot.
* Puede manejar excepciones y devolver respuestas HTTP con códigos de estado apropiados.

### Probando la API REST
* Se puede probar la API REST mediante herramientas como Postman, Insomnia o HTTPie.
* También mediante el cliente HTTP de Visual Studio Code o IntelliJ IDEA, que permite enviar peticiones HTTP y ver las respuestas HTTP en formato JSON.
* También mediante el uso de scripts en lenguajes como Python o JavaScript.
* Asimismo se puede usar una app frontend que consuma la API REST y muestre los datos en una interfaz gráfica, como por ejemplo una app web hecha con Vanilla JavaScript como la del ejemplo HospitalClienteJS proporcionada.

## Manejo de excepciones de manera global
* Spring Boot nos permite manejar las excepciones de manera global mediante la anotación @RestControllerAdvice
* @RestControllerAdvice nos permite definir una clase que maneje las excepciones lanzadas por los controladores de la aplicación y devuelva respuestas HTTP con códigos de estado apropiados y mensajes de error
* @ExceptionHandler nos permite definir métodos que manejen excepciones específicas y devuelvan respuestas HTTP con códigos de estado apropiados y mensajes de error

# RESTful Web Services

Social Media Application

User -> Posts

- Retrieve all Users          - GET     /users
- Create a User               - POST    /users
- Retrieve One User           - GET     /users/{id} -> /users/1
- Delete a User               - DE LETE  /users/{id} -> /users/1

- Retrieve all posts for a User - GET   /users{id}/posts
- Create a posts for user       - POST  /users/{id}/posts
- Retrieve details of a post    - GET   /users/{id}/posts/{post-id} 

Spring Boot Actuator URL
- http://localhost:8080/actuator

Spring Boot HAL Browser URL
- http://localhost:8080/browser/index.html#/

Spring Boot H2 in-memory DB URL
- http://localhost:8080/h2-console
  - JDBC URL : jdbc:h2:mem:testdb
  - Settings Name : Generic H2 (Embedded)
  - Driver Class : org.h2.Driver
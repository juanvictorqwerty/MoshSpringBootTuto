# Spring Boot Project Overview

This document provides a detailed breakdown of the files in your Spring Boot application. Your project is built using a classic **N-Tier Architecture** (also known as a layered architecture), which separates the code into Controllers, Services, Repositories, and Entities.

---

## 1. Project Configuration

### `pom.xml`
This is your **Maven Configuration File**. It tells Maven which external libraries and frameworks your project needs. You recently added:
*   **`spring-boot-starter-web`**: Provides everything needed to build web applications and RESTful APIs, including Tomcat as the default embedded web server.
*   **`spring-boot-starter-data-jpa`**: Brings in Hibernate and Spring Data features for easily saving and retrieving Java objects from a database.
*   **`postgresql`**: The official JDBC driver that allows your Java application to communicate securely with your PostgreSQL database.
*   **`spring-boot-devtools`**: Provides hot-reloading so that whenever you make Java code changes, the server restarts automatically.

### `application.properties`
This is your **Spring Boot Configuration File**. It holds all the specific settings for your application:
*   It configures the database connection (`spring.datasource.url`, `username`, `password`) pointing to your local PostgreSQL server on port `5433`.
*   It configures Hibernate (`spring.jpa.hibernate.ddl-auto=update`), which tells Hibernate to automatically create or modify your database tables to match your Java `@Entity` classes when the application starts.

---

## 2. Models / Entities
> [!NOTE]
> Entities are the core structures that represent the data in your database. Every instance (object) of these classes represents one row in your database table.

### `SoftareEngineer.java` & `Project.java`
*   **`@Entity`**: This annotation tells Hibernate to treat this class as a database table. By default, the table will have the same name as the class.
*   **`@Id`**: Marks the `id` field as the Primary Key for the table.
*   **`@GeneratedValue(strategy = GenerationType.IDENTITY)`**: Tells the database to automatically generate a unique, auto-incrementing integer every time a new row is inserted.
*   These files also include standard Java **Constructors**, **Getters**, and **Setters** which are strictly required for Spring and Hibernate to read and write the data correctly.

---

## 3. Data Access Layer (Repositories)

### `SoftwareEngineerRepo.java` & `ProjectRepo.java`
*   These are simply Java **Interfaces**.
*   They extend **`JpaRepository<EntityName, IdType>`**.
*   **Why they are magical:** Because Spring Data JPA generates the actual SQL code behind the scenes, you do not need to write actual methods to do standard things like `findAll()`, `findById()`, `save()`, or `deleteById()`. The interface inherits all those methods automatically for free.

---

## 4. Business Logic Layer (Services)
> [!TIP]
> While a Service layer might seem unnecessary for simple apps, it is a crucial best practice. It ensures your database queries are completely separated from your HTTP logic. If you ever need to perform complex calculations or call external APIs before saving to the database, you do it here.

### `SoftwareEngineerService.java` & `ProjectService.java`
*   **`@Service`**: Marks this class as a "Bean." Spring tells itself: "I need to construct one copy of this class and hand it to whoever needs it" (Dependency Injection).
*   These classes take the corresponding Repository in their constructor.
*   They provide simple wrapper methods like `getAllProjects()` or `getSoftwareEngineer(id)` that the Controllers can call.

---

## 5. Web Layer (Controllers)
> [!IMPORTANT]
> Controllers are the entry points for the outside world. They take HTTP requests from tools like RapidAPI or a web browser, route them to the correct Service, and send the data back as JSON.

### `SoftwareEngineerController.java` & `ProjectController.java`
*   **`@RestController`**: Tells Spring Boot that this class is a REST API. It ensures that anything returned from its methods is converted entirely into JSON format.
*   **`@RequestMapping("api/v1/projects")`**: Sets the foundational URL path. All endpoints inside this file will be accessed starting with this URL.
*   **Endpoint Annotations** (`@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`): Map specific HTTP verbs to the corresponding methods.
*   **`@RequestBody`**: Instructs Spring to look at the JSON payload sent by the user and convert it automatically into the Java Object (like `Project`).
*   **`@PathVariable("id")`**: Instructs Spring to extract the ID number from the URL string itself (e.g., retrieving `5` from `/projects/5`).

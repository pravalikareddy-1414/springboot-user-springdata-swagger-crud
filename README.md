# 👤 Spring Boot User CRUD API using Spring Data JPA & Swagger

This project is a **Spring Boot REST API** for managing Users, built using **Spring Data JPA (Hibernate)** and documented with **Swagger OpenAPI 3**.  
It demonstrates how to structure a clean, layered Spring Boot application using `Controller → Service → Repository` pattern.

---

## 🚀 Features

✅ Full CRUD operations using Spring Data JPA  
✅ Custom queries using `@Query` annotation  
✅ Service-layer abstraction for business logic  
✅ Interactive Swagger UI for API testing  
✅ Integration with MySQL / H2 database  
✅ OpenAPI documentation via annotations

---

## 🧱 Project Structure

src/main/java/com/example/user/
│
├── config/
│ └── SwaggerConfig.java → Swagger OpenAPI setup
│
├── model/
│ └── User.java → Entity mapped to 'user' table
│
├── Repository/
│ └── UserRepository.java → Spring Data JPA repository (CrudRepository)
│
├── service/
│ └── UserService.java → Business logic layer using repository
│
└── usercontroller/
└── UserController.java → REST controller with Swagger annotations



## ⚙️ Technologies Used

| Component | Technology |
|------------|-------------|
| **Language** | Java 17+ |
| **Framework** | Spring Boot 3.x |
| **ORM** | Spring Data JPA (Hibernate) |
| **Database** | MySQL / H2 |
| **Documentation** | Swagger OpenAPI 3 |
| **Build Tool** | Maven |
| **IDE** | Spring Tool Suite (STS) |

---
## 🧩 API Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/api/users` | Fetch all users |
| `GET` | `/api/user/{userId}` | Fetch user by ID |
| `POST` | `/api/save` | Add a new user |
| `PUT` | `/api/update/{userId}` | Update an existing user |
| `DELETE` | `/api/delete/{userId}` | Delete a user by ID |

---

## 🧠 Example Request (POST)

```bash
POST /api/save
Content-Type: application/json

{
  "userId": 1,
  "userName": "Harikiran",
  "address": "New Jersey"
}
Response:

json
Copy code
{
  "userId": 1,
  "userName": "Harikiran",
  "address": "New Jersey"
}

Swagger API Documentation

After running the app, open:

👉 Swagger UI:

http://localhost:8080/swagger-ui/index.html


👉 OpenAPI JSON:

http://localhost:8080/v3/api-docs

⚙️ Configuration (application.properties)
spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
server.port=8080

▶️ Run the Application
Using Maven
mvn spring-boot:run

Or using STS

Right-click your project → Run as → Spring Boot App

Then open in browser:

http://localhost:8080/api/users
http://localhost:8080/swagger-ui/index.html

🧠 Notes

Built using Spring Data JPA (CrudRepository and @Query).

All API endpoints are annotated with Swagger/OpenAPI for better documentation.

Follows clean, layered architecture:

Controller → Service → Repository → Database


Ideal for learning CRUD with Swagger integration.
📜 License

This project is open source and available under the MIT License.


---

Would you like me to add a small section at the top of the README like:  
> 🎯 *“Built with Spring Data JPA to simplify database access and reduce boilerplate code for CRUD operations.”*  
It gives your README a more professional developer-focused intro.


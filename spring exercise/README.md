# 🔐 JWT Authentication Backend

A production-ready Spring Boot REST API that implements secure JWT (JSON Web Token) authentication and authorization. The application provides secure user registration, authentication, and protected REST endpoints using Spring Security and PostgreSQL, following modern backend development best practices.

---

# 📌 Project Status

**✅ Production Ready**

---

# 🚀 Features

* Secure User Registration
* JWT-Based Authentication & Authorization
* User Login with Token Generation
* Protected REST APIs
* Spring Security 6 Integration
* PostgreSQL Database Support
* Password Encryption using BCrypt
* Layered Architecture (Controller → Service → Repository)
* RESTful API Design
* Maven Build Management

---

# 🛠️ Tech Stack

| Technology                  | Version      |
| --------------------------- | ------------ |
| Java                        | **21 (LTS)** |
| Spring Boot                 | **3.3.5**    |
| Spring Security             | **6.x**      |
| JWT (JJWT)                  | **0.12.6**   |
| PostgreSQL                  | **16+**      |
| Hibernate / Spring Data JPA | **6.x**      |
| Maven                       | **3.9+**     |

---

# 📁 Project Structure

```text
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── security
│   │   └── config
│   └── resources
│       └── application.properties
└── test
```

---

# ⚙️ Prerequisites

Before running the application, ensure the following software is installed:

| Software     | Version                               |
| ------------ | ------------------------------------- |
| Java JDK     | **21 or later**                       |
| Apache Maven | **3.9 or later**                      |
| PostgreSQL   | **16 or later**                       |
| Git          | **Latest Stable Release**             |
| IDE          | **IntelliJ IDEA / VS Code / Eclipse** |

---

# 📥 Installation

## 1. Clone the Repository

```bash
git clone https://github.com/your-username/jwt-auth-backend.git
```

## 2. Navigate to the Project Directory

```bash
cd jwt-auth-backend
```

## 3. Configure PostgreSQL Database

Create a new PostgreSQL database.

```sql
CREATE DATABASE jwt_auth_db;
```

Update the `application.properties` file.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/jwt_auth_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 4. Build the Project

```bash
mvn clean install
```

## 5. Run the Application

```bash
mvn spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

---

# 📦 Build Executable JAR

Generate the executable JAR file:

```bash
mvn clean package
```

Run the generated JAR:

```bash
java -jar target/*.jar
```

---

# 🔑 REST API Endpoints

| Method | Endpoint             | Description                        |
| ------ | -------------------- | ---------------------------------- |
| POST   | `/api/auth/register` | Register a new user                |
| POST   | `/api/auth/login`    | Authenticate user and generate JWT |
| GET    | `/api/user/profile`  | Access protected user profile      |

### Authorization Header

```text
Authorization: Bearer <JWT_TOKEN>
```

---

# 🔒 Security Features

* JWT Token Authentication
* Stateless Session Management
* BCrypt Password Encryption
* Spring Security Filter Chain
* Authentication Manager Integration
* Request Authorization
* Secure REST API Access

---

# 📚 Dependencies

* Spring Boot Starter Web
* Spring Boot Starter Security
* Spring Boot Starter Data JPA
* PostgreSQL Driver
* JJWT API
* Lombok
* Maven

---

# 🧪 Running Tests

Execute all unit tests:

```bash
mvn test
```

---

# 📖 API Testing

The REST APIs can be tested using:

* Postman
* Insomnia
* Thunder Client
* Any HTTP Client

---

# 📈 Future Enhancements

* Refresh Token Support
* Role-Based Authorization (ADMIN / USER)
* Email Verification
* Swagger / OpenAPI Documentation
* Docker & Docker Compose Support
* CI/CD Pipeline Integration
* Redis Token Blacklisting

---

# 📄 License

This project is licensed under the **MIT License**.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the **"Software"**), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, subject to the following conditions.

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED **"AS IS"**, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.

See the **LICENSE** file for complete details.

---

# 👨‍💻 Author

**CHANDRU.R**

Computer Science and Business Systems (CSBS) Undergraduate

**Backend Developer | Java | Spring Boot | Spring Security | JWT | PostgreSQL | REST API Development | Maven**

Passionate about building secure, scalable, and production-ready backend applications using modern Java technologies.

---

⭐ If you found this project useful, consider giving it a star on GitHub.

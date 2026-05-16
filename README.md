# ESG Reporting Engine Backend

## Project Overview

The ESG Reporting Engine Backend is a Spring Boot–based REST API application designed to manage Environmental, Social, and Governance (ESG) reporting data efficiently and securely.

The application provides scalable backend services for creating, updating, deleting, and managing ESG records with PostgreSQL database integration and JWT-based authentication.

This project follows a clean layered architecture using Spring Boot best practices and includes Swagger/OpenAPI documentation for API testing and development.

---

# Features

- CRUD Operations for ESG Records
- JWT Authentication & Authorization
- PostgreSQL Database Integration
- RESTful API Architecture
- Swagger/OpenAPI Documentation
- Request Validation using Spring Validation
- Spring Security Integration
- Layered Backend Structure
- Maven Dependency Management
- Exception Handling & Validation

---

# Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Backend Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Security |
| Spring Data JPA | ORM Layer |
| PostgreSQL | Database |
| Maven | Dependency Management |
| Swagger/OpenAPI | API Documentation |
| JWT | Authentication |
| Lombok | Boilerplate Reduction |
| Spring Validation | Request Validation |

---

# Project Structure

```text
backend
│
├── src
│   └── main
│       ├── java
│       │   └── tool
│       │       ├── controller
│       │       ├── dto
│       │       ├── entity
│       │       ├── repository
│       │       ├── security
│       │       ├── service
│       │       └── ToolApplication.java
│       │
│       └── resources
│           └── application.properties
│
├── pom.xml
├── mvnw
└── mvnw.cmd
```

---

# Database Configuration

Update the following properties in:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/esgdb
spring.datasource.username=postgres
spring.datasource.password=postgres
```

---

# API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Getting Started

## Clone Repository

```bash
git clone https://github.com/nbhoomi567-hash/esg-reporting-engine.git
```

---

## Navigate to Backend

```bash
cd backend
```

---

## Build Project

```bash
./mvnw clean install
```

For Windows PowerShell:

```powershell
.\mvnw.cmd clean install
```

---

## Run Application

```bash
./mvnw spring-boot:run
```

For Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```
# Project Screenshots

## Authentication API
![Authentication](screenshots/authentication-auth.png)

## Authorization Test 1
![Auth1](screenshots/authop1.png)

## Authorization Test 2
![Auth2](screenshots/authop2.png)

## Search By Company
![Company](screenshots/by-company.png)

## Database Records
![Database](screenshots/databases.png)

## Delete API Output
![Delete](screenshots/deleteoprtn.png)

## Get By ID
![GetById](screenshots/getbyid.png)

## Get By ID Output
![GetByIdOutput](screenshots/getbyidop.png)

## GET API
![GetAPI](screenshots/getop.png)

## Login Page
![Login](screenshots/login-page.png)

## API Method Check
![MethodCheck](screenshots/methodsAPICheck.png)

## POST Check Output
![PostCheck](screenshots/postcheckop.png)

## POST API
![PostAPI](screenshots/postop.png)

## Project Structure
![Structure](screenshots/project-structure.png)

## Search By Category
![Category](screenshots/search-by-catop.png)

## Swagger UI Test 1
![Swagger1](screenshots/swag-1st-test.png)

## Swagger UI Test 2
![Swagger2](screenshots/swag-2nd.png)
---

# Authentication

The application uses JWT (JSON Web Token) authentication for securing APIs.

Features include:

- Token Generation
- Token Validation
- Secured API Endpoints
- Spring Security Integration

---

# Future Enhancements

- Role-Based Access Control (RBAC)
- Docker Deployment
- Cloud Deployment Support
- ESG Analytics Dashboard
- AI-Based ESG Insights
- Advanced Reporting Features

---

# Author

Developed as part of ESG Reporting Engine Backend implementation using Spring Boot and PostgreSQL.

---

# License

This project is developed for educational and internship purposes.

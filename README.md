# CRM Backend API

A backend CRM system built with **Java Spring Boot** designed to demonstrate real-world backend development skills, including authentication, business logic, database integration, and cloud deployment.

This project is part of my professional portfolio for backend developer positions.

---

## 🔗 Live Demo

**Base API URL**  
https://crm-backend-vne5.onrender.com/api/v1

**Health Check**  
https://crm-backend-vne5.onrender.com/api/v1/health

**Swagger API Documentation**  
https://crm-backend-vne5.onrender.com/swagger-ui/index.html

---

## 🧩 Overview

This project simulates a basic **CRM (Customer Relationship Management)** backend system commonly used in enterprise and business applications.

It focuses on:
- Clean backend architecture
- RESTful API design
- Authentication and authorization
- Database modeling
- Cloud deployment with Docker

---

## ⚙️ Tech Stack

**Backend**
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA (Hibernate)
- Spring Security (JWT-based authentication)

**Database**
- PostgreSQL (Render Managed Database)

**DevOps / Deployment**
- Docker (multi-stage build)
- Render (Web Service)
- GitHub (source control)

**API Documentation**
- Swagger / OpenAPI

---

## ✨ Features

- Authentication and authorization using JWT
- Role-based access control (Admin / User)
- Customer management (CRUD)
- Product management (CRUD)
- Order management with business logic
- Pagination and filtering support
- RESTful API design
- Centralized error handling
- Health check endpoint for monitoring

---

## 🗂 Project Structure

```text
src/main/java/com/backend/crm
 ├─ controller
 ├─ service
 ├─ config
 ├─ repository
 ├─ entity
 ├─ dto
 ├─ security
 └─ exception
```

This structure follows a layered architecture:
- **Controller**: Handles HTTP requests and responses
- **Service**: Contains business logic
- **Repository**: Handles database access
- **DTO**: Data transfer objects for API communication

---

## 🔐 Authentication
- JWT-based authentication
- Protected endpoints using Spring Security

---

## ☁️ Deployment

This application is deployed using **Render** with Docker.

Deployment highlights:
- Multi-stage Docker build
- Environment-based configuration
- Managed PostgreSQL database
- Automatic HTTPS

---

## 📐 Architecture (High Level)

```text
Frontend (API Client)
        ↓
Spring Boot REST API
        ↓
Service Layer
        ↓
JPA / Hibernate
        ↓
PostgreSQL Database
```

---

## 🎯 Purpose of This Project

This project was created to demonstrate:
- Backend development skills with Java and Spring Boot
- Experience with CRM-related business logic
- Ability to design, build, and deploy production-ready APIs
- Understanding of cloud deployment and containerization

---

## 📌 Notes

This project is intended for **portfolio and demonstration purposes**.
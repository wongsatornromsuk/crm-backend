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
- Authentication
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

- Authentication using JWT
- Lead, Account (Customer) and Opportunity management with business logic
- RESTful API design
- Centralized error handling
- Health check endpoint for monitoring

---

## 🔄 Business Flow (CRM Process)

The CRM system workflow starts with **Lead management**, representing potential customers who have shown interest in the company’s products.

---

### 1. Lead Creation
A **Lead** represents a person who is interested in the company’s products.

- A new Lead can be created by providing key information such as:
  - First Name
  - Last Name
  - Mobile Number
  - Email Address
- After saving, the system automatically:
  - Stores the Lead record
  - Sets the Lead **stage** to **New**

---

### 2. Lead Qualification
When the sales team contacts the Lead and confirms genuine interest, there are two possible paths:

#### Option 1: Convert Lead to Account (Prospect)
If the sales team is ready to present the product immediately:
- The Lead can be **converted into an Account**
- The system automatically:
  - Creates an **Account**
  - Sets the Account **type** to **Prospect**

#### Option 2: Update Lead Stage to Qualified
If the sales team is **not ready** to convert the Lead yet:
- The Lead stage can be updated to **Qualified**
- The Lead can be converted to an Account later when appropriate

---

### 3. Opportunity Creation
From the **Account detail page**, the sales team can create one or more **Opportunities**.

- An Account may have **zero or multiple Opportunities**
- Each Opportunity includes:
  - **Name**: the product or service the customer is interested in
  - **Amount**: the estimated value of the deal

---

### 4. Opportunity Progression
As the sales process continues:

- When a proposal has been presented to the customer:
  - The Opportunity stage is updated to **Proposal**

---

### 5. Deal Closure
The final step is closing the Opportunity. There are two possible outcomes:

- **Close Won** — the customer agrees to purchase
- **Close Lost** — the customer decides not to proceed

#### Account Type Update Logic
- If **at least one Opportunity** for an Account is closed as **Close Won**:
  - The system automatically updates the Account **type** to **Customer**
  - This indicates that a successful sale has been completed
- Until a deal is won, the Account remains a **Prospect**

> **Note:**  
> If a price negotiation occurs and a discount is applied to close the deal as **Close Won**,  
> the Opportunity **amount must be updated** to reflect the actual final sale price.
    
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

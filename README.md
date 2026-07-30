# E-Commerce Backend

A RESTful E-Commerce Backend built using **Spring Boot** that provides secure JWT authentication, role-based authorization, Redis caching, product management, order processing, Apache Kafka integration, Swagger API documentation, Docker support, MySQL database integration, and JUnit testing.

---

## Features

- JWT Authentication
- Role-Based Authorization (ADMIN / USER)
- Product CRUD APIs
- Product Search & Filtering
- Pagination Support
- Product Review APIs
- Order Processing APIs
- Apache Kafka Producer & Consumer
- Redis Caching
- Unit Testing with JUnit & Mockito
- Swagger/OpenAPI Documentation
- Docker Containerization
- MySQL Database Integration

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- Spring Cache

### Security
- JWT Authentication
- BCrypt Password Encoding

### Database
- MySQL
- Redis

### Messaging
- Apache Kafka

### Testing
- JUnit 5
- Mockito

### Documentation
- Swagger / OpenAPI

### Build Tool
- Maven

### Containerization
- Docker
- Docker Compose

---

## Project Structure

```text
src
├── controller
├── dto
├── entity
├── kafka
│   ├── KafkaProducerService
│   └── KafkaConsumerService
├── repository
├── security
├── service
├── spec
├── test
│   └── ProductServiceTest
└── resources
```

---

## REST APIs

### Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Authenticate user and generate JWT |

---

### Products

| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/api/products` | Public |
| GET | `/api/products/{id}` | Public |
| GET | `/api/products/search` | Public |
| POST | `/api/products` | ADMIN |
| PUT | `/api/products/{id}` | ADMIN |
| DELETE | `/api/products/{id}` | ADMIN |

---

### Product Reviews

| Method | Endpoint |
|--------|----------|
| POST | `/api/products/review` |

---

### Orders

| Method | Endpoint |
|--------|----------|
| POST | `/api/orders` |
| GET | `/api/orders/{orderNo}` |

---

## Role-Based Access

| User Role | Permissions |
|-----------|-------------|
| Public | Register, Login, View Products, Search Products |
| USER | Place Orders, Add Product Reviews |
| ADMIN | Create Products, Update Products, Delete Products |

---

## Kafka Event Flow

```text
Create Order
     │
     ▼
Save Order in MySQL
     │
     ▼
Publish Event to Kafka
     │
     ▼
Kafka Consumer Receives Event
     │
     ▼
Logs Order Created Message
```

---

## Redis Cache Flow

```text
Client Request
      │
      ▼
Check Redis Cache
      │
 ┌────┴────┐
 │         │
Hit       Miss
 │         │
 ▼         ▼
Return   Fetch from MySQL
Data         │
             ▼
      Store in Redis
             │
             ▼
      Return Response
```

---

## Running the Project

### Prerequisites

- Java 17
- Maven
- Docker
- Docker Compose
- MySQL
- Redis

---

### Clone the Repository

```bash
git clone https://github.com/charu182002/ecommerce-backend.git
cd ecommerce-backend
```

---

## Docker

The project includes Docker and Docker Compose configuration to run the Spring Boot application and its required services.

### Start all Services

```bash
docker-compose up -d
```

### Build Docker Image

```bash
docker build -t ecart .
```

### Run Docker Container

```bash
docker run -p 8080:8080 ecart
```

---

### Configure Database

Update your configuration in:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecart
spring.datasource.username=root
spring.datasource.password=root

spring.data.redis.host=localhost
spring.data.redis.port=6379

spring.kafka.bootstrap-servers=localhost:9092
```

---

### Build the Project

```bash
mvn clean install
```

---

### Run the Application

```bash
mvn spring-boot:run
```

Application URL:

```
http://localhost:8080
```

---

## Swagger Documentation

Open:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides interactive documentation for all REST APIs.

---

## JWT Authentication

Protected APIs require a JWT access token.

Example:

```http
Authorization: Bearer <JWT_TOKEN>
```

---

## Unit Testing

The project includes unit tests for the service layer using **JUnit 5** and **Mockito**.

### Covered Components

- ProductService
- CRUD operation testing
- Repository mocking using Mockito
- Service layer validation

Run all tests:

```bash
mvn test
```

---

## Technologies Demonstrated

- RESTful API Development
- Layered Architecture
- DTO Mapping
- Spring Data JPA
- Dynamic Search using JPA Specifications
- Pagination
- Bean Validation
- JWT Authentication
- Spring Security
- Role-Based Authorization
- Apache Kafka Messaging
- Redis Caching with Spring Cache
- Unit Testing using JUnit 5 & Mockito
- Docker & Docker Compose
- Swagger/OpenAPI Documentation
- MySQL Integration
- Database Indexing for Query Optimization

---

## Author

**Charumathi P**

Java Backend Developer

**LinkedIn**  
https://www.linkedin.com/in/charumathi-p-a167b221b

**GitHub**  
https://github.com/charu182002

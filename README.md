# Nebula Product Service 🪐

This is a Spring Boot microservice that operates on Products, stores it in PostgreSQL, and communicates through Kafka.

---

## 🚀 Features

- CRUD operations on Products
- Swagger OPENAPI for UI 
- Store data in PostgreSQL
- Communicate events using Apache Kafka
- Uses Docker for containerized environment

---

## 📦 Tech Stack

- ⚙️ **Backend:** Java 17, Spring Boot
- 🐘 **Database:** PostgreSQL
- 📬 **Message Broker:** Apache Kafka
- 🐳 **Containerization:** Docker & Docker Compose
- 🌐 **External API:** FakeStore API

---

## 🧠 Prerequisites

- Docker-Desktop installed
- Java 17+ installed
- IDE (IntelliJ or VS-Code)

---

## 🗃 DataBase

- PostgreSQL
- DB Name: productservice
- User: productservice
- Password: qwerty

---

## ▶️ How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/Manjeet2001/Nebula.git
cd nebula
```

### 2. Pull Image and Run Container

```bash
docker-compose up --build
```
---

## 📮 API Endpoints

| Method | Endpoint         | Description          |
| ------ | ---------------- | -------------------- |
| `POST` | `/products`      | Create a new product |
| `POST` | `/products/{id}` | Update a product     |
| `GET`  | `/products/{id}` | Get product by ID    |
| `GET`  | `/products`      | Get all products     |
| `GET`  | `/health`        | Health Check         |
|`DELETE`| `/products/{id}` | Delete a product     |

### ✅ POST method (Body):
```JSON
{
  "title": "New Product",
  "description": "Description of the product",
  "price": 99.99,
  "category": {
    "name": "Device Category"
  }
}

```
---

## 🧪 Test the application

### 1. Access API at:
```bash
http://localhost:8081/swagger-ui/index.html#/
```

### 2. Access pgAdmin at:
```bash
http://localhost:5050
```
- **Email:** admin@admin.com
- **Password:** admin

---

## 📂 Folder Structure
```css
Nebula/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/nebula/
│       │       ├── config/
│       │       ├── controller/
│       │       ├── dtos/
│       │       ├── exceptions/
│       │       ├── kafka/
│       │       ├── models/
│       │       ├── repos/
│       │       ├── service/
│       │       └── thirdPartyClients/
│       └── resources/
│           ├── application.properties
│           └── application-docker.properties
├── pom.xml
├── docker-compose.yml
├── Dockerfile
└── README.md

```

## 🐳	Different Containers and Their Ports

| Application | Port |
| --- | --- |
| Nebula - app | 8081 |
| PostgreSQL | 5432 |
| Kafka | 9092 |
| pgAdmin | 5050 |

---

## ✅ Shutdown
  ### 1. To safely stop containers while preserving database data:
  ```bash
  docker-compose stop
  ```

  ### 2. To remove containers, but keep volume data:
  ```bash
  docker-compose down
  ```

  ### 3. To remove everything including volumes:
  ```bash
  docker-compose down -v
  ```

### 4. To rerun again(if volume is saved)
```bash
docker-ompose up
```

---

## ⚠️ Note:

- Topics are auto-created in Kafka (Product-Event)
- Spring Profile used: docker.

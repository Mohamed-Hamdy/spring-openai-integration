# Integration Microservice

A Spring Boot microservice that integrates with PostgreSQL and OpenAI, providing RESTful APIs for integration management and AI-powered learning path recommendations.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Development](#development)
- [License](#license)

---

## Features

- RESTful CRUD operations for integration entities
- PostgreSQL database support (via Docker Compose)
- AI-powered learning path recommendations using OpenAI
- Easy local development with Docker

## Tech Stack

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- OpenAI API (via Spring AI)

## Getting Started

### Prerequisites

- Java 21+
- Maven
- Docker

### Clone the Repository

```sh
https://github.com/Mohamed-Hamdy/spring-openai-integration.git
```

### Start PostgreSQL with Docker Compose

```sh
docker-compose up -d
```

### Configure OpenAI API Key

Set your OpenAI API key as an environment variable:

```sh
# Linux/macOS
export OPEN_AI_KEY=your-openai-api-key

# Windows (cmd)
set OPEN_AI_KEY=your-openai-api-key
```

Or add it directly to `src/main/resources/application.properties` (not recommended for production).

### Build and Run the Application

```sh
./mvnw spring-boot:run
```

The service will start on [http://localhost:8080](http://localhost:8080).

## Configuration

Key configuration is in [`src/main/resources/application.properties`](src/main/resources/application.properties):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5334/integration
spring.datasource.username=laithy
spring.datasource.password=laithy
spring.jpa.hibernate.ddl-auto=create-drop
spring.ai.openai.api-key=${OPEN_AI_KEY}
```

## API Endpoints

| Method | Endpoint                 | Description            |
| ------ | ------------------------ | ---------------------- |
| GET    | `/api/v1/integrate`      | List all integrations  |
| GET    | `/api/v1/integrate/{id}` | Get integration by ID  |
| POST   | `/api/v1/integrate`      | Create new integration |
| PUT    | `/api/v1/integrate/{id}` | Update integration     |
| DELETE | `/api/v1/integrate/{id}` | Delete integration     |

## Development

- Source code: `src/main/java/com/example/integration/`
- Main entry: [`IntegrationApplication.java`](src/main/java/com/example/integration/IntegrationApplication.java)
- Controller: [`IntegrationController.java`](src/main/java/com/example/integration/controller/IntegrationController.java)
- Service: [`IntegrationService.java`](src/main/java/com/example/integration/Services/IntegrationService.java)

## License

This project is licensed for educational and demonstration purposes.

---

**Author:** Mohamed El Laithy  

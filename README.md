# QuizApp Demo

## Overview
QuizApp is a simple quiz application built using Java and Spring Boot. This application allows users to attempt quizzes, manage questions. It was developed as a demo project for learning purposes and does not include update or delete functionalities for quizzes or questions.

The application is built using a microservices architecture with the following four microservices:
- **question-service**: Manages quiz questions.
- **quiz-service**: Handles quiz-related operations.
- **service-registry**: Eureka client for connecting microservices.
- **API gateway**: A common API gateway to control API calls to specific microservices.

In the **service-registry** microservice, Eureka client is used for all the microservices to communicate. A **Load Balancer** is implemented to handle multiple instances of microservices within Eureka.

## Features
- Create and attempt quizzes
- Add and manage questions
- View quiz results
- RESTful API endpoints for quiz operations
- Uses Spring Boot for backend development

## Tech Stack
- Java
- Spring Boot
- Spring Cloud (for microservices management)
- Spring Data JPA
- MySQL Database
- Maven
- FeignClient (used in `quiz-service` to access `question-service` API endpoints)

## Folder Structure

```
quizApp-demo/
│-- src/
│   ├── main/
│   │   ├── java/com/example/quizapp/
│   │   │   ├── controller/   # Contains REST controllers for handling HTTP requests
│   │   │   ├── service/      # Business logic for quiz management
│   │   │   ├── repository/   # Interfaces for database interactions using JPA
│   │   │   ├── entities/     # Entity classes representing database tables
│   │   ├── resources/
│   │   │   ├── application.properties  # Configuration file for database and server settings
│-- src/test/java/com/example/quizapp/  # Unit and integration tests
│-- pom.xml  # Maven dependencies and build configuration
│-- README.md  # Project documentation
```

## API Access
API access is configured in the `application.properties` file.

## API Gateways
1. **quiz-service**:
   - `POST /quiz` → Create a quiz
   - `GET /quiz` → Get all quizzes
   - `GET /quiz/{id}` → Get quiz by ID

2. **question-service**:
   - `POST /question` → Create a question
   - `GET /question` → Get all questions
   - `GET /question/{id}` → Get question by ID

3. **API Gateway**:
   - Routes from a common port `8083` to fetch `/quiz/**` and `/question/**` endpoints.

## Contributing
Feel free to fork this repository and submit pull requests with improvements!

## License
This project is open-source and available under the [MIT License](LICENSE).

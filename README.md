[![CircleCI](https://circleci.com/gh/springframeworkguru/sfg-pet-clinic.svg?style=svg)](https://circleci.com/gh/springframeworkguru/sfg-pet-clinic)

# Spring Framework Guru Pet Clinic

An opinionated version of the classic [Spring Pet Clinic](https://github.com/spring-projects/spring-petclinic) reference application, built as a companion project for the [Spring Framework 5: Beginner to Guru](https://www.udemy.com/spring-framework-5-beginner-to-guru/?couponCode=GITHUB_SFGPETCLINIC) course.

## Project Structure

This is a Maven multi-module project:

```
sfg-pet-clinic
├── pet-clinic-data   # Domain models, service interfaces, map & JPA implementations
└── pet-clinic-web    # Spring MVC controllers, Thymeleaf templates, bootstrap data
```

## Technology Stack

| Layer | Technology |
|---|---|
| Language | Java 11 |
| Framework | Spring Boot 2.1 |
| Persistence | Spring Data JPA (default) / in-memory Map service |
| Templating | Thymeleaf |
| Frontend | Bootstrap 3, jQuery, jQuery UI |
| Build | Maven (wrapper included) |
| Testing | JUnit 5, Mockito |
| CI | CircleCI |

## Getting Started

### Prerequisites

- Java 11+
- Maven 3.5+ (or use the included `mvnw` wrapper)

### Build

```bash
./mvnw clean package
```

### Run

```bash
./mvnw spring-boot:run -pl pet-clinic-web
```

The application starts on [http://localhost:8080](http://localhost:8080).

### Run Tests

```bash
./mvnw test
```

## Service Profiles

The active profile is configured in `pet-clinic-web/src/main/resources/application.properties`:

| Profile | Description |
|---|---|
| `springdatajpa` (default) | Persists data with Spring Data JPA (H2 in-memory DB) |
| `map` | Uses in-memory Map-based service implementations (no DB) |

Switch profiles by editing `spring.profiles.active` in `application.properties` or passing `-Dspring.profiles.active=map` at runtime.

## Internationalization

The UI supports English, French, and German. Message bundles are in `pet-clinic-web/src/main/resources/messages/`.

## License

Released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).

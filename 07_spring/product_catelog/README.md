# Product Catalog

Simple Spring-based Product Catalog service.

## Overview
This project implements a product catalog API using Spring (Spring Boot assumed). It provides endpoints to create, read, update and delete product records and includes integration with a database for persistence.

## Features
- RESTful API for products (CRUD)
- Validation and error handling
- Unit / integration tests
- Configurable datasource (H2 / PostgreSQL / MySQL)

## Prerequisites
- Java 11+ (or project-targeted JDK)
- Maven or Gradle (or use bundled wrapper)
- Optional: Docker (for containerized DB)

## Build

Using Maven:
```bash
mvn clean package
```
If the repo includes the Maven wrapper on Windows:
```powershell
.\mvnw.cmd clean package
```

Using Gradle:
```bash
./gradlew build
```
On Windows:
```powershell
.\gradlew.bat build
```

## Run

Using Spring Boot:
```powershell
mvn spring-boot:run
# or
.\mvnw.cmd spring-boot:run
```

Run the built JAR:
```powershell
java -jar target\<artifactId>-<version>.jar
```

## Tests
Run unit and integration tests:
```powershell
mvn test
# or
.\mvnw.cmd test
```

## Configuration
Application configuration lives in `src/main/resources/application.properties` or `application.yml`. Common settings:
- server.port
- spring.datasource.url / username / password
- spring.jpa.hibernate.ddl-auto

For quick local development use H2 in-memory DB:
```properties
spring.datasource.url=jdbc:h2:mem:productdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
```

## API (example)
- GET /api/products — list products
- GET /api/products/{id} — get product by id
- POST /api/products — create product
- PUT /api/products/{id} — update product
- DELETE /api/products/{id} — delete product

Adjust base path according to your controller mappings.

## Development (VS Code)
- Open folder `f:\java\07_spring\product_catelog` in VS Code.
- Install Java and Spring extensions.
- Use the Debug view to run the Spring Boot application or use the integrated terminal to run Maven/Gradle commands.

## Docker (optional)
Example Dockerfile steps:
- Build jar: `mvn package`
- Build image: `docker build -t product-catalog .`
- Run container: `docker run -p 8080:8080 product-catalog`

## Contributing
- Fork, create a feature branch, open a PR.
- Run tests locally before submitting.

## Troubleshooting
- Check logs in VS Code Output / terminal.
- If port already in use, change `server.port`.
- Database connection errors: verify datasource URL/credentials and that DB is reachable.

## License
Specify project license in LICENSE file.

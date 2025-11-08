# Spring Medical Registry API

A Spring Boot REST API project with CRUD operations for managing medical professionals. This project showcases best practices in API development using Spring Boot and related technologies.

## Tech Stack

- Java 17+
- Spring Boot
  - Spring Web (REST endpoints)
  - Spring Data JPA (database operations)
  - Jakarta Bean Validation
- Flyway (database migrations)
- Database configured via `application.yml`
- Maven (wrapper included: `./mvnw`)

## Project Structure

```
src/main/java/med/voll/api/
├── controller/    # REST endpoints
├── service/       # Business logic
├── repository/    # Data access
├── model/         # Domain entities
├── dto/           # Data transfer objects
└── exception/     # Error handling
```

Key components:
- `controller` — REST endpoints (`MedicoController`)
- `service` — Business logic (`MedicoService`)
- `repository` — Spring Data JPA repositories (`MedicoRepository`)
- `model` — Entities (`Medico`, `Endereco`)
- `dto` — DTOs (`MedicoCreateDTO`, `MedicoResponseDTO`, `EnderecoDTO`)
- `exception` — Global exception handling

## API Endpoints

Base path: `/medicos`

### List Doctors (GET `/medicos`)
- Supports pagination and sorting via Spring `Pageable`
- Query parameters:
  - `page`: Page number (0-based)
  - `size`: Items per page
  - `sort`: Sort field and direction
- Examples:
  ```
  /medicos?sort=nome           # Sort by name (asc)
  /medicos?sort=nome,desc      # Sort by name (desc)
  /medicos?page=0&size=10      # First 10 items
  ```

### Create Doctor (POST `/medicos`)
- Creates a new doctor record
- Requires validated JSON body
- Returns created doctor data

### Update Doctor (PUT `/medicos`)
- Updates an existing doctor
- Requires full doctor data in request body
- Validates all fields

### Delete Doctor
- Physical delete: DELETE `/medicos/fisico/{id}`
- Logical delete: DELETE `/medicos/logico/{id}`

### Prerequisites
- Java 17 or higher
- Maven (or use included wrapper)

### Running the Application

Build and run using Maven wrapper:

```bash
# Download dependencies and compile
./mvnw clean package -DskipTests

# Run the application
./mvnw spring-boot:run
```

Or run the generated jar:

```bash
./mvnw package
java -jar target/*.jar
```

The application listens on port `8080` by default.

## Database Management

- Flyway migrations in `src/main/resources/db/migration`
- Migrations run automatically on startup
- Check `V1__create-table-medicos.sql` and `V2__update-table-medicos.sql` for schema details

## Input Validation

DTOs use Jakarta validation annotations:
- `@NotBlank`: Required string fields
- `@Pattern`: Regex patterns
- `@NotNull`: Required non-string fields
- `@Valid`: Nested object validation

### Create a Doctor

```bash
curl -X POST http://localhost:8080/medicos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "John Smith",
    "email": "john@example.com",
    "telefone": "1234567890",
    "crm": "12345",
    "especialidade": "ORTHOPEDICS",
    "endereco": {
      "logradouro": "123 Main St",
      "numero": "100",
      "bairro": "Downtown",
      "cidade": "Springfield",
      "uf": "IL",
      "cep": "12345678"
    }
  }'
```

### List Doctors (Sorted)

```bash
curl http://localhost:8080/medicos?sort=nome
```

# ChatAPI

Version `0.1.0`

ChatAPI is a Spring Boot REST API that sends chat prompts to an Ollama Cloud model through Ollama's OpenAI-compatible API.

## Requirements

- Java 27
- An Ollama API key
- macOS, Linux, or Windows

## Configuration

Create a `.env` file in the project root. This file is ignored by Git.

```properties
OLLAMA_API_KEY=your_ollama_api_key
```

Do not commit or share this file.

The application uses the `gemma4:31b` Ollama Cloud model and loads the key from `.env` through `application.yml`.

## Run the application

From the project root:

```bash
./mvnw clean spring-boot:run
```

On Windows:

```powershell
mvnw.cmd clean spring-boot:run
```

The server starts on port `8081`.

## API endpoints

### Health check

```http
GET http://localhost:8081/api/hello
```

### Chat

```http
GET http://localhost:8081/api/chat?query=Explain%20Java%20records
```

Example response:

```json
{
  "response": "A record is a concise way to declare a data-carrying class in Java."
}
```

## Project structure

```text
src/main/java/com/sayan/chatapi/
├── ChatApiApplication.java
├── controller/ChatController.java
└── dto/ChatResponse.java
```

## Formatting

The project uses the Red Hat Java formatter in VS Code with format on save enabled.

## Versioning

This project follows semantic versioning:

```text
MAJOR.MINOR.PATCH
```

Current version: `0.1.0`.

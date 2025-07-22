# 🚀 Backend GitHub Stars API

A modern Kotlin backend application built with Ktor that fetches and serves top Swift repositories from GitHub. This project demonstrates clean architecture principles with proper separation of concerns using models, DTOs, mappers, services, and repositories.

## ✨ Features

- **RESTful API** built with Ktor framework
- **Clean Architecture** with layered design (Repository → Service → Controller)
- **Data Mapping** between internal models and API DTOs
- **GitHub API Integration** to fetch trending Swift repositories
- **JSON Serialization** with kotlinx.serialization
- **Error Handling** with proper HTTP status codes
- **Modern Kotlin** with coroutines and suspend functions

## 🏗️ Architecture

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Controller    │───▶│     Service     │───▶│   Repository    │
│   (Main.kt)     │    │ (GithubService) │    │(GithubRepository│
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   DTO Layer     │    │   Mapper Layer  │    │   Model Layer   │
│ (GithubRepoDTO) │◄───│ (GithubRepoMapper│◄───│  (GithubRepo)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

## 🛠️ Tech Stack

- **Language**: Kotlin 2.1.21
- **Framework**: Ktor 2.3.9
- **Build Tool**: Gradle with Kotlin DSL
- **Serialization**: kotlinx.serialization-json 1.6.3
- **HTTP Client**: Ktor Client with CIO engine
- **Logging**: SLF4J Simple
- **JVM**: Java 22

## 📁 Project Structure

```
src/main/kotlin/
├── Main.kt                    # Application entry point & routing
├── model/
│   └── GithubRepo.kt         # Internal data models
├── DTO/
│   └── GithubRepoDTO.kt      # Data Transfer Objects for API
├── mapper/
│   └── GithubRepoMapper.kt   # Model ↔ DTO conversion
├── service/
│   └── GithubService.kt      # Business logic layer
└── repository/
    └── GithubRepository.kt   # Data access layer
```

## 🚀 Getting Started

### Prerequisites

- **Java 22** or higher
- **Gradle** (included via wrapper)

### Installation

1. **Clone the repository**

   ```bash
   git clone <your-repo-url>
   cd BackendGithubStars
   ```

2. **Build the project**

   ```bash
   ./gradlew build
   ```

3. **Run the application**

   ```bash
   ./gradlew run
   ```

   The server will start on `http://localhost:8080`

### Using VS Code/Cursor

1. **Open the project** in VS Code or Cursor
2. **Press F5** or use the Debug panel
3. Select **"Launch Ktor Application"** configuration
4. The server will start automatically with debugging enabled

## 📡 API Endpoints

### Base URL

```
http://localhost:8080
```

### Available Endpoints

#### 1. Health Check

```http
GET /
```

**Response:**

```
Hello, Ktor!
```

#### 2. Get Top Swift Repositories

```http
GET /swift-stars
```

**Response:**

```json
[
  {
    "name": "repository-name",
    "repositoryUrl": "https://github.com/user/repo",
    "starCount": 15000
  }
]
```

## 🔧 Development

### Running Tests

```bash
./gradlew test
```

### Clean Build

```bash
./gradlew clean build
```

### Available Gradle Tasks

- `./gradlew build` - Build the project
- `./gradlew run` - Run the application
- `./gradlew test` - Run tests
- `./gradlew clean` - Clean build artifacts

## 🏛️ Architecture Details

### Layer Responsibilities

#### **Repository Layer** (`GithubRepository`)

- Handles external API calls to GitHub
- Manages HTTP client configuration
- Maps external API responses to internal models

#### **Service Layer** (`GithubService`)

- Contains business logic
- Orchestrates data flow between layers
- Handles data transformation using mappers

#### **Mapper Layer** (`GithubRepoMapper`)

- Converts between internal models and DTOs
- Ensures API contract stability
- Handles data format transformations

#### **Controller Layer** (`Main.kt`)

- Defines HTTP endpoints
- Handles request/response mapping
- Manages error responses

### Data Flow Example

1. **Client Request** → `GET /swift-stars`
2. **Controller** → Calls `GithubService.getTopSwiftRepositories()`
3. **Service** → Calls `GithubRepository.fetchTopSwiftRepositories()`
4. **Repository** → Fetches data from GitHub API
5. **Mapper** → Converts `GithubRepo` models to `GithubRepoDTO`
6. **Response** → Returns JSON to client

## 🔍 Code Examples

### Model Definition

```kotlin
@Serializable
data class GithubRepo(
    val name: String,
    @SerialName("html_url") val repositoryUrl: String,
    @SerialName("stargazers_count") val starCount: Int
)
```

### DTO Definition

```kotlin
@Serializable
data class GithubRepoDTO(
    val name: String,
    val repositoryUrl: String,
    val starCount: Int
)
```

### Mapper Usage

```kotlin
object GithubRepoMapper {
    fun toDto(model: GithubRepo): GithubRepoDTO {
        return GithubRepoDTO(
            name = model.name,
            repositoryUrl = model.repositoryUrl,
            starCount = model.starCount
        )
    }
}
```

## 🐛 Debugging

### VS Code/Cursor Debugging

1. Set breakpoints in your Kotlin code
2. Press `F5` to start debugging
3. Use step-over (`F10`) and step-into (`F11`) to navigate code
4. Inspect variables in the debug panel

### Logs

The application uses SLF4J Simple for logging. Check the console output for:

- Server startup messages
- HTTP request logs
- Error messages

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- [Ktor Framework](https://ktor.io/) for the excellent Kotlin web framework
- [GitHub API](https://docs.github.com/en/rest) for providing repository data
- [Kotlin Team](https://kotlinlang.org/) for the amazing language

---

**Happy Coding! 🎉**

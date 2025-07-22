# 📘 Backend Documentation - Product API
## 🧩 Architecture Overview
This backend application follows **SOLID principles**, with strong emphasis on the **Dependency Inversion Principle** by separating responsibilities across layered abstractions.


### 🔁 Dependency Flow

Controller  
└── Facade Interface  
└── Service Interfaces  
└── Repository Interfaces

  
---  

## 📦 Controllers

-  `ProductController` handles HTTP requests and delegates business logic to the `ProductFacade` interface.

- Uses `@RestController` and `@RequestMapping` to expose REST endpoints.
---
## 🎭 Facade Pattern

-  `ProductFacadeImpl` coordinates logic between `ProductService` and `ResourceService`.

- Demonstrates the **Facade Design Pattern** by wrapping multiple service calls under a unified interface.

> ⚠️ This usage of the Facade pattern is intended for demonstration purposes. In production scenarios, composing URL data like this directly in a facade is **not** a recommended practice.
---

## 💡 Dependency Inversion Principle in Action

-  **Business logic depends on abstractions (interfaces)**, not on concrete implementations.

- The **mocked repositories** (`ProductRepository`, `ResourceRepository`) demonstrate that it's possible to replace data sources (e.g., databases or object storage) without modifying the business logic.

- This flexibility makes it easy to introduce new infrastructure layers (like a database or cloud bucket) later on.
---

## 🧪 Testing Strategy

### ✅ Unit Tests

- All implementation classes (excluding mock repositories) are **100% covered** with **JUnit 5** and **Mockito**.

- Each service and facade is tested in isolation, ensuring predictable and maintainable business logic.

### 🌐 Integration Tests

The `ProductControllerIT` class uses **MockMvc** for real HTTP-layer testing.

Covered scenarios:

- Valid requests returning 200 OK with expected data.
-  `ProductNotFoundException` resulting in a 404 NOT FOUND.
- Unexpected errors resulting in a 500 INTERNAL SERVER ERROR.
- These tests also ensure that the **ExceptionHandler** (`RestExceptionHandler`) functions as expected.
---

## 🚀 Build and Run Instructions

### 🔧 Step 1: Build the JAR

Run the following command from the backend project root:
```bash
./mvnw clean package -DskipTests
```

It will generate a JAR file under the target/ folder, e.g.:
 
target/product-api-0.0.1-SNAPSHOT.jar  

### ▶️ Step 2: Run the Application

Start the backend with:

```bash
java -jar target/product-api-0.0.1-SNAPSHOT.jar
```
By default, the application runs on port 8080 (unless otherwise configured in application.yml).
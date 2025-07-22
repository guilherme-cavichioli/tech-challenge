# 🧩 Full Stack Product Catalog Project

This project is a full-stack application structured to simulate a product catalog with image and resource links retrieved from a mock storage.

---

## 📁 Project Structure

├── fake-storage/ # Simulated storage with static resource files (e.g., images) **<br >**
├── product-api/ # Backend application using Java 21 and Spring Boot **<br />**
├── product-spa/ # Frontend application using Angular 20 **<br />**
├── docker-compose.yml # Starts backend and frontend containers **<br />**
├── docker-compose-sonar.yml # Starts backend, frontend, and SonarQube for code quality analysis **<br />**
├── board-trello.png # Trello board used to organize the project tasks **<br />**
├── product-api-coverage.png # Backend test coverage from Sonar **<br />**
├── product-spa-coverage.png # Frontend test coverage from Sonar **<br />**

## 🔧 Backend - product-api

- Java 21 with Spring Boot
- Provides the REST endpoint: `GET /v1/products/{id}`
- Responsible for returning product data with composed resource URLs

👉 [View backend documentation](./product-api/README.md)

---

## 💻 Frontend - product-spa

- Angular 20 using the standalone component approach
- New Angular control flow syntax (`@if`, `@for`)
- Available at: `http://localhost:4200`

👉 [View frontend documentation](./product-spa/README.md)

---

## 🧪 Code Coverage (Sonar)

### Sonar Reports

A special Docker setup is provided to analyze test coverage using SonarQube:

```bash
docker-compose -f docker-compose-sonar.yml up
```

This command will start:

- Backend - http://localhost:8080
- Frontend  - http://localhost:4200
- SonarQube - http://localhost:9000

---

### 🔬 Generate Backend Report

Navigate to the backend directory:

```bash
cd ./product-api
```

Then run:

```bash
./gradlew clean test jacocoTestReport
./gradlew sonar -Dsonar.host.url=http://localhost:9000
```

### 📊 Generate Frontend Report
Navigate to the frontend directory:

```bash
cd ./product-spa
```

Then run:

```bash
npx ng test --watch=false --code-coverage
npx sonar-scanner
```

You can now open SonarQube at http://localhost:9000 to inspect both reports.

### 🚀 Run Application Locally
To start both frontend and backend with Docker:

```bash
docker-compose up
```

After that, open your browser at:

http://localhost:4200

You should see the Angular frontend displaying product information from the backend.

### ✅ Summary
This project simulates a real-world architecture with:

 - Separation of concerns (backend, frontend, and storage)
 - Design pattern usage (Facade, Dependency Inversion)
 - High test coverage and CI-ready configuration
 - Dockerized deployment and analysis environment
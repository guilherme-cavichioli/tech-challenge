# ------------ Stage 1: Build -------------------
FROM gradle:8.7-jdk21-alpine AS builder

WORKDIR /app

COPY --chown=gradle:gradle . .

RUN gradle clean build -x test --no-daemon

# ------------ Stage 2: Run -------------------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

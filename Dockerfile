# === Stage 1: Build with Maven ===
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Install Maven directly in container
RUN apk add --no-cache maven

COPY pom.xml .
COPY src ./src

# Use 'mvn' command (not mvnw)
RUN mvn clean package -DskipTests

# === Stage 2: Runtime Image ===
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
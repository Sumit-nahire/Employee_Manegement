# === Stage 1: Build ===
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app
RUN apk add --no-cache maven

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Rename WAR/JAR to app.jar using shell
RUN sh -c 'cp $(ls /app/target/*.war /app/target/*.jar 2>/dev/null | head -1) app.jar'

# === Stage 2: Run ===
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=builder /app/app.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
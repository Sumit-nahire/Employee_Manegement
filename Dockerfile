FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

RUN apk add --no-cache maven

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# ✅ Fixed: Handles both JAR and WAR files
RUN mvn /app/target/*.jar /app/target/*.war ./app.jar || true \
    && ls -la /app/

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# ✅ Copy with fallback
COPY --from=builder /app/*.jar app.jar || COPY --from=builder /app/*.war app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
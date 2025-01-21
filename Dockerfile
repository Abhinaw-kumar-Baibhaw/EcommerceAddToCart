FROM openjdk:17-jdk-slim AS base
WORKDIR /app
COPY target/FullFledgedAddToCart-0.0.1-SNAPSHOT.jar /app/FullFledgedAddToCart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/FullFledgedAddToCart-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

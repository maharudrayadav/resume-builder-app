FROM ubuntu:latest
LABEL authors="maharudra Yadav"
# Build stage
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the entire project into the container
COPY . /app

# Build the app
RUN mvn -f /app/pom.xml clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 80 for Railway
EXPOSE 80

# Run the application on port 80
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=80"]








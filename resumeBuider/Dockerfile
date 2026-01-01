# Change this line to use JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .

# This command should now succeed
RUN mvn -f /app/pom.xml clean package -DskipTests

# Run stage (Make sure this also uses Java 21)
FROM eclipse-temurin:21-jre
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

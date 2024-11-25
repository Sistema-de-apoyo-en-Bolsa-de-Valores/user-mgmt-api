# Use an official Maven image as the base image
FROM openjdk:17-jdk-slim AS build
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package
# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-slim
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /target/*.jar ./
# Set the command to run the application
CMD ["java", "-jar", "user-mgmt-api-1.0.0.jar"]
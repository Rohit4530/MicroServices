# Use a base image with Java, Maven, and Linux utilities
# Use a base image with Java, Maven, and Linux utilities
FROM maven:3.8-openjdk-17 AS build

# Set the working directory
WORKDIR /config-server

# Copy the Maven POM file
COPY pom.xml .

# Copy the source code
COPY src src

# Build the application
RUN mvn clean package -DskipTests

# Use a slim Java image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /config-server

# Copy the JAR file from the build image
COPY --from=build /config-server/target/*.jar config-server.jar

# Expose the port
EXPOSE 8080

# Install basic Linux utilities (replace with your specific needs)
RUN apt-get update && apt-get install -y \
    curl \
    wget \
    && rm -rf /var/lib/apt/lists/*

# Command to run the application
CMD ["java", "-jar", "config-server.jar"]

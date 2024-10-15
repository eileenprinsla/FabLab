# Build stage
FROM maven:3.8.6-openjdk-17-slim AS build

# Set the working directory for the build stage
WORKDIR /home/app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application (you can skip tests for faster builds)
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:17-jre-slim

# Set environment variables for your Spring Boot app (e.g., memory settings)
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Copy the jar file from the build stage
COPY --from=build /home/app/target/FabLab-0.0.1-SNAPSHOT.jar /usr/local/lib/fablab.jar

# Expose the application port (Railway typically uses port 8080 for HTTP)
EXPOSE 8080

# Create a non-root user for better security
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

# Change ownership of the application JAR
RUN chown appuser:appgroup /usr/local/lib/fablab.jar

# Switch to the non-root user
USER appuser

# Command to run the Spring Boot application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /usr/local/lib/fablab.jar"]

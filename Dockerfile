# Use the Jelastic Maven image to build the project
FROM jelastic/maven:3.9.5-openjdk-21 as builder

# Set the working directory inside the builder container
WORKDIR /build

# Copy the entire project to the container's working directory
COPY . .

# Run the Maven build process to create the .jar file
RUN mvn clean package -DskipTests

# Verify that the JAR file exists after the build
RUN ls -l /build/target

# Use the OpenJDK JRE base image for the final image
FROM openjdk:21-slim

# Create a directory for the application
WORKDIR /app

# Copy the .jar file from the builder stage to the final image
COPY --from=builder /build/target/rentacarProject-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the application port
EXPOSE 8080

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
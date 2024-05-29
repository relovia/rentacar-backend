FROM mvn:openjdk:21-jdk as builder
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jre-slim
COPY --from=builder /rentacarProject/target/rentacarProject-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
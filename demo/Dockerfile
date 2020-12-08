FROM maven:3.6.3-jdk-11 AS builder
LABEL maintainer="Nikolina Tomic"
LABEL description="Docker image for building and running Java Spring App using Java 11"
WORKDIR /home/app
COPY . .
RUN mvn -f pom.xml clean package -D skipTests

FROM openjdk:11-jre-slim
EXPOSE 8080
COPY --from=builder /home/app/target/*.jar /home/app.jar
ENTRYPOINT ["java","-jar","/home/app.jar"]
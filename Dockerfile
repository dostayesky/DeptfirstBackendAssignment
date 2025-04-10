FROM openjdk:21-jdk-slim

COPY assignment_backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
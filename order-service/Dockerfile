# file logic is explained in ./customer-service/Dockerfile, for educational purposes.
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
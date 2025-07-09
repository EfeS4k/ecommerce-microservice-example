# means this container is based on Java 17 (openjdk)
FROM openjdk:17-jdk-alpine

# selects /tmp file as temporary file. SpringBoot writes temporary files into /tmp
VOLUME /tmp

#Copies the jar file from the build/libs folder (created after the ./gradlew build)
 # on the host machine to the container as app.jar.
COPY build/libs/*.jar app.jar

# The code that will run when the app starts. java -jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
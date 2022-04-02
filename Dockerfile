FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} locacionesBackend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/locacionesBackend-0.0.1-SNAPSHOT.jar"]
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/inst-photo-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} inst-photo-service.jar
ENTRYPOINT ["java","-jar","/inst-photo-service.jar"]


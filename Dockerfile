#FROM postgres:13.5
#ENV POSTGRES_PASSWORD 1234
#ENV POSTGRES_DB photo
#ENV POSTGRES_USER postgres
#EXPOSE 9000

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/inst-photo-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} inst-photo-service.jar
ENTRYPOINT ["java","-jar","/inst-photo-service.jar"]


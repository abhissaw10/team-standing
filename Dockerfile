FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Abhishek Sawhney
EXPOSE 27017
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/team-standing-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} team-standing.jar
ENTRYPOINT ["java","-jar","/team-standing.jar"]
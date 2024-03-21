# Build
FROM gradle:jdk21 AS build
COPY . /tmp
RUN gradle build --no-daemon

# Package
FROM openjdk:21-jdk
VOLUME /tmp
COPY ./service/build/libs/*.jar app.jar
ARG profile
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${profile}","app.jar"]

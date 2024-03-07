FROM openjdk:21-jdk
VOLUME /tmp
COPY ./service/build/libs/*.jar app.jar
ARG profile=local
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${profile}","app.jar"]

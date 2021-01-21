FROM openjdk:11-jre
COPY ./target/*.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","ha-session-0.0.1-SNAPSHOT.jar","--spring.profiles.active=docker"]
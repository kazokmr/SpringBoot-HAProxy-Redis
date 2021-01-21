FROM openjdk:11 as build
COPY ./ /build
RUN cd /build && ./mvnw clean package

FROM openjdk:11-jre
COPY --from=build /build/target/*.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","ha-session-0.0.1-SNAPSHOT.jar"]
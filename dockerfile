FROM maven:3-adoptopenjdk-11 as builder
COPY ./src src
COPY ./pom.xml pom.xml
RUN mvn package

FROM openjdk:11-jdk-slim
COPY --from=builder target/plenetarium-beta-0.0.1-SNAPSHOT.jar planetariumbeta.jar
ENTRYPOINT [ "java", "-jar", "planetariumbeta.jar" ]
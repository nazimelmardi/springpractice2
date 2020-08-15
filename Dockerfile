FROM openjdk:8-jdk-alpine
RUN apk add --no-cache \
    maven

WORKDIR /app

COPY . /app

RUN mvn package -Dmaven.test.skip

FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8081

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","/library-stats-0.0.1-SNAPSHOT.jar"]
FROM java:8-jdk-alpine
COPY ./build/libs/functionhall-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8057
ENTRYPOINT ["java", "-jar", "functionhall-service-0.0.1-SNAPSHOT.jar"]

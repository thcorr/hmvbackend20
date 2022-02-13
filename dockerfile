FROM openjdk:17-jdk-alpine
COPY target/hmvbackend20-0.0.1-SNAPSHOT.jar hmvbackend20-0.0.1-SNAPSHOT.jar
EXPOSE 8080 5432
ENTRYPOINT ["java","-jar","/hmvbackend20-0.0.1-SNAPSHOT.jar"]
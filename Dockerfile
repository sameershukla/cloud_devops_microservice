FROM openjdk:8-jdk-alpine

COPY build/libs/demo-service-0.0.1-SNAPSHOT.jar /demo.jar

EXPOSE 8080

CMD ["java", "-jar", "demo.jar"]

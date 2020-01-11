FROM openjdk:8-windowsservercore

COPY build/libs/demo-service-0.0.1-SNAPSHOT.jar /demo.jar

EXPOSE 8001

CMD ["java", "-jar", "demo.jar"]
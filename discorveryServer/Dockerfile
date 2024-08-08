FROM openjdk:17
COPY /target/*.jar discoveryServer.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "discoveryServer.jar"]
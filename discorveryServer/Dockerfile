FROM openjdk:17
COPY /target/*.jar discoveryserver.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "discoveryserver.jar"]
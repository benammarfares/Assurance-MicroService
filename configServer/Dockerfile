FROM openjdk:17
COPY /target/*.jar configServer.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "configServer.jar"]
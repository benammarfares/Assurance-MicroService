FROM openjdk:17
COPY /target/*.jar configserver.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "configserver.jar"]
FROM openjdk:17
COPY /target/*.jar gateway.jar
EXPOSE 8222
ENTRYPOINT ["java", "-jar", "gateway.jar"]
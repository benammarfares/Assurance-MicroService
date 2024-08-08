FROM openjdk:17
COPY /target/*.jar assurancePolicy.jar
EXPOSE 8060
ENTRYPOINT ["java", "-jar", "assurancePolicy.jar"]
FROM openjdk:17
COPY /target/*.jar assurancepolicy.jar
EXPOSE 8060
ENTRYPOINT ["java", "-jar", "assurancepolicy.jar"]
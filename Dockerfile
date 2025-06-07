FROM openjdk:17
COPY target/FormHandling-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "FormHandling-0.0.1-SNAPSHOT.jar"]

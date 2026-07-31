FROM eclipse-temurin:25-jre
LABEL authors="sameer"

WORKDIR /app
COPY app/build/libs/app.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
# Étape 1 : Image Maven pour builder l'application
FROM maven:3.9-eclipse-temurin-21 AS build

# Créer un répertoire de travail
WORKDIR /app

# Copier les fichiers pom.xml et src dans l'image
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine

RUN addgroup -S nonroot \
    && adduser -S nonroot -G nonroot

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

USER nonroot

ENTRYPOINT ["java", "-jar", "app.jar"]

FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /build

COPY pom.xml .

COPY src ./src

RUN mvn package -DskipTests

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY --from=build /build/target/quarkus-app /app/

EXPOSE 4000

CMD ["java", "-jar", "/app/quarkus-run.jar"]

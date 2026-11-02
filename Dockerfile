FROM gradle:8-jdk21 AS build
WORKDIR /workspace

COPY build.gradle settings.gradle ./
RUN gradle dependencies --configuration runtimeClasspath -q > /dev/null 2>&1 || true

COPY . .
RUN gradle build -x test

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /workspace/build/quarkus-app /app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quarkus-run.jar"]

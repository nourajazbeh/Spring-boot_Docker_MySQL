FROM openjdk:23-jdk-slim AS build
WORKDIR /home/app
COPY pom.xml .
COPY src ./src
RUN apt-get update && apt-get install -y maven
RUN java -version  # Hier wird die Java-Version angezeigt
RUN mvn clean package

FROM openjdk:23-jdk-slim
COPY --from=build /home/app/target/spring_rest_docker.jar spring_rest_docker.jar
ENTRYPOINT ["java", "-jar", "spring_rest_docker.jar"]

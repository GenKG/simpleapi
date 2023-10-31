FROM maven:3.8.6-jdk-8-slim AS build
ARG BOARD_API_DB_HOST
ARG BOARD_API_DB_PORT
ARG BOARD_API_DB_NAME
ARG BOARD_API_DB_USERNAME
ARG BOARD_API_DB_PASSWORD
ARG PORT
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:8-jre-slim
ARG OPTIONS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Xmx256m -Xss512k -XX:MetaspaceSize=100m -jar /apps/app.jar"
ENV OPT=$OPTIONS
COPY --from=build /home/app/target/simpleapi-1.0.jar /usr/local/lib/simpleapi-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java ${OPT}", "-jar","/usr/local/lib/simpleapi-1.0.jar"]
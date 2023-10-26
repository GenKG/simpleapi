#FROM maven:3.5.2-jdk-8-alpine
#COPY /target/simpleapi-1.0.jar myfirstapi.jar
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/myfirstapi.jar"]




##FROM openjdk:8-jdk-alpine
##
##ARG JAR_FILE
##
##RUN mkdir -p /apps
##COPY ./target/${JAR_FILE} /apps/app.jar
##COPY ./entrypoint.sh /apps/entrypoint.sh
##
##RUN chmod +x /apps/entrypoint.sh
##CMD ["/apps/entrypoint.sh"]

FROM maven:3.8.6-jdk-8-slim AS build
ARG BOARD_API_DB_URL
ARG BOARD_API_DB_USERNAME
ARG BOARD_API_DB_PASSWORD
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/simpleapi-1.0.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
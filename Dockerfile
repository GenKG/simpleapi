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


FROM maven:3.5.3-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/WORKDIR /tmp/
RUN mvn package FROM openjdk:8-jdk-alpine
COPY --from=MAVEN_TOOL_CHAIN  /tmp/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
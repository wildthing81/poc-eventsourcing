# Deploy war to Tomcat
# presumes that the war file has been generated locally.
#FROM adoptopenjdk/openjdk11:latest
FROM openjdk:11.0.4-jre-slim
ARG env=dev
LABEL maintainer="ramaswamy.ramanathan@anz.com"
EXPOSE 8085

ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]

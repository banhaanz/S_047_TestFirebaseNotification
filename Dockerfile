FROM openjdk:8-jdk-alpine
RUN echo "Asia/Bangkok" > /etc/timezone
ARG JAR_NAME
COPY /target/${JAR_NAME}.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
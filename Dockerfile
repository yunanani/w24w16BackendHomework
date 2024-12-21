FROM openjdk:21-jdk
COPY app.jar /app/App.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

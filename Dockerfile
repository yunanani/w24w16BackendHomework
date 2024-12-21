FROM openjdk:21-jdk
COPY App.jar /app/App.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","App.jar"]

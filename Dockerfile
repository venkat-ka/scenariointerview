# Create an Image
FROM openjdk:8-jdk-alpine
WORKDIR /home/app

COPY . /home/app
EXPOSE 8080
ADD target/*.jar /home/app/app.jar
#COPY /home/app/*.jar app.jar
#COPY --from=stage1 /home/app/target/hello-world-java.jar hello-world-java.jar
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
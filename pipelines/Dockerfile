FROM openjdk:8
ADD target/pipelines-0.0.1-SNAPSHOT.jar pipelines-0.0.1-SNAPSHOT.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java" ,"-Dspring.data.mongodb.uri=mongodb://mongodb/micros", "-Djava.security.egd=file:/dev/./urandom","-jar", "pipelines-0.0.1-SNAPSHOT.jar"]
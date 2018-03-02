FROM openjdk:8
ADD target/products.jar products.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java" ,"-Dspring.data.mongodb.uri=mongodb://mongodb/micros", "-Djava.security.egd=file:/dev/./urandom","-jar", "products.jar"]
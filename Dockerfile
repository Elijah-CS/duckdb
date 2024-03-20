FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY ./build/ /app/build
COPY ./data/ /app/data

CMD  java -cp /app/build/libs/java_duckdb.jar:/app/build/resources/* \
      example.Main

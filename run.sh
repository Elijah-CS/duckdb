DIR=$(pwd)

echo $DIR

java -cp build/libs/java_duckdb.jar:$DIR/build/resources/* \
      example.Main
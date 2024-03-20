DIR=$(pwd)

echo $DIR

java -cp build/libs/mocking.jar:$DIR/build/resources/* \
      example.Main
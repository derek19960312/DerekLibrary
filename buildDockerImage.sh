mvn clean package
imagetag=derek-library
docker build -t $imagetag .
docker run -p 8080:8080 $imagetag
#docker rm
#docker rmi $imagetag
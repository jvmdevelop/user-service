./mvnw clean package -DskipTests
 sudo docker-compose down -v &&
      sudo docker-compose up --build

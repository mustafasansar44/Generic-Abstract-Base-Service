FROM openjdk:17-oracle
COPY target/laborant-0.0.1-SNAPSHOT.jar laborant.jar
ENTRYPOINT ["java", "-jar", "laborant.jar"]



/*
mvn clean install sonrası laborant-0.0.1-SNAPSHOT.jar oluşacak. oranın adını yaz.
*/
# Usamos una imagen oficial de Java 17
FROM openjdk:17-jdk-slim

# Seteamos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo JAR de nuestra aplicación
COPY target/analizador-alertas-0.0.1-SNAPSHOT.jar app.jar

# Copia el wallet al contenedor
COPY src/main/resources/wallet /app/wallet

# Exponemos el puerto en el que corre Spring Boot
EXPOSE 8082

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]

# Imagem base com Java 17
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copia o jar da aplicação para o container
COPY target/demo-seplag-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR da aplicação para o contêiner
COPY target/cavera-backend.jar /app/cavera-backend.jar

# Exponha a porta que a aplicação usará
EXPOSE 8068

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/cavera-backend.jar"]

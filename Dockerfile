# Usando a imagem base do OpenJDK 21
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o JAR da aplicação para o contêiner
# Certifique-se de que o arquivo JAR esteja na pasta 'target' do seu projeto antes de rodar o build
COPY target/cavera-control-0.0.1-SNAPSHOT.jar /app/cavera-control-0.0.1-SNAPSHOT.jar

# Exponha a porta que a aplicação usará (8068 conforme configurado)
EXPOSE 8068

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/cavera-control-0.0.1-SNAPSHOT.jar"]

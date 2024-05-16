# Primeiro estágio: Construir a aplicação com Maven e Java 20
FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

# Copiar o arquivo pom.xml para baixar as dependências
COPY pom.xml .

# Baixar as dependências do Maven
RUN mvn dependency:go-offline

# Copiar o código-fonte da aplicação
COPY src ./src

# Compilar a aplicação
RUN mvn clean install

# Segundo estágio: Executar o JAR gerado
FROM tomcat:9.0.69-jre17
#COPY instruction is used to copy files and directories to the destination within the  filesystem of Docker image.
WORKDIR /app
# Copiar o JAR gerado do primeiro estágio
COPY --from=builder /app/target/moduloweb-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
#CMD instruction is used to set a command to be executed when running a container. There must be only one CMD in a
# Dockerfile. If more than one CMD is found then only last CMD is effective.
CMD ["catalina.sh", "run"]
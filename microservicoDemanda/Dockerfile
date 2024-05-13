# Primeiro estágio: Construir a aplicação com Maven e Java 20
FROM 3.8.7-openjdk-18-slim AS builder

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
FROM openjdk:18-slim

WORKDIR /app

# Copiar o JAR gerado do primeiro estágio
COPY --from=builder /app/target/microservicoDemanda-0.0.1-SNAPSHOT.jar .

# Executar o JAR
CMD ["java", "-jar", "microservicoDemanda-0.0.1-SNAPSHOT.jar"]

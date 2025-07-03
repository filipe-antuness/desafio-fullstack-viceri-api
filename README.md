# Desafio FullStack Viceri

Sistema para cadastro e gerenciamento de heróis e superpoderes.

- Utilizei o Java 21 com Spring Boot, pois é a versão que estou utilizando 
atualmente para alguns trabalhos da pós-graduação.

- Escolhei o SQL Server como banco de dados, pois já utilizei anteriormente em alguns projetos.

- Já o IntelliJ IDEA é a IDE que mais utilizo, e por considerar ser a 
melhor para trabalhar com Java e Spring Boot atualmente.

## Tecnologias Utilizadas

- **Java:** 21
- **Spring Boot:** 3.5.3
- **Maven**
- **Banco de Dados:** SQL Server
- **IDE:** IntelliJ IDEA 2024.3.1.1

## Pré-requisitos

- Java 21 instalado
- Maven instalado
- SQL Server em execução
- IntelliJ IDEA (ou outra IDE)

## Configuração do Projeto
1. No arquivo src/main/resources/application.properties, configure:  
    ```properties
    spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=superherois;TrustServerCertificate=true
    spring.datasource.username=sa
    spring.datasource.password=1234
    spring.jpa.hibernate.ddl-auto=none
    spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    spring.jpa.show-sql=true
   
2. Ajuste o usuário e senha conforme sua configuração.

## Configuração do Banco de Dados

1. Crie o banco de dados no SQL Server:
   ```sql
   CREATE DATABASE superherois;
   
2. Execute o script de criação das tabelas:
   ```sql
   CREATE TABLE dbo.Herois (
    Id INT IDENTITY(1,1) NOT NULL,
    Nome NVARCHAR(120) NOT NULL,  
    NomeHeroi NVARCHAR(120) NOT NULL,
    DataNascimento DATETIME2(7) NULL, 
    Altura FLOAT NOT NULL,
    Peso FLOAT NOT NULL,

    CONSTRAINT PK_Herois PRIMARY KEY (Id)
    );
    GO


    CREATE TABLE dbo.Superpoderes (
    Id INT IDENTITY(1,1) NOT NULL,
    Superpoder NVARCHAR(50) NOT NULL,
    Descricao NVARCHAR(250) NULL,
    CONSTRAINT PK_Superpoderes PRIMARY KEY (Id)
    );
    GO
    
    INSERT INTO dbo.Superpoderes (Superpoder, Descricao)
    VALUES
    ('Voar', 'Capacidade de se deslocar pelo ar sem auxílio de tecnologia.'),
    ('Super Força', 'Força física muito acima da capacidade de um ser humano normal.'),
    ('Invisibilidade', 'Capacidade de se tornar indetectável ao olho nu.'),
    ('Super Velocidade', 'Habilidade de se mover em velocidades extraordinárias.'),
    ('Telepatia', 'Capacidade de ler os pensamentos e se comunicar mentalmente.'),
    ('Fator de Cura Acelerado', 'Habilidade de curar ferimentos em um ritmo sobre-humano.'),
    ('Controle Climático', 'Capacidade de manipular os elementos do clima, como chuva e raios.'),
    ('Lançar Teias', NULL), -- Exemplo de um poder com descrição nula
    ('Visão de Calor', 'Capacidade de emitir feixes de energia térmica pelos olhos.');
    GO
    
    
    CREATE TABLE dbo.HeroisSuperpoderes (
    HeroiId INT NOT NULL,
    SuperpoderId INT NOT NULL,

    CONSTRAINT PK_HeroisSuperpoderes PRIMARY KEY (HeroiId, SuperpoderId),

    CONSTRAINT FK_HeroisSuperpoderes_Herois FOREIGN KEY (HeroiId)
        REFERENCES dbo.Herois (Id)
        ON DELETE CASCADE, 

    CONSTRAINT FK_HeroisSuperpoderes_Superpoderes FOREIGN KEY (SuperpoderId)
        REFERENCES dbo.Superpoderes (Id)
        ON DELETE CASCADE 
    );
    GO

   ```

Note que o script acima cria as tabelas `Herois`, `Superpoderes` e `HeroisSuperpoderes`, 
além de inserir alguns superpoderes pré-definidos.

Porém não inclui dados de heróis.

Para inserir heróis, utilize o método cadastro de heróis da API através do Frontend ou do Swagger.

## Como rodar o projeto
1. Clone o repositório:  
    ```bash
    git clone https://github.com/filipe-antuness/desafio-fullstack-viceri-api.git


2. Abra o projeto na IntelliJ IDEA (ou outra IDE).  
    Execute:  
    ```cmd
    mvn clean install

3. Inicie a aplicação:  
    ```cmd
    mvn spring-boot:run
   
A API estará disponível em http://localhost:8080.  

## Frontend
O frontend Angular deve rodar em http://localhost:4200 para integração.

Caso o frontend esteja rodando em outra porta, será nescessário ajustar o arquivo de configuração CorsConfig.java
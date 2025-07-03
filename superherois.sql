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

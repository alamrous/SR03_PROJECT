CREATE DEFINER=`root`@`localhost` PROCEDURE `script_creation_tables`()
BEGIN
  
    CREATE TABLE IF NOT EXISTS Plateforme(
    id INT auto_increment PRIMARY KEY ,
    nom varchar(100)
    );
CREATE TABLE IF NOT EXISTS Pays (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS Editeur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    country_fk INT,
    CONSTRAINT FOREIGN KEY (country_fk)
        REFERENCES Pays (id)
);
CREATE TABLE IF NOT EXISTS Pegi (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS Genre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS Jeu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    pegi_fk INT,
    note DOUBLE,
    summary VARCHAR(500),
    editeur_fk INT,
    CONSTRAINT contrainte2 FOREIGN KEY (pegi_fk)
        REFERENCES Pegi (id),
    CONSTRAINT contrainte3 FOREIGN KEY (editeur_fk)
        REFERENCES Editeur (id)
);

CREATE TABLE IF NOT EXISTS Etat_Compte (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS Client (
    id INT(9) AUTO_INCREMENT,
    name VARCHAR(50),
    firstname VARCHAR(50),
    pseudo VARCHAR(50),
    pwd VARCHAR(50),
    gender ENUM('F', 'M', 'AH'),
    email VARCHAR(50),
    date_creation DATE,
    birthdate DATE,
    address VARCHAR(500),
    compte_fk_etat_compte INT,
    CONSTRAINT fk_client_etat FOREIGN KEY (compte_fk_etat_compte)
        REFERENCES Etat_Compte (id),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS Etat_Achat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS Panier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_fk INT,
    date_creation DATE,
    CONSTRAINT contrainte1 FOREIGN KEY (client_fk)
        REFERENCES Client (id)
);
CREATE TABLE IF NOT EXISTS Achat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_ajout DATE,
    date_fin DATE,
    etat_achat_fk INT,
    panier_fk INT,
    jeu_fk INT,
    CONSTRAINT achat_etat FOREIGN KEY (etat_achat_fk)
        REFERENCES Etat_Achat (id),
    CONSTRAINT achat_panier FOREIGN KEY (panier_fk)
        REFERENCES Panier (id),
    CONSTRAINT achat_jeu FOREIGN KEY (jeu_fk)
        REFERENCES Jeu (id)
);
    
    CREATE TABLE IF NOT EXISTS Jeu_Genre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jeu_fk INT,
    genre_fk INT,
    CONSTRAINT jeu_genre_jeu FOREIGN KEY (jeu_fk)
        REFERENCES Jeu (id),
    CONSTRAINT jeu_genre_plat FOREIGN KEY (genre_fk)
        REFERENCES Genre (id)
);
CREATE TABLE IF NOT EXISTS Jeu_Plateforme (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jeu_fk INT,
    plateforme_fk INT,
    date_sortie DATE,
    CONSTRAINT jeu_plat_jeu FOREIGN KEY (jeu_fk)
        REFERENCES Jeu (id),
    CONSTRAINT jeu_plat_plat FOREIGN KEY (plateforme_fk)
        REFERENCES Plateforme (id)
); 

    
END
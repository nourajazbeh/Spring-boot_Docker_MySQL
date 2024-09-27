-- Erstellen Sie die Tabelle 'persons', falls sie nicht existiert
CREATE TABLE IF NOT EXISTS persons (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Beispiel-Daten in die Tabelle einfügen
INSERT INTO persons (name) VALUES ('noura');
INSERT INTO persons (name) VALUES ('karim');

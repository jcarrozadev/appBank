/* Javier Arias Carroza */

CREATE DATABASE IF NOT EXISTS BDBizum;

USE BDBizum;

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono CHAR(9) UNIQUE,
    email VARCHAR(150) UNIQUE,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    saldo INT DEFAULT 0
);
CREATE TABLE Transacciones (
    idTransaccion INT AUTO_INCREMENT PRIMARY KEY,
    idEmisor INT,
    idReceptor INT,
    tipo CHAR(1),
    cantidad INT,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (idEmisor) REFERENCES Usuarios(id),
    FOREIGN KEY (idReceptor) REFERENCES Usuarios(id)
);


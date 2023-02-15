CREATE TABLE usuariosWeb(
    id INTEGER AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    nombreUsuario VARCHAR(100) NOT NULL,
    contrasena VARCHAR(20) NOT NULL,
    fechaRegistro DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    esSocio BOOLEAN DEFAULT false NOT NULL,
    PRIMARY KEY(id)
    
);

CREATE TABLE socios(
    id INTEGER AUTO_INCREMENT,
    dni VARCHAR(10) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    primerApellido VARCHAR(30) NOT NULL,
    segundoApellido VARCHAR(30) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    fechaNacimiento VARCHAR(20) NOT NULL,
    telefono VARCHAR(50),
    idUsuario INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(idUsuario) REFERENCES usuariosWeb(id) ON DELETE CASCADE ON UPDATE CASCADE
); 

CREATE TABLE zona(
    id INTEGER AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO zona (nombre) VALUES ('Norte');
INSERT INTO zona (nombre) VALUES ('Sur');
INSERT INTO zona (nombre) VALUES ('Este');
INSERT INTO zona (nombre) VALUES ('Oeste');


CREATE TABLE abonos(
    id INTEGER AUTO_INCREMENT,
    importe DOUBLE NOT NULL,
    esJoven BOOLEAN DEFAULT false NOT NULL,
    esAdulto BOOLEAN DEFAULT false NOT NULL,
    esJubilado BOOLEAN DEFAULT false NOT NULL,
    asiento INTEGER NOT NULL,
    fechaInscripcion DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    idSocio INTEGER NOT NULL,
    idZona INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(idSocio) REFERENCES socios(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(idZona) REFERENCES zona(id) 
);


CREATE TABLE gestores(
    id INTEGER AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    esAdmin BOOLEAN DEFAULT false,
    PRIMARY KEY(id)
);


CREATE DATABASE IF NOT EXISTS Biblioteca;
USE Biblioteca;
DROP TABLE IF EXISTS Usuarios;
-- Tabla Usuarios
CREATE TABLE Usuarios(
ID VARCHAR(200) PRIMARY KEY,
Nombre VARCHAR(100),
esAdmin BOOLEAN
);
-- Consulta para saber los Usuarios que son administradores.
SELECT * FROM Usuarios WHERE esAdmin = TRUE;
DROP TABLE IF EXISTS Libros;
-- Tabla Libros
CREATE TABLE Libros(
ID INT AUTO_INCREMENT PRIMARY KEY,
Nombre VARCHAR(100),
Autor VARCHAR(100),
ISBN VARCHAR(100)
);

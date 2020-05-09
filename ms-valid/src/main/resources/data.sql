DROP TABLE IF EXISTS personas;
 
CREATE TABLE personas (
  per_id INT AUTO_INCREMENT  PRIMARY KEY,
  per_nombre VARCHAR(100) NOT NULL,
  per_apellido VARCHAR(100) NOT NULL,
  per_procesado BOOLEAN DEFAULT false
);
 
INSERT INTO personas (per_nombre, per_apellido) VALUES
  ('Francisco', 'Gómez'),  
  ('Nathán', 'Gómez');
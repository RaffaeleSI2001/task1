CREATE TABLE users (
 id  bigint(3) NOT NULL AUTO_INCREMENT,
 first_name varchar(120) NOT NULL,
 last_name varchar(220) NOT NULL,
 birthday DATE NOT NULL,
 PRIMARY KEY (id)
);

INSERT INTO users (first_name, last_name, birthday) VALUES
(1, 'Alice', 'Rossi', '1990-03-15'),
(2, 'Marco', 'Bianchi', '1985-07-22'),
(3, 'Giulia', 'Verdi', '1992-11-05'),
(4, 'Luca', 'Neri', '1988-01-30'),
(5, 'Francesca', 'Gallo', '1995-06-18'),
(6, 'Davide', 'Fontana', '1983-09-09'),
(7, 'Sara', 'Conti', '1991-12-25'),
(8, 'Matteo', 'Ferrari', '1986-04-02'),
(9, 'Elena', 'Costa', '1993-08-14'),
(10, 'Simone', 'Greco', '1989-10-31');

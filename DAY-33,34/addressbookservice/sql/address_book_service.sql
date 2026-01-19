-- QUERY FOR CREATE DATABASE
-- ------------------------------
CREATE DATABASE address_book__service;
USE address_book__service;

CREATE TABLE address_book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(150),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(10),
    phone_number VARCHAR(10),
    email VARCHAR(100)
);

CREATE TABLE address_book_type (
    type_id INT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(50) UNIQUE
);

CREATE TABLE person_type (
    person_id INT,
    type_id INT,
    PRIMARY KEY (person_id, type_id),
    FOREIGN KEY (person_id) REFERENCES address_book(id),
    FOREIGN KEY (type_id) REFERENCES address_book_type(type_id)
);

SELECT * FROM address_book;
SELECT * FROM address_book_type;
SELECT * FROM person_type;



INSERT INTO address_book (first_name, last_name, address, city, state, zip, phone_number, email) VALUES
('Arun', 'Kumar', 'mettupatty', 'dindigul', 'tamil nadu', '624001', '9876543211', 'arun@gmail.com'),
('priya', 'sharma', 'anguvilas', 'madurai', 'tamil nadu', '624002', '9876543212', 'priya@gmail.com'),
('ramesh', 'patel', 'kodambakkam', 'chennai', 'tamil nadu', '624003', '9876543213', 'ramesh@gmail.com'),
('sneha', 'iyer', 'anna nagar', 'karur', 'tamil nadu', '624004', '9876543214', 'sneha@gmail.com'),
('vikram', 'singh', 'balakrishnapuram', 'hosur', 'tamil nadu', '624005', '9876543215', 'vikram@gmail.com');

INSERT INTO address_book_type (type_name)
VALUES ('Family'), ('Friends'), ('Profession');

INSERT INTO person_type (person_id, type_id)
VALUES
(2, 3),  
(4, 3),
(5,2);


  DELETE FROM address_book WHERE first_name = 'vikram';
  
  SELECT * FROM address_book WHERE city = 'Chennai';
  
  SELECT * FROM address_book WHERE state = 'Tamil Nadu';
  
  SELECT * FROM address_book WHERE city = 'Chennai' OR state = 'Karnataka';
  
  SELECT * FROM address_book WHERE city = 'Bengaluru' AND state = 'Karnataka';
  
  SELECT city, count(*) AS count FROM address_book GROUP BY city;
  
  SELECT state, count(*) AS count FROM address_book GROUP BY state;
  
  SELECT * FROM address_book WHERE city = 'chennai' ORDER BY first_name ASC;
  
  SELECT * FROM address_book WHERE city = 'chennai' ORDER BY first_name desc;
  
  SELECT * FROM address_book WHERE city = 'chennai' ORDER BY first_name ASC, last_name ASC;
  
SELECT address_book_type, count(*) FROM address_book GROUP BY address_book_type;

SELECT abt.type_name AS contact_type, COUNT(pt.person_id) AS total_contacts FROM address_book_type abt JOIN person_type pt ON abt.type_id = pt.type_id GROUP BY abt.type_name;

INSERT INTO person_type (person_id, type_id)
VALUES (2, 1);

  
SELECT * FROM address_book;
SELECT * FROM address_book_type;
SELECT * FROM person_type;




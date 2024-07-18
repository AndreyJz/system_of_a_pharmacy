CREATE DATABASE pharmacy;

USE pharmacy;

CREATE TABLE countries (
    id int AUTO_INCREMENT,
    country varchar(20),
    CONSTRAINT pk_countries_id PRIMARY KEY (id)
);

CREATE TABLE cities (
    id int AUTO_INCREMENT,
    city varchar(20),
    country int,
    CONSTRAINT pk_cities_id PRIMARY KEY (id),
    CONSTRAINT fk_customers_contries_city FOREIGN KEY (country) REFERENCES contries(id),
);

CREATE TABLE neighborhoods (
    id int AUTO_INCREMENT,
    neighborhood varchar(20),
    city int,
    CONSTRAINT pk_neighborhoods_id PRIMARY KEY (id),
    CONSTRAINT fk_neighborhoods_cities_city FOREIGN KEY (city) REFERENCES cities(id),
);

CREATE TABLE idtypes (
    id int AUTO_INCREMENT,
    doc varchar(20),
    CONSTRAINT pk_idtypes_id PRIMARY KEY (id)
);

CREATE TABLE customers (
    id varchar(20),
    doctype int,
    name varchar(20),
    lastname varchar(20),
    age int(3),
    birthdate DATE,
    registerdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    neighborhood int,
    CONSTRAINT fk_customers_idtypes_doctype FOREIGN KEY (doc_type) REFERENCES idtypes(id),
    CONSTRAINT fk_customers_neighborhoods_neighborhood FOREIGN KEY (neighborhood) REFERENCES neighborhoods(id)
);
DROP DATABASE IF EXISTS pharmacy;
CREATE DATABASE pharmacy;

USE pharmacy;

CREATE TABLE countries (
    id int AUTO_INCREMENT,
    country varchar(40),
    CONSTRAINT pk_countries_id PRIMARY KEY (id)
);

CREATE TABLE cities (
    id int AUTO_INCREMENT,
    city varchar(40),
    country int,
    CONSTRAINT pk_cities_id PRIMARY KEY (id),
    CONSTRAINT fk_cities_countries_country FOREIGN KEY (country) REFERENCES countries(id)
);

CREATE TABLE neighborhoods (
    id int AUTO_INCREMENT,
    neighborhood varchar(40),
    city int,
    CONSTRAINT pk_neighborhoods_id PRIMARY KEY (id),
    CONSTRAINT fk_neighborhoods_cities_city FOREIGN KEY (city) REFERENCES cities(id)
);

CREATE TABLE idtypes (
    id int AUTO_INCREMENT,
    doc varchar(40),
    CONSTRAINT pk_idtypes_id PRIMARY KEY (id)
);

CREATE TABLE customers (
    id varchar(20),
    doctype int,
    name varchar(30),
    lastname varchar(30),
    age int,
    birthdate DATE,
    registerdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    neighborhood int,
    CONSTRAINT pk_customers_id PRIMARY KEY (id),
    CONSTRAINT fk_customers_idtypes_doctype FOREIGN KEY (doctype) REFERENCES idtypes(id),
    CONSTRAINT fk_customers_neighborhoods_neighborhood FOREIGN KEY (neighborhood) REFERENCES neighborhoods(id)
);

CREATE TABLE administrationRoutes (
    id INT AUTO_INCREMENT,
    x VARCHAR(50),
    CONSTRAINT pk_administration_routes_id PRIMARY KEY (id)
);

CREATE TABLE activeIngredients (
    id INT AUTO_INCREMENT,
    active_ingredient VARCHAR(100),
    CONSTRAINT pk_active_ingredient__id PRIMARY KEY (id)
);

CREATE TABLE unitsOfMeasure (
    id INT AUTO_INCREMENT,
    unit_of_measure VARCHAR(50),
    CONSTRAINT pk_unit_of_measure_id PRIMARY KEY (id)
);

CREATE TABLE laboratories (
    id INT AUTO_INCREMENT,
    laboratory VARCHAR(100),
    CONSTRAINT pk_laboratories_id PRIMARY KEY (id)
);

CREATE TABLE suppliers (
    id INT AUTO_INCREMENT,
    supplier VARCHAR(100),
    CONSTRAINT pk_suppliers_id PRIMARY KEY (id)
);

CREATE TABLE presentations (
    id INT AUTO_INCREMENT,
    presentation VARCHAR(100),
    CONSTRAINT pk_presentations_id PRIMARY KEY (id)
);

CREATE TABLE products (
    product_code VARCHAR(50),
    product_name VARCHAR(100),
    invima_registration VARCHAR(50),
    administration_route_id INT,
    active_ingredient_id INT,
    unit_of_measure_id INT,
    laboratory_id INT,
    supplier_id INT,
    presentation_id INT,
    expiration_date DATE,
    stock INT,
    stock_min INT,
    stock_max INT,
    sale_value DECIMAL(10, 2),
    CONSTRAINT pk_products_product_code PRIMARY KEY (product_code),
    CONSTRAINT fk_products_administration_route_id FOREIGN KEY (administration_route_id) REFERENCES administrationRoutes(id),
    CONSTRAINT fk_products_active_ingredient_id FOREIGN KEY (active_ingredient_id) REFERENCES activeIngredients(id),
    CONSTRAINT fk_products_unit_of_measure_id FOREIGN KEY (unit_of_measure_id) REFERENCES unitsOfMeasure(id),
    CONSTRAINT fk_products_laboratory_id FOREIGN KEY (laboratory_id) REFERENCES laboratories(id),
    CONSTRAINT fk_products_supplier_id FOREIGN KEY (supplier_id) REFERENCES suppliers(id),
    CONSTRAINT fk_products_presentation_id FOREIGN KEY (presentation_id) REFERENCES presentations(id)
);

CREATE TABLE purchases (
    id INT AUTO_INCREMENT,
    product_code VARCHAR(50),
    purchase_date DATE,
    cost DECIMAL(10, 2),
    CONSTRAINT pk_purchases_id PRIMARY KEY (id),
    CONSTRAINT fk_purchases_products_product_id FOREIGN KEY (product_code) REFERENCES products(product_code)
);

DELIMITER //

DROP TRIGGER IF EXISTS calculate_age;

CREATE TRIGGER calculate_age
BEFORE INSERT ON customers
FOR EACH ROW
BEGIN
    DECLARE agec INT;
    DECLARE birthdatec DATE;

    SET birthdatec = NEW.birthdate;

    SET agec = TIMESTAMPDIFF(YEAR, birthdatec, CURDATE());

    SET NEW.age = agec;
END;

//

DELIMITER ;


DELIMITER //

DROP TRIGGER IF EXISTS calculate_sale_value;

CREATE TRIGGER calculate_sale_value
AFTER INSERT ON purchases
FOR EACH ROW
BEGIN
    DECLARE average_cost DECIMAL(10, 2);
    DECLARE profit_margin DECIMAL(5, 2);

    SET profit_margin = 0.25; 

    SELECT AVG(cost) INTO average_cost
    FROM purchases
    WHERE product_code = NEW.product_code;

    UPDATE products
    SET sale_value = average_cost * (1 + profit_margin)
    WHERE product_code = NEW.product_code;
END;
//

DELIMITER ;

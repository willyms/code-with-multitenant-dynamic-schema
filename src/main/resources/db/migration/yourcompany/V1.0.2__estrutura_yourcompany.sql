CREATE TABLE IF NOT EXISTS yourcompany.Car (
    id serial PRIMARY KEY,
    brand VARCHAR(200),
    name VARCHAR(200),
    model_year DATE,
    is_available_sale BOOLEAN DEFAULT TRUE,
    price bigint
);

INSERT INTO yourcompany.Car (id, name, brand, model_year, is_available_sale, price)
    VALUES(nextval('car_id_seq'), 'TRACKER TURBO','Chevrolet','2023-01-01', TRUE, 1000000);
CREATE TABLE IF NOT EXISTS mycompany.Car (
    id serial PRIMARY KEY,
    brand VARCHAR(200),
    name VARCHAR(200),
    model_year DATE,
    is_available_sale BOOLEAN DEFAULT TRUE,
    price bigint
);

INSERT INTO mycompany.Car (id, name, brand, model_year, is_available_sale, price)
    VALUES(nextval('car_id_seq'), '208','Peugeot','2018-05-20', TRUE, 10000),
          (nextval('car_id_seq'), 'Sandeiro','Renault','2017-05-20', TRUE, 10000),
          (nextval('car_id_seq'), 'Polo','Volkswagen','2017-05-20', TRUE, 10000),
          (nextval('car_id_seq'), 'Uno Way','Fiat','2018-05-20', TRUE, 10000),
          (nextval('car_id_seq'), 'Celta','Chevrolet','2018-05-20', FALSE, 10000);
CREATE TABLE IF NOT EXISTS Car (
    id serial PRIMARY KEY,
    brand VARCHAR(200),
    name VARCHAR(200),
    model_year DATE,
    is_available_sale BOOLEAN DEFAULT TRUE,
    price bigint
);
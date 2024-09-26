-- Si la tabla no existe, créala
CREATE TABLE IF NOT EXISTS TIPO_CAMBIO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    moneda_origen VARCHAR(3) NOT NULL,
    moneda_destino VARCHAR(3) NOT NULL,
    tipo_cambio DECIMAL(10, 4) NOT NULL
);

-- Inserta los valores
INSERT INTO TIPO_CAMBIO (moneda_origen, moneda_destino, tipo_cambio)
VALUES ('USD', 'EUR', 0.85);

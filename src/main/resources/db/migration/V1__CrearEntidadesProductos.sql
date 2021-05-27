CREATE TABLE unidad
(
    id          INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(20)
);

CREATE TABLE provision
(
    id              INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha_provision DATETIME         NOT NULL
);

CREATE TABLE producto
(
    id           INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(50)      NOT NULL,
    descripcion  VARCHAR(250)     NOT NULL,
    precio       DOUBLE           NOT NULL,
    stock_actual INTEGER          NOT NULL,
    stock_minimo INTEGER          NOT NULL,
    unidad_id    INTEGER UNSIGNED NOT NULL,
    CONSTRAINT fk_unidad_producto FOREIGN KEY (unidad_id) REFERENCES unidad (id)
);

CREATE TABLE provision_detalle
(
    id           INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cantidad     INTEGER          NOT NULL,
    producto_id  INTEGER UNSIGNED NOT NULL,
    provision_id INTEGER UNSIGNED NOT NULL,
    CONSTRAINT fk_provision_provision_detalle FOREIGN KEY (provision_id) REFERENCES provision (id),
    CONSTRAINT fk_producto_provision_detalle FOREIGN KEY (producto_id) REFERENCES producto (id)
);

CREATE TABLE movimientos_stock
(
    id                   INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cantidad_entrada     INTEGER          NOT NULL,
    cantidad_salida      INTEGER          NOT NULL,
    fecha                DATETIME         NOT NULL,
    producto_id          INTEGER UNSIGNED NOT NULL,
    provision_detalle_id INTEGER UNSIGNED,
    detalle_pedido_id    INTEGER UNSIGNED,
    CONSTRAINT fk_producto_movimientos_stock FOREIGN KEY (producto_id) REFERENCES producto (id),
    CONSTRAINT fk_provision_detalle_movimientos_stock FOREIGN KEY (provision_detalle_id) REFERENCES provision_detalle (id)
);

INSERT INTO unidad (descripcion)
VALUES ('Kg'),
       ('g'),
       ('l'),
       ('ml'),
       ('ton'),
       ('unidad')





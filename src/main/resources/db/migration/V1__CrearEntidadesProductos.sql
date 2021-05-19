CREATE TABLE unidad
(
    id   INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(10)
);

CREATE TABLE provision
(
    id                   INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fechaProvision       DATETIME         NOT NULL
);

CREATE TABLE provision_detalle
(
    id           INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cantidad     INTEGER          NOT NULL,
    provision_id INTEGER UNSIGNED NOT NULL,
    CONSTRAINT fk_provision_provision_detalle FOREIGN KEY (provision_id) REFERENCES provision (id)
);

CREATE TABLE material
(
    id           INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(20)      NOT NULL,
    descripcion  VARCHAR(50)      NOT NULL,
    precio       DOUBLE           NOT NULL,
    stock_actual INTEGER          NOT NULL,
    stock_minimo INTEGER          NOT NULL,
    unidad_id    INTEGER UNSIGNED NOT NULL,
    CONSTRAINT fk_unidad_material FOREIGN KEY (unidad_id) REFERENCES unidad (id)
);

CREATE TABLE movimientos_stock
(
    id                   INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cantidad_entrada     INTEGER          NOT NULL,
    cantidad_salida      INTEGER          NOT NULL,
    fecha                DATETIME         NOT NULL,
    material_id          INTEGER UNSIGNED NOT NULL,
    provision_detalle_id INTEGER UNSIGNED NOT NULL,
    detalle_pedido_id    INTEGER UNSIGNED NOT NULL,
    CONSTRAINT fk_material_movimientos_stock FOREIGN KEY (material_id) REFERENCES material (id),
    CONSTRAINT fk_provision_detalle_movimientos_stock FOREIGN KEY (provision_detalle_id) REFERENCES provision_detalle (id)
);





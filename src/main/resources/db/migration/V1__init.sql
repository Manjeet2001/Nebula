CREATE TABLE category
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE category_seq
(
    next_val BIGINT NULL
);

CREATE TABLE products
(
    id            BIGINT NOT NULL,
    `description` VARCHAR(255) NULL,
    price         BIGINT NULL,
    title         VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE products_seq
(
    next_val BIGINT NULL
);

ALTER TABLE products
    ADD CONSTRAINT FK1cf90etcu98x1e6n9aks3tel3 FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE NO ACTION;

CREATE INDEX FK1cf90etcu98x1e6n9aks3tel3 ON products (category_id);
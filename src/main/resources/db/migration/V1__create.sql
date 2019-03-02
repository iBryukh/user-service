DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS customer_device CASCADE;

CREATE TABLE role
(
  id           BIGINT       NOT NULL,
  name         VARCHAR(255) NOT NULL,
  access_level INTEGER      NOT NULL
    CONSTRAINT role_access_level_check
      CHECK ((access_level <= 3) AND (access_level >= 0)),
  PRIMARY KEY (id)
);

CREATE TABLE customer
(
  id           BIGINT       NOT NULL,
  email        VARCHAR(255) NOT NULL,
  name         VARCHAR(255) NOT NULL,
  password     VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255) NOT NULL,
  role_id      INT          NOT NULL,
  FOREIGN KEY (role_id) REFERENCES role (id),
  PRIMARY KEY (id)
);

CREATE TABLE customer_device
(
  customer_id BIGINT NOT NULL,
  device_id   BIGINT NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (customer_id, device_id)
);

ALTER TABLE role
  OWNER TO postgres;

ALTER TABLE customer
  OWNER TO postgres;

ALTER TABLE customer_device
  OWNER TO postgres;
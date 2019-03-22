DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS customer CASCADE;

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

ALTER TABLE role
  OWNER TO postgres;

ALTER TABLE customer
  OWNER TO postgres;
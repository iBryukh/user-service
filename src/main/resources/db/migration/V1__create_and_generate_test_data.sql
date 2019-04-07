DROP TABLE IF EXISTS customer_device CASCADE;

CREATE TABLE IF NOT EXISTS customer_device
(
  customer_id integer NOT NULL,
  device_id   integer NOT NULL,
  CONSTRAINT customer_device_pk PRIMARY KEY (customer_id, device_id)
);

ALTER TABLE customer_device
  OWNER TO postgres;
DROP TABLE IF EXISTS customer_device CASCADE;

CREATE TABLE IF NOT EXISTS customer_device
(
    customer_id integer NOT NULL,
    device_id   integer NOT NULL,
    CONSTRAINT customer_device_pk PRIMARY KEY (customer_id, device_id)
);

ALTER TABLE customer_device
    OWNER TO postgres;

-- GENERATE DATA

TRUNCATE TABLE customer_device CASCADE;

DO $$
    DECLARE
        freeCustomerId          BIGINT := 0;
        freeDeviceId            BIGINT := 0;
        currDevicesCount        INT    := 0;
        customersCount          INT    := 10;
        devicesPerCustomerCount INT    := 10;
        crossDevicesCount       INT    := 2;
    BEGIN
        WHILE freeCustomerId < customersCount
            LOOP
                if (freeDeviceId > crossDevicesCount) then
                    freeDeviceId = freeDeviceId - crossDevicesCount;
                end if;
                WHILE currDevicesCount < devicesPerCustomerCount
                    LOOP
                        INSERT INTO customer_device (customer_id, device_id) VALUES (freeCustomerId, freeDeviceId);
                        freeDeviceId = freeDeviceId + 1;
                        currDevicesCount = currDevicesCount + 1;
                    END LOOP;
                currDevicesCount = 0;
                freeCustomerId = freeCustomerId + 1;
            END LOOP;
        create sequence customer_device_id_seq start with 100; -- customers count * devicesPerCustomer count
    END $$;
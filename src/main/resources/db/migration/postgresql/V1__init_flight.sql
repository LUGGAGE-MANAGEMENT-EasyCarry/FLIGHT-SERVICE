CREATE TABLE flight
(
    id                 uuid                   NOT NULL,
    pnr_code           character varying(245) NOT NULL,
    flight_date        character varying(245) NOT NULL,
    departure_location character varying(255),
    phone_number       character varying(255),
    PRIMARY KEY (id)
);

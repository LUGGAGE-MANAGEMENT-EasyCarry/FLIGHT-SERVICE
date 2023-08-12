CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE flight(flight_id uuid NOT NULL DEFAULT uuid_generate_v4(),
                    pnr_code character varying(245) NOT NULL,
                    flight_date DATE NOT NULL,departure_location character varying(255),phone_number INT
    ,PRIMARY KEY (flight_id));

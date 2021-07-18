DROP TABLE customers cascade;
CREATE TABLE customers(
	cust_id serial PRIMARY KEY,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	add_id integer REFERENCES addresses(add_id) ON DELETE cascade,
	age integer NOT NULL,
	dob date NOT NULL
);
TRUNCATE TABLE customers;

DROP TABLE addresses cascade;
CREATE TABLE addresses(

	add_id serial PRIMARY KEY,
	line1 varchar NOT NULL,
	line2 varchar,
	state varchar NOT NULL,
	city varchar NOT NULL,
	zip varchar NOT NULL,
	country varchar NOT NULL
	
);

TRUNCATE TABLE addresses cascade;


DROP  TABLE policies cascade;
CREATE TABLE policies(
	
	pol_number serial PRIMARY KEY,
	pol_type varchar NOT NULL,
	state varchar NOT NULL,
	premium double PRECISION NOT NULL, 
	start_date date NOT NULL,
	end_date date NOT NULL,
	cust_id integer REFERENCES customers(cust_id) ON DELETE CASCADE

);

TRUNCATE TABLE policies cascade;


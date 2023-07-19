CREATE TABLE base_user (
	id int8 NOT NULL GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE),
	user_id varchar(40) NOT NULL,
	login_id varchar(100) NOT NULL,
	"password" varchar(255) NOT NULL,
	user_role varchar(100) NOT NULL,
	CONSTRAINT base_user_login_id_key UNIQUE (login_id),
	CONSTRAINT base_user_pkey PRIMARY KEY (id),
	CONSTRAINT base_user_user_id_key UNIQUE (user_id)
);


CREATE TABLE customer (
	id varchar(40) NOT NULL,
	"version" int8 NULL,
	customer_status varchar(30) NOT NULL,
	customer_group varchar(30) NOT NULL,
	customer_name varchar(255) NOT NULL,
	phone varchar(150) NULL,
	memo varchar(1000) NULL,
	email varchar(255) NULL,
	created_by varchar(40) NULL,
	created_at timestamp NULL,
	updated_by varchar(40) NULL,
	updated_at timestamp NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (id)
);


CREATE TABLE product_tb (
	id int8 NOT NULL GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE),
	"version" int8 NULL,
	product_name varchar(255) NOT NULL,
	stock int8 NOT NULL,
	description varchar(500) NULL,
	product_code varchar(255) NULL,
	product_status varchar(50) NULL,
	customer_id varchar(200) NULL,
	supply_company_id varchar(200) NULL,
	created_by varchar(40) NULL,
	created_at timestamp NULL,
	updated_by varchar(40) NULL,
	updated_at timestamp NULL,
	CONSTRAINT product_tb_pkey PRIMARY KEY (id)
);


CREATE TABLE user_tb (
	id uuid NOT NULL,
	login_id varchar(255) NULL,
	user_name varchar(255) NULL,
	user_status varchar(255) NULL,
	user_role varchar(255) NULL,
	email varchar(255) NULL,
	user_password varchar(255) NULL,
	phone varchar(255) NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	CONSTRAINT user_tb_pkey PRIMARY KEY (id)
);

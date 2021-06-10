
/*CREATE SEQUENCE public.customer_id_seq //счетчик покупателей
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.customer_id_seq
    OWNER TO postgres;



CREATE TABLE IF NOT EXISTS public.customer //таблица с покупателями
(
    userid integer NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
    username character varying(255) COLLATE pg_catalog."default" NOT NULL,
    secondname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (userid)
)

CREATE SEQUENCE public.roles_roleid_seq //счетчик ролей
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.roles_roleid_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.roles //таблица ролей
(
    roleid integer NOT NULL DEFAULT nextval('roles_roleid_seq'::regclass),
    rolename character(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (roleid)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.roles
    OWNER to postgres;

CREATE SEQUENCE public.customer_role_customerrole_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.customer_role_customerrole_id_seq
    OWNER TO postgres;
*/
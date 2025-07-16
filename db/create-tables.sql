-- public.accounts definition

-- Drop table

-- DROP TABLE public.accounts;

CREATE TABLE public.accounts
(
    id bigserial NOT NULL,
    email              varchar(255) NULL,
    expires_in         int4         NULL,
    "password"         varchar(255) NULL,
    "role"             varchar(255) NOT NULL,
    username           varchar(255) NULL,
    verification_token varchar(255) NULL,
    CONSTRAINT accounts_pkey PRIMARY KEY (id),
    CONSTRAINT accounts_role_check CHECK (((role):: text = ANY ((ARRAY['USER':: character varying, 'ADMIN':: character varying]):: text [])))
);
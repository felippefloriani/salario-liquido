CREATE TABLE public.funcionario
(
  id_funcionario serial,
  nm_funcionario character varying(30),
  vl_salario_bruto numeric(10,2),
  CONSTRAINT funcionario_pkey PRIMARY KEY (id_funcionario)
);


CREATE TABLE public.desconto
(
  id_desconto serial,
  id_funcionario int NOT NULL,
  vl_desconto numeric(10,2),
  CONSTRAINT desconto_pkey PRIMARY KEY (id_desconto),
  CONSTRAINT funcionario_fk FOREIGN KEY (id_funcionario)
      REFERENCES public.funcionario (id_funcionario)
)

INSERT INTO public.funcionario(nm_funcionario, vl_salario_bruto) VALUES ('Carlos Silva', 5000);
INSERT INTO public.desconto(id_funcionario, vl_desconto) VALUES(currval('funcionario_id_funcionario_seq'::regclass), 50);

INSERT INTO public.funcionario(nm_funcionario, vl_salario_bruto) VALUES ('Damião José', 6500);
INSERT INTO public.desconto(id_funcionario, vl_desconto) VALUES(currval('funcionario_id_funcionario_seq'::regclass), 150);
INSERT INTO public.desconto(id_funcionario, vl_desconto) VALUES(currval('funcionario_id_funcionario_seq'::regclass), 30);

INSERT INTO public.funcionario(nm_funcionario, vl_salario_bruto) VALUES ('Andrade Sousa', 4500);
INSERT INTO public.desconto(id_funcionario, vl_desconto) VALUES(currval('funcionario_id_funcionario_seq'::regclass), 50);
INSERT INTO public.desconto(id_funcionario, vl_desconto) VALUES(currval('funcionario_id_funcionario_seq'::regclass), 30);
INSERT INTO public.desconto(id_funcionario, vl_desconto) VALUES(currval('funcionario_id_funcionario_seq'::regclass), 20);
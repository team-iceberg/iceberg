CREATE TABLE users(
   ID serial PRIMARY KEY,
   NAME VARCHAR(25) NOT NULL,
   MAIL VARCHAR(25) NOT NULL
);

CREATE TABLE association(
   ID serial PRIMARY KEY,
   NAME VARCHAR(25) NOT NULL,
   MAIL VARCHAR(25) NOT NULL
);

CREATE TABLE coloris(
   ID serial PRIMARY KEY,
   LIBELLE VARCHAR(25) NOT NULL,
   CODE_HEXA VARCHAR(7) NOT NULL
);

INSERT INTO "iceberg".association(name, mail) values ('Association Test 1', 'associationTest1@mail.fr');
INSERT INTO "iceberg".association(name, mail) values ('Association Test 2', 'associationTest2@mail.fr');

INSERT INTO "iceberg".coloris(libelle,code_hexa) values ('BLANC', '#FFFFFF');
INSERT INTO "iceberg".coloris(libelle,code_hexa) values ('NOIR', '#000000');
INSERT INTO "iceberg".coloris(libelle,code_hexa) values ('ROUGE', '#00FF00');
INSERT INTO "iceberg".coloris(libelle,code_hexa) values ('BLEU', '#');
INSERT INTO "iceberg".coloris(libelle,code_hexa) values ('JAUNE', '#');
INSERT INTO "iceberg".coloris(libelle,code_hexa) values ('ORANGE', '#');
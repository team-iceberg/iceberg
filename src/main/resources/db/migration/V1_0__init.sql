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

CREATE TABLE color(
   ID serial PRIMARY KEY,
   LIBELLE VARCHAR(25) NOT NULL,
   CODE_HEXA VARCHAR(7) NOT NULL
);

INSERT INTO "iceberg".association(name, mail) values ('Association Test 1', 'associationTest1@mail.fr');
INSERT INTO "iceberg".association(name, mail) values ('Association Test 2', 'associationTest2@mail.fr');

INSERT INTO "iceberg".color(libelle,code_hexa) values ('BLANC', '#FFFFFF');
INSERT INTO "iceberg".color(libelle,code_hexa) values ('NOIR', '#000000');
INSERT INTO "iceberg".color(libelle,code_hexa) values ('ROUGE', '#00FF00');
INSERT INTO "iceberg".color(libelle,code_hexa) values ('BLEU', '#0000FF');
INSERT INTO "iceberg".color(libelle,code_hexa) values ('JAUNE', '#F7FF3C');
INSERT INTO "iceberg".color(libelle,code_hexa) values ('ORANGE', '#FFA500');
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


INSERT INTO "iceberg".association(name, mail) values ('Association Test 1', 'associationTest1@mail.fr');
INSERT INTO "iceberg".association(name, mail) values ('Association Test 2', 'associationTest2@mail.fr');
CREATE TABLE users(
   ID serial PRIMARY KEY,
   NAME VARCHAR(25) NOT NULL,
   MAIL VARCHAR(25) NOT NULL
);


INSERT INTO "iceberg".users(name, mail) values ('Association Test 1', 'associationTest1@mail.fr');
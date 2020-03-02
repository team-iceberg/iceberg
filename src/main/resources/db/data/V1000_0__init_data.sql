INSERT INTO "iceberg".association(name, mail) values ('Association Test 1', 'associationTest1@mail.fr');
INSERT INTO "iceberg".association(name, mail) values ('Association Test 2', 'associationTest2@mail.fr');
INSERT INTO "iceberg".association(name, mail) values ('Association Test 3', 'associationTest3@mail.fr');

INSERT INTO "iceberg".users (MAIL, IS_ROOT) VALUES ('eyovellimac@gmail.com', false);

INSERT INTO "iceberg".user_role (ID_USER, ID_ASSOCIATION, IS_ADMIN, IS_MEMBER, IS_VISITOR) VALUES ((SELECT ID FROM "iceberg".users WHERE mail='eyovellimac@gmail.com'), 1, true, false, false);
INSERT INTO "iceberg".user_role (ID_USER, ID_ASSOCIATION, IS_ADMIN, IS_MEMBER, IS_VISITOR) VALUES ((SELECT ID FROM "iceberg".users WHERE mail='eyovellimac@gmail.com'), 2, false, true, false);
INSERT INTO "iceberg".user_role (ID_USER, ID_ASSOCIATION, IS_ADMIN, IS_MEMBER, IS_VISITOR) VALUES ((SELECT ID FROM "iceberg".users WHERE mail='eyovellimac@gmail.com'), 3, false, false, true);
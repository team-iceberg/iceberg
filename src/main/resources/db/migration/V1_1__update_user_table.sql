ALTER TABLE "iceberg".users ADD CONSTRAINT USERS_UNIQUE UNIQUE (MAIL);
ALTER TABLE "iceberg".users ADD COLUMN IS_ROOT BOOLEAN DEFAULT FALSE;
ALTER TABLE "iceberg".users DROP COLUMN NAME;

INSERT INTO "iceberg".users (MAIL, IS_ROOT) VALUES ('camille.levoye@gmail.com', true);
INSERT INTO "iceberg".users (MAIL, IS_ROOT) VALUES ('ludovicaernout@gmail.com', true);
INSERT INTO "iceberg".users (MAIL, IS_ROOT) VALUES ('elodiedelbecque@gmail.com', true);

CREATE TABLE user_role(
   ID serial PRIMARY KEY,
   ID_USER INTEGER REFERENCES "iceberg".users (ID),
   ID_ASSOCIATION INTEGER REFERENCES "iceberg".association (ID),
   IS_ADMIN BOOLEAN DEFAULT FALSE,
   IS_MEMBER BOOLEAN DEFAULT FALSE,
   IS_VISITOR BOOLEAN DEFAULT FALSE,
   UNIQUE (ID_USER, ID_ASSOCIATION)
);
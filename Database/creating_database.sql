CREATE TABLE register (
   ID NUMBER(10),
   user_name VARCHAR2(50) NOT NULL,
   email VARCHAR2(100) UNIQUE NOT NULL,
   password VARCHAR2(100) NOT NULL,
   phone_number VARCHAR2(20) NOT NULL
);

ALTER TABLE register ADD (
  CONSTRAINT dept_pk PRIMARY KEY (ID));

CREATE SEQUENCE dept_seq START WITH 1;

CREATE OR REPLACE TRIGGER register_before_insert
BEFORE INSERT ON register
FOR EACH ROW
BEGIN
  IF :NEW.ID IS NULL THEN
    SELECT dept_seq.NEXTVAL INTO :NEW.ID FROM dual;
  END IF;
END;
/
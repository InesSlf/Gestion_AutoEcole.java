CREATE TABLE register (
   ID NUMBER(10),
   user_name VARCHAR2(50) NOT NULL,
   email VARCHAR2(100) UNIQUE NOT NULL,
   password VARCHAR2(100) NOT NULL,
   phone_number VARCHAR2(20) NOT NULL
);
create TABLE condidate(
  ID_C NUMBER(10) PRIMARY KEY,
  name VARCHAR2(50) NOT NULL,
  first_name VARCHAR2(50) NOT NULL,
  date_of_birth date NOT NULL,
  age NUMBER check (age>=18),
  phone VARCHAR2(10) unique,
  gender VARCHAR2(10),
  blood_type VARCHAR2(5),
  adress VARCHAR2(100),
  identity_card_number VARCHAR2(20) UNIQUE
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

CREATE SEQUENCE ID_C_seq START WITH 1;

create or REPLACE TRIGGER condidate_before_insert
BEFORE INSERT ON condidate 
FOR EACH ROW 
BEGIN
IF :NEW.ID_C IS NULL THEN 
   SELECT ID_C_seq.NEXTVAL INTO :NEW.ID_C FROM dual;
END IF;
END;
/

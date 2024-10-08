-- Create the register table
CREATE TABLE register (
   ID NUMBER(10),
   user_name VARCHAR2(50) NOT NULL,
   email VARCHAR2(100) UNIQUE NOT NULL,
   password VARCHAR2(100) NOT NULL,
   phone_number VARCHAR2(20) NOT NULL
);

-- Create the condidate table
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

-- Create the sessionP table
create TABLE sessionP (
  session_ID VARCHAR2(20) PRIMARY KEY,
  condidate_full_name VARCHAR2(50),
  identity_card_number VARCHAR2(20),
  session_date date NOT NULL,
  hour NUMBER NOT NULL,
  session_type VARCHAR2(10) check (session_type IN ('Code', 'Driving', 'Parking')),
  CONSTRAINT fk_identity_card FOREIGN KEY (identity_card_number)
    REFERENCES condidate(identity_card_number)
);

-- Create the payment table
create TABLE payment (
  payment_ID VARCHAR2(20) PRIMARY KEY,
  identity_card_number VARCHAR2(20) NOT NULL,
  amount VARCHAR2(20) NOT NULL,
  installment_amount VARCHAR2(20),
  remaining_balance VARCHAR2 (20),
  number_installments NUMBER(3),
  payment_date date NOT NULL,
   CONSTRAINT fk_identity_card_payment FOREIGN KEY (identity_card_number)
    REFERENCES condidate(identity_card_number)
);

-- Create the exams table
CREATE TABLE exams (
  exam_ID NUMBER(10) PRIMARY KEY,
  identity_card_number VARCHAR2(20) NOT NULL,
  full_name VARCHAR2(100) NOT NULL,
  exam_type VARCHAR2(10) ,
  exam_date DATE NOT NULL,
  CONSTRAINT fk_identity_card_exams FOREIGN KEY (identity_card_number)
    REFERENCES condidate(identity_card_number)
);

ALTER TABLE register ADD (
  CONSTRAINT dept_pk PRIMARY KEY (ID));

/*CREATE SEQUENCE dept_seq START WITH 1;

CREATE OR REPLACE TRIGGER register_before_insert
BEFORE INSERT ON register
FOR EACH ROW
BEGIN
  IF :NEW.ID IS NULL THEN
    SELECT dept_seq.NEXTVAL INTO :NEW.ID FROM dual;
  END IF;
END;
/
*/

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

CREATE SEQUENCE ID_S_seq START WITH 1;

create or REPLACE TRIGGER sessionP_before_insert
BEFORE INSERT ON sessionP
FOR EACH ROW 
BEGIN
IF :NEW.session_ID IS NULL THEN 
   SELECT ID_s_seq.NEXTVAL INTO :NEW.session_ID FROM dual;
END IF;
END;
/

CREATE SEQUENCE payment_seq START WITH 1;

create or REPLACE TRIGGER payment_befor_insert 
BEFORE INSERT ON payment 
FOR EACH ROW 
BEGIN
IF :NEW.payment_ID IS NULL THEN
    SELECT payment_seq.NEXTVAL INTO :NEW.payment_ID FROM dual;
END IF;
END;
/


CREATE SEQUENCE exam_seq START WITH 1;

CREATE OR REPLACE TRIGGER exams_before_insert
BEFORE INSERT ON exams
FOR EACH ROW
BEGIN
  IF :NEW.exam_ID IS NULL THEN
    SELECT exam_seq.NEXTVAL INTO :NEW.exam_ID FROM dual;
  END IF;
END;
/


CREATE SEQUENCE register_seq START WITH 1;

CREATE OR REPLACE TRIGGER register_before_insert
BEFORE INSERT ON register
FOR EACH ROW
BEGIN
  IF :NEW.ID IS NULL THEN
    SELECT register_seq.NEXTVAL INTO :NEW.ID FROM dual;
  END IF;
END;
/


-- Ajout la colonne user_name à la table condidate
ALTER TABLE condidate ADD user_name VARCHAR2(50);

-- Ajout la colonne user_name à la table sessionP
ALTER TABLE sessionP ADD user_name VARCHAR2(50);

-- Ajout la colonne user_name à la table payment
ALTER TABLE payment ADD user_name VARCHAR2(50);

ALTER TABLE exams ADD user_name VARCHAR2(50);

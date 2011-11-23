DROP TABLE "KONTO" cascade constraints;
  DROP TABLE "RODZAJKONTA" cascade constraints;
  DROP SEQUENCE "KONTO_SEQ";
  DROP SEQUENCE "RODZAJKONTA_SEQ";
--------------------------------------------------------
--  DDL for Sequence KONTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "KONTO_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence RODZAJKONTA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "RODZAJKONTA_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 ORDER  NOCYCLE ;



--------------------------------------------------------
--  DDL for Table RODZAJKONTA
--------------------------------------------------------

CREATE TABLE "RODZAJKONTA"
  (
    "IDRODZAJUKONTA" VARCHAR2(20 BYTE) NOT NULL ENABLE,
    "OPROCENTOWANIE" VARCHAR2(5 BYTE) NOT NULL ENABLE,
    "KAPITALIZACJA" VARCHAR2(5 BYTE) NOT NULL ENABLE,
    "NAZWA"  VARCHAR2(60 BYTE) NOT NULL ENABLE,
    "WALUTA" VARCHAR2(4 BYTE) NOT NULL ENABLE
  );

--------------------------------------------------------
--  DDL for Table KONTO
--------------------------------------------------------

CREATE TABLE "KONTO"
  (
    "SRODKI" VARCHAR2(30 BYTE) NOT NULL ENABLE,
    "NRKONTA"        VARCHAR2(40 BYTE) NOT NULL ENABLE,
    "IDRODZAJUKONTA" VARCHAR2(20 BYTE) NOT NULL ENABLE,
    "PESEL"	VARCHAR2(11 BYTE) NOT NULL ENABLE
  );

--------------------------------------------------------
--  Constraints for Table KONTO
--------------------------------------------------------

  ALTER TABLE "KONTO" ADD CONSTRAINT "NRKONTA_PK" PRIMARY KEY ("NRKONTA") ENABLE;
 
--------------------------------------------------------
--  Constraints for Table RODZAJKONTA
--------------------------------------------------------

  ALTER TABLE "RODZAJKONTA" ADD CONSTRAINT "IDRODZAJUKONTA_PK" PRIMARY KEY ("IDRODZAJUKONTA") ENABLE;


ALTER TABLE "KONTO" ADD CONSTRAINT "IDRODZAJUKONTA_FK" 
      FOREIGN KEY ("IDRODZAJUKONTA") 
      REFERENCES "RODZAJKONTA"("IDRODZAJUKONTA");

--------------------------------------------------------
--  DDL for Trigger KONTO_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "KONTO_TRG" BEFORE
  INSERT ON KONTO FOR EACH ROW BEGIN <<COLUMN_SEQUENCES>> BEGIN IF :NEW.NRKONTA IS NULL THEN
  SELECT KONTO_SEQ.NEXTVAL INTO :NEW.NRKONTA FROM DUAL;
END IF;
END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "KONTO_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RODZAJKONTA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "RODZAJKONTA_TRG" BEFORE
  INSERT ON RODZAJKONTA FOR EACH ROW BEGIN <<COLUMN_SEQUENCES>> BEGIN IF :NEW.IDRODZAJUKONTA IS NULL THEN
  SELECT RODZAJKONTA_SEQ.NEXTVAL INTO :NEW.IDRODZAJUKONTA FROM DUAL;
END IF;
END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "RODZAJKONTA_TRG" ENABLE;
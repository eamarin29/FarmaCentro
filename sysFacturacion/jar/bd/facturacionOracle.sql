--------------------------------------------------------
-- Archivo creado  - mi�rcoles-junio-28-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "FACTURACION"."CLIENTE" 
   (	"CODCLIENTE" VARCHAR2(50 CHAR), 
	"NOMBRES" VARCHAR2(50 CHAR), 
	"APELLIDOS" VARCHAR2(50 CHAR), 
	"DIRECCION" VARCHAR2(50 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table DETALLE_FACTURA
--------------------------------------------------------

  CREATE TABLE "FACTURACION"."DETALLE_FACTURA" 
   (	"CODDETALLE" NUMBER, 
	"CODFACTURA" NUMBER, 
	"CODPRODUCTO" VARCHAR2(50 CHAR), 
	"CANTIDAD" NUMBER, 
	"TOTAL_DETALLE" NUMBER(10,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FACTURA
--------------------------------------------------------

  CREATE TABLE "FACTURACION"."FACTURA" 
   (	"CODFACTURA" NUMBER(*,0), 
	"CODCLIENTE" VARCHAR2(50 CHAR), 
	"CODVENDEDOR" VARCHAR2(50 CHAR), 
	"TOTAL_VENTA" NUMBER(10,2), 
	"FECHA_REGISTRO" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRODUCTO
--------------------------------------------------------

  CREATE TABLE "FACTURACION"."PRODUCTO" 
   (	"CODBARRAS" VARCHAR2(50 CHAR), 
	"NOMBRE_PRODUCTO" VARCHAR2(50 CHAR), 
	"PRECIO_VENTA" NUMBER(10,2), 
	"STOCK_MINIMO" NUMBER(*,0), 
	"STOCK_ACTUAL" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPO
--------------------------------------------------------

  CREATE TABLE "FACTURACION"."TIPO" 
   (	"CODTIPO" NUMBER(*,0), 
	"DESCRIPCION" VARCHAR2(50 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "FACTURACION"."USUARIO" 
   (	"CEDULA" VARCHAR2(50 CHAR), 
	"PASSWORD" VARCHAR2(250 CHAR), 
	"EMAIL" VARCHAR2(50 CHAR), 
	"VALIDADO" CHAR(1 CHAR), 
	"CODREGISTRO" VARCHAR2(250 CHAR), 
	"TIPO" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table VENDEDOR
--------------------------------------------------------

  CREATE TABLE "FACTURACION"."VENDEDOR" 
   (	"CEDULA" VARCHAR2(50 CHAR), 
	"NOMBRES" VARCHAR2(50 CHAR), 
	"APELLIDOS" VARCHAR2(50 CHAR), 
	"DUI" VARCHAR2(50 CHAR), 
	"CELULAR" VARCHAR2(50 CHAR), 
	"DIRECCION" VARCHAR2(50 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence DETALLE_FACTURA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "FACTURACION"."DETALLE_FACTURA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence FACTURA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "FACTURACION"."FACTURA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TIPO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "FACTURACION"."TIPO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Index CLIENTE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURACION"."CLIENTE_PK" ON "FACTURACION"."CLIENTE" ("CODCLIENTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index DETALLE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURACION"."DETALLE_PK" ON "FACTURACION"."DETALLE_FACTURA" ("CODDETALLE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index FACTURA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURACION"."FACTURA_PK" ON "FACTURACION"."FACTURA" ("CODFACTURA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PRODUCTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURACION"."PRODUCTO_PK" ON "FACTURACION"."PRODUCTO" ("CODBARRAS") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TIPO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURACION"."TIPO_PK" ON "FACTURACION"."TIPO" ("CODTIPO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USUARIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURACION"."USUARIO_PK" ON "FACTURACION"."USUARIO" ("CEDULA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index VENDEDOR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FACTURACION"."VENDEDOR_PK" ON "FACTURACION"."VENDEDOR" ("CEDULA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger DETALLE_FACTURA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "FACTURACION"."DETALLE_FACTURA_TRG" 
BEFORE INSERT ON DETALLE_FACTURA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.CODDETALLE IS NULL THEN
      SELECT DETALLE_FACTURA_SEQ.NEXTVAL INTO :NEW.CODDETALLE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "FACTURACION"."DETALLE_FACTURA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger FACTURA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "FACTURACION"."FACTURA_TRG" 
BEFORE INSERT ON FACTURA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.CODFACTURA IS NULL THEN
      SELECT FACTURA_SEQ.NEXTVAL INTO :NEW.CODFACTURA FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "FACTURACION"."FACTURA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TIPO_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "FACTURACION"."TIPO_TRG" 
BEFORE INSERT ON TIPO 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.CODTIPO IS NULL THEN
      SELECT TIPO_SEQ.NEXTVAL INTO :NEW.CODTIPO FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "FACTURACION"."TIPO_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "FACTURACION"."CLIENTE" ADD CONSTRAINT "CLIENTE_PK" PRIMARY KEY ("CODCLIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURACION"."CLIENTE" MODIFY ("CODCLIENTE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DETALLE_FACTURA
--------------------------------------------------------

  ALTER TABLE "FACTURACION"."DETALLE_FACTURA" ADD CONSTRAINT "DETALLE_PK" PRIMARY KEY ("CODDETALLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURACION"."DETALLE_FACTURA" MODIFY ("CODDETALLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FACTURA
--------------------------------------------------------

  ALTER TABLE "FACTURACION"."FACTURA" MODIFY ("CODVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "FACTURACION"."FACTURA" MODIFY ("FECHA_REGISTRO" NOT NULL ENABLE);
  ALTER TABLE "FACTURACION"."FACTURA" MODIFY ("TOTAL_VENTA" NOT NULL ENABLE);
  ALTER TABLE "FACTURACION"."FACTURA" ADD CONSTRAINT "FACTURA_PK" PRIMARY KEY ("CODFACTURA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURACION"."FACTURA" MODIFY ("CODCLIENTE" NOT NULL ENABLE);
  ALTER TABLE "FACTURACION"."FACTURA" MODIFY ("CODFACTURA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "FACTURACION"."PRODUCTO" ADD CONSTRAINT "PRODUCTO_PK" PRIMARY KEY ("CODBARRAS")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURACION"."PRODUCTO" MODIFY ("CODBARRAS" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPO
--------------------------------------------------------

  ALTER TABLE "FACTURACION"."TIPO" ADD CONSTRAINT "TIPO_PK" PRIMARY KEY ("CODTIPO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURACION"."TIPO" MODIFY ("CODTIPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "FACTURACION"."USUARIO" ADD CONSTRAINT "USUARIO_PK" PRIMARY KEY ("CEDULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURACION"."USUARIO" MODIFY ("CEDULA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table VENDEDOR
--------------------------------------------------------

  ALTER TABLE "FACTURACION"."VENDEDOR" MODIFY ("CELULAR" NOT NULL ENABLE);
  ALTER TABLE "FACTURACION"."VENDEDOR" ADD CONSTRAINT "VENDEDOR_PK" PRIMARY KEY ("CEDULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FACTURACION"."VENDEDOR" MODIFY ("CEDULA" NOT NULL ENABLE);

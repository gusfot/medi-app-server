CREATE USER MEDI
  IDENTIFIED BY <password>
  DEFAULT TABLESPACE MEDI
  TEMPORARY TABLESPACE TEMP
  PROFILE DEFAULT
  ACCOUNT UNLOCK;

GRANT DBA TO MEDI;
  
CREATE TABLESPACE MEDI DATAFILE 
  '/u01/app/oracle/oradata/XE/medi.dbf' SIZE 1000M AUTOEXTEND ON NEXT 800M MAXSIZE 2000M
LOGGING
ONLINE
EXTENT MANAGEMENT LOCAL AUTOALLOCATE
BLOCKSIZE 8K
SEGMENT SPACE MANAGEMENT AUTO
FLASHBACK ON;

CREATE TABLE HS_LABB42
(
  ID          NUMBER,
  JUBSJUBNO   VARCHAR2(10 BYTE),
  SDATE       NVARCHAR2(8),
  NO          NUMBER,
  CODE        VARCHAR2(10 BYTE),
  KNAME       VARCHAR2(50 BYTE),
  ENAME       VARCHAR2(50 BYTE),
  SNAME       VARCHAR2(50 BYTE),
  VALUE       VARCHAR2(50 BYTE),
  MEMO        VARCHAR2(4000 BYTE),
  DECISION    VARCHAR2(1 BYTE),
  STYLE       VARCHAR2(1 BYTE),
  LOW_MAN     VARCHAR2(100 BYTE),
  HIGH_MAN    VARCHAR2(100 BYTE),
  LOW_WOMAN   VARCHAR2(100 BYTE),
  HIGH_WOMAN  VARCHAR2(100 BYTE),
  REFCHAR     VARCHAR2(100 BYTE),
  DAT_INSERT  DATE,
  COD_INSERT  CHAR(6 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
RESULT_CACHE (MODE DEFAULT)
NOPARALLEL
MONITORING;


CREATE TABLE MEMBER
(
  MEMBER_SEQ        INTEGER,
  ID                VARCHAR2(20 BYTE),
  PASSWD            VARCHAR2(50 BYTE),
  EMAIL             VARCHAR2(50 BYTE),
  BIRTHDAY          VARCHAR2(10 BYTE),
  BIRTHDAY_SOLAR    CHAR(1 BYTE)                DEFAULT 'Y',
  IS_AUTHENTICATED  CHAR(1 BYTE)                DEFAULT 'N',
  IS_DELETED        CHAR(1 BYTE)                DEFAULT 'N',
  MOD_DATE          TIMESTAMP(6)                DEFAULT SYSDATE,
  REG_DATE          TIMESTAMP(6)                DEFAULT SYSDATE,
  NAME              VARCHAR2(20 BYTE),
  CELL_PHONE        VARCHAR2(20 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
RESULT_CACHE (MODE DEFAULT)
NOPARALLEL
MONITORING;

CREATE SEQUENCE MEMBER_SEQ
  START WITH 1
  MAXVALUE 9999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;

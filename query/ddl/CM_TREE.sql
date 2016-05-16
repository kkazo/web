CREATE TABLE PUBLIC.CM_TREE
(
	UUID     UUID AUTO_INCREMENT PRIMARY KEY NOT NULL,
	ID       NVARCHAR2                       NOT NULL,
	NAME     VARCHAR2(200)                   NOT NULL,
	CODE     VARCHAR2(20)                    NOT NULL,
	VALUE1   VARCHAR2(500),
	VALUE2   VARCHAR(500),
	VALUE3   VARCHAR(500),
	VALUE4   VARCHAR(500),
	VALUE5   VARCHAR(500),
	USE_YN   CHAR(1) DEFAULT 'Y'             NOT NULL,
	DEL_YN   CHAR(1)                         NOT NULL,
	REG_ID   VARCHAR(20)                     NOT NULL,
	REG_DATE DATETIME DEFAULT SYSDATE()      NOT NULL
);
ALTER TABLE PUBLIC.CM_TREE ADD CONSTRAINT UNQ_ID UNIQUE (ID);
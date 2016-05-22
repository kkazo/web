CREATE TABLE CM_PROGRAM
(
	PARN_CD	VARCHAR(200),
	CD	VARCHAR(200) PRIMARY	KEY,
	NM	VARCHAR(400),
	REMARK	CLOB,
	ORD	INTEGER,
	USE_YN	CHAR(1)	DEFAULT	'Y',
	DEL_YN	CHAR(1)	DEFAULT	'N',
	REG_ID	VARCHAR(20),
	REG_DATE	DATE	DEFAULT	SYSDATE NOT NULL,
	MOD_ID	VARCHAR(20),
	MOD_DATE	DATE
);

CREATE TABLE CM_CD
(
	PARN_CD	VARCHAR(20),
	CD	VARCHAR(20) PRIMARY	KEY,
	NM	VARCHAR(400),
	VAL	VARCHAR(400),
	ORD	INTEGER,
	USE_YN	CHAR(1)	DEFAULT	'Y',
	DEL_YN	CHAR(1)	DEFAULT	'N',
	REG_ID	VARCHAR(20),
	REG_DATE	DATE	DEFAULT	SYSDATE NOT NULL,
	MOD_ID	VARCHAR(20),
	MOD_DATE	DATE
);

CREATE TABLE CM_BRD
(
	SEQ	BIGINT	DEFAULT	1	PRIMARY	KEY,
	BRD_ID	VARCHAR(20)	DEFAULT	'DEFALT'	NOT NULL,
	SUBJECT	VARCHAR(400)	NOT NULL,
	CONTENT	CLOB,
	HIT	BIGINT	DEFAULT	0	NOT NULL,
	REG_DATE	DATE	DEFAULT	SYSDATE	NOT NULL,
	REG_ID	VARCHAR(20)	NOT NULL,
	MOD_DATE	DATE,
	MOD_ID	VARCHAR(20),
	USE_YN	CHAR(1)	DEFAULT	'Y' NOT NULL,
	DEL_YN	CHAR(1)	DEFAULT	'N' NOT NULL
);

CREATE TABLE CM_SEQUENCE
(
	SEQ	VARCHAR2(36)	DEFAULT	RANDOM_UUID ()	PRIMARY	KEY,
	KEY	VARCHAR2(200)	NOT NULL,
	NEXT_VAL	NUMBER(20)	DEFAULT	1 NOT NULL,
	CURR_VAL	NUMBER(20)	DEFAULT	0 NOT NULL
);

/** CM_SEQUENCE 데이터 초기화 */
INSERT INTO CM_SEQUENCE (KEY) VALUES ('template.basic');

/** CM_CD 데이터 초기화 */
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('#', 'CODE', '코드관리', '', 1);
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('CODE', 'COMMON', '공통', '', 1);
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('CODE', 'COFFEE', '커피', '', 3);
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('CODE', 'RICE', '밥', '', 2);
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('COFFEE', 'COFFEE_0001', '아메리카노', 'AMERICANO', 1);
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('RICE', 'RICE_01', '제육복음', '', 1);
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('COFFEE', 'COFFEE_0002', '라떼', 'LATTE', 2);
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('RICE', 'RICE_02', '자장면', '', 2);
INSERT INTO CM_CD (PARN_CD, CD, NM, VAL, ORD) VALUES ('RICE', 'RICE_03', '김치찌개', '', 3);

/** CM_PROGRAM 데이터 초기화 */
INSERT INTO CM_PROGRAM (PARN_CD, CD, NM, REMARK, ORD, REG_ID) VALUES ('#', 'com.sample', 'Project Default Package', '', 1, 'ky.cho');
INSERT INTO CM_PROGRAM (PARN_CD, CD, NM, REMARK, ORD, REG_ID) VALUES ('com.sample', 'com.sample.admin', 'Admin Default Package', '', 1, 'ky.cho');
INSERT INTO CM_PROGRAM (PARN_CD, CD, NM, REMARK, ORD, REG_ID) VALUES ('com.sample.admin', 'com.sample.admin.cache', '캐시관리 프로그램', '', 1, 'ky.cho');
INSERT INTO CM_PROGRAM (PARN_CD, CD, NM, REMARK, ORD, REG_ID) VALUES ('com.sample.admin', 'com.sample.admin.code', '코드관리 프로그램', '', 1, 'ky.cho');
INSERT INTO CM_PROGRAM (PARN_CD, CD, NM, REMARK, ORD, REG_ID) VALUES ('com.sample.admin', 'com.sample.admin.generator', '소스 생성 프로그램', '', 1, 'ky.cho');
INSERT INTO CM_PROGRAM (PARN_CD, CD, NM, REMARK, ORD, REG_ID) VALUES ('com.sample.admin', 'com.sample.admin.guide', '가이드 프로그램', '', 1, 'ky.cho');
INSERT INTO CM_PROGRAM (PARN_CD, CD, NM, REMARK, ORD, REG_ID) VALUES ('com.sample.admin', 'com.sample.admin.template', '템플릿 프로그램', '', 1, 'ky.cho');

INSERT INTO CM_PROGRAM (PARN_CD, CD, NM, REMARK, ORD, REG_ID) VALUES ('com.sample', 'com.sample.web', 'Web Default Package', '', 2, 'ky.cho');




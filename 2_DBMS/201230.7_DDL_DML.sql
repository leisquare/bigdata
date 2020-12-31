-- [VII] DDL, DML, DCL
--SQL = DDL(테이블 생성, 삭제, 구조변경, 테이블 데이터 제거)
--    + DML(SELECT, INSERT,UPDATE, DELETE)
--    + DCL(사용자 계정생성, 사용자에게 원한 부여, 권한 박탈, 트랜젝션 명령어)

--★ DDL ★ --롤백 불가능. 
--1. 테이블 생성 (CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4), --도서번호
    BOOKNAME VARCHAR2(20), --도서이름
    PUBLISHER VARCHAR2(20), --출판사
    RDATE DATE, ---출판일자
    PRICE NUMBER(8), --가격
    PRIMARY KEY(BOOKID) --테이블 내 주키(PRIMARY KEY) = 유일, NOT NULL
);

DROP TABLE BOOK;
CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY,
    BOOKNAME VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE DATE,
    PRICE NUMBER(8)
);

SELECT * FROM BOOK;
-- EMP와 유사한 EMP01- EMPNO(숫자4), ENAME(문자-20), SAL(숫자 7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2)
);

--DEPT01 -DEPTNO(숫자2), DNAME(문자14), LOC(문자13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13)
);
DROP TABLE DEPT01;

--서브쿼리를 이용한 테이블 생성.
CREATE TABLE EMP02
    AS
    SELECT * FROM EMP; 
--EMP02: 서브쿼리 결과만 (제약조건은 미포함)
SELECT * FROM EMP02;
INSERT INTO EMP02(EMPNO, ENAME, DEPTNO) VALUES (7369, 'HONG', 90);

--EMP03: EMP테이블에서 EMPNO, ENAME, DEPTNO만 추출
DROP TABLE EMP03;
CREATE TABLE EMP03
    AS
    SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP03;

--EMP04: EMP테이블에서 10번 부서만 추출
CREATE TABLE EMP04
    AS
    SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP04;

--EMP05: EMP테이블의 구조만 추출
CREATE TABLE EMP05
    AS
    SELECT * FROM EMP WHERE 1=0; --참인 조건만 가져오는 것이므로 무조건 거짓인 조건을 넣어준다.

SELECT * FROM EMP05;

--2 테이블 구조 변경 (ALTER TABLE)
--(1) 필드 추가 (ADD)
SELECT * FROM EMP03;
ALTER TABLE EMP03 ADD (JOB VARCHAR2(10),SAL NUMBER(7,2));
SELECT * FROM EMP03;
ALTER TABLE EMP03 ADD (MGR NUMBER(4));

--(2) 필드 타입 수정(MODIFY)
ALTER TABLE EMP03 MODIFY(EMPNO VARCHAR2(5)); --숫자 데이터가 들어있는 상태
ALTER TABLE EMP03 MODIFY(JOB VARCHAR2(20));--NULL이면 다 바꿈
ALTER TABLE EMP03 MODIFY(ENAME VARCHAR2(200));
ALTER TABLE EMP03 MODIFY(ENAME VARCHAR2(5)); --BYTE 자료 있어 불가

--(3) 필드 삭제(DROP)
SELECT * FROM EMP03;
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;
ALTER TABLE EMP03 DROP COLUMN DEPTNO; --데이터 복구 불가
-- 논리적으로 특정필드를 접근 못하도록 (낮)
ALTER TABLE EMP03 SET UNUSED(SAL);
-- 논리적으로 접근 불가했던 필드를 삭제(새벽)
ALTER TABLE EMP03 DROP UNUSED COLUMNS; --물리적 삭제시 테이블 엑세스 불가.
--ALTER TABLE 테이블명
--ADD || MODIFY || DROP~

--3. 테이블 삭제(DROP TABLE)
DROP TABLE EMP01;
SELECT * FROM EMP01;

DROP TABLE DEPT; --이 테이블을 참조하는 게 있으면 바로 삭제할 수 없다. 지우려면 CASCADE를 써야함
    
    
--4. 테이블 내에 데이터 싹 다 제거(TRUNCATE TABLE)
SELECT * FROM EMP02;
TRUNCATE TABLE EMP02; --롤백 불가
ROLLBACK;

--5. 테이블 이름 변경(RENAME)
SELECT * FROM EMP03;
RENAME EMP03 TO EMP3;

-- 6. 데이터 딕셔너리(접근불가) -> 데이터 딕셔너리 뷰(사용자 접근용)
    --DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS;
    --USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS;
    -- ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS;
--USER_XXX; SCOTT이 소유한 객체 정보 조회용.
SELECT * FROM USER_TABLES;
SELECT * FROM USER_INDEXES;
SELECT TABLE_NAME FROM USER_TABLES;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_VIEWS;
CREATE TABLE BOOK(
    BOOKID NUMBER(4)CONSTRAINT BP PRIMARY KEY,
    BOOKNAME VARCHAR2(100),
    PUBLISHER VARCHAR2(100),
    RDATE DATE,
    PRICE NUMBER(8)
    );
    
--DBA_XXX ; DBA 권한을 가진 사용자만 접근 가능한 객체 정보
SELECT TABLE_NAME, OWNER FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;
--ALL_XXX : SCOTT이 소유한 객체나 권한이 부여된 객체
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_VIEWS;

--★ DML ★
--7. DML : SELECT, INSERT, UPDATE, DELETE
--(1) INSERT INTO 테이블이름(필드명1, 필드명2, ..)
--                VALUES(값1, 값2, ...);
--    INSERT INTO 테이블이름 BALUES (값1, 값2, ...);
SELECT * FROM DEPT01;
INSERT INTO DEPT01 (DEPTNO,DNAME,LOC)
    VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT01 (DNAME, LOC, DEPTNO)
    VALUES('SALES', 'BOSTON',20);
-- NULL값 입력은 입력하지 않으면 NULL 자동입력.
INSERT INTO DEPT01(DEPTNO,DNAME,LOC)
    VALUES(30,'IT',NULL);
INSERT INTO DEPT01(DEPTNO,DNAME)VALUES(40,'OPERATION');
--INSERT문에서 필드명을 생략한경우 반드시 필드 값 전체가 들어와야하고, 그 순서대로 입력해야 함.
INSERT INTO DEPT01 VALUES (50,'설계','마포');
SELECT * FROM DEPT01;
DESC DEPT01;
DESC DEPT01; --PK없는 DEPT01
-- DEPT01테이블에 DEPT테이블 10~30번 부서까지 내용을 INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT WHERE DEPTNO<40;
SELECT * FROM DEPT01;

--BOOK테이블에 11번, '스포츠의학', 한솔출판, 출판일 오늘, 가격은 90000
INSERT INTO BOOK(BOOKID, BOOKNAME, PUBLISHER,RDATE,PRICE)
    VALUES(11,'스포츠의학','한솔출판',SYSDATE, 90000);

SELECT * FROM BOOK;

COMMIT; --DML 명령어는 트랜잭션 단위로 진행
ROLLBACK; --트랜젝션 안에 있는 DML명령어를 취소



--DDL 연습문제

DROP TABLE SAM01;

CREATE TABLE SAM01 (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2)
);
SELECT * FROM USER_CONSTRAINTS;

INSERT INTO SAM01 VALUES(1000, 'APPLE','POLICE', 10000);
INSERT INTO SAM01 VALUES(1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES(1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 (EMPNO, ENAME, JOB,SAL) VALUES(1030, 'VERY',NULL , 25000);
INSERT INTO SAM01 (EMPNO, ENAME, JOB,SAL) VALUES(1040, 'CAT',NULL , 2000);

INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB,SAL FROM EMP WHERE DEPTNO=10;

ROLLBACK;

SELECT * FROM SAM01;

--(2) UPDATE 테이블이름 SET 필드명1 = 값1, [필드명2-값,...] [WHERE 조건];

CREATE TABLE EMP01
    AS SELECT * FROM EMP;
-- 부서번호를 30으로 수정
UPDATE EMP01 SET DEPTNO=30;
-- 모든 직원의 급여를 10% 인상하시오.
UPDATE EMP01 SET SAL=SAL*1.1;

COMMIT;
--특정 행의 데이터만 수정하고자 할 때는 WHERE절 추가
--20번 부서 직원의 입사일을 오늘로, 부서번호는 30번 부서로 수정
UPDATE EMP01 SET HIREDATE=SYSDATE, DEPTNO=30
    WHERE DEPTNO=10;
--SAL이 3000 이상인 사원만 급여를 10% 인상하시오.
UPDATE EMP01 SET SAL=SAL*1.1 WHERE SAL>=3000;
--'DALLAS'에 근무하는 직원들의 급여를 1000 인상
UPDATE EMP01 SET SAL=SAL+1000 
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
    
--SCOTT사원의 부서번호는 20으로 JOB은 MANAGER로 수정하는 SQL
UPDATE EMP01 SET DEPTNO=20, JOB='MANAGER'
    WHERE ENAME='SCOTT';
    
SELECT * FROM EMP01;
--SCOTT 사원의 입사일을 오늘로, 급여는 50, COMM은 400으로 수정
UPDATE EMP01 SET HIREDATE=SYSDATE, SAL=50, COMM=400
    WHERE ENAME='SCOTT';

--서브쿼리를 이용한 UPDATE문
--DEPT01에서 20번 부서의 지역명을 40번 부서의 지역명으로 변경
SELECT * FROM DEPT01;
UPDATE DEPT01 SET LOC='MAPO' WHERE DEPTNO=40;

UPDATE DEPTNO01 SET DNAME=(SELECT DNAME FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=20;;

--DEPT01에서 20번 부서의 지역명을 40번 부서의 부서명, 지역명으로 변경
UPDATE DEPT01 SET DNAME=(SELECT DNAME FROM DEPT01 WHERE DEPTNO=40),LOC=(SELECT LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO=20;

UPDATE DEPT01 SET (DNAME,LOC)=(SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO=20;

SELECT * FROM DEPT01 WHERE DEPTNO IN (20,40);
--EMP01 테이블의 모든 사원의 급여와 입사일을 'KING'DML RMQDUDHK DLQTKDLFFH TNWJD
SELECT * FROM EMP01;
UPDATE EMP01 SET (SAL, HIREDATE) =(SELECT SAL,HIREDATE FROM EMP01 WHERE ENAME='KING');

    --UPDATE 테이블명 SET 필드명=값, 필드명=값...
--(3) DELETE FROM 테이블명 WHERE 조건; --FROM을 잊지말것

COMMIT;
SELECT * FROM EMP01;
DELETE FROM EMP01;
ROLLBACK;

-- EMP01테이블에서 30번 부서 직원만 삭제
DELETE FROM EMP01
    WHERE DEPTNO=30;
    
--SAM01테이블에서 JOB이 정해지지 않은 사원을 삭제
SELECT * FROM SAM01;
DELETE FROM SAM01
    WHERE JOB IS NULL;
    
--EMP01 테이블에서 부서명이 SALES인 사원을 삭제.
DELETE FROM EMP01
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
--EMP01테이블에서 RESEARCH부서 소속인 사원 삭제
DELETE FROM EMP01
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
    
    
    

--PPT 연습문제
DROP TABLE MY_DATA;

--1. 구조를 만족하는 MY_DATA 테이블 생성. 단, ID가 PRIMARY KEY일것
CREATE TABLE MY_DATA (
    ID NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2)
);

--SELECT TO_CHAR(10000,'999,999.00') FROM DUAL;

--2. 1번에 의해 생성된 테이블에 아래의 값 입력
INSERT INTO MY_DATA VALUES(1,'SCOTT','sscott',10000);
INSERT INTO MY_DATA VALUES(2,'FORD','fford',13000);
INSERT INTO MY_DATA VALUES(3,'PATEL','ppatel',33000);
INSERT INTO MY_DATA VALUES(4,'REPORT','rreport',23500);
INSERT INTO MY_DATA VALUES(5,'GOOD','ggood',44450);

--INSERT INTO MY_DATA VALUES(2,'FORD','fford',TO_NUMBER('13,000','999,999.99'));

--3. 2번에서 입력한 자료 확인
SELECT * FROM MY_DATA;

--4. 자료를 영구적으로 데이터베이스에 등록
COMMIT;

--5. ID가 3번인 사람의 급여를 65,000,00으로 갱신하고 영구적으로 데이터베이스에 반영하여라.
UPDATE MY_DATA SET SALARY=65000 WHERE ID=3;
COMMIT;

UPDATE MY_DATA SET SALARY = TO_NUMBER('65,000.00','99,999.99') WHERE ID=3;

--7. 이름이 FORD인 사원을 영구 제명하여라.
DELETE FROM MY_DATA WHERE NAME='FORD';
COMMIT;

--8. 급여가 15,000 이하인 사람의 급여를 15,000으로 변경하여라.
UPDATE MY_DATA SET SALARY=15000 WHERE SALARY<15000;

--9. 1번에서 생성한 테이블을 삭제하여라.
DROP TABLE MY_DATA;

--★ ERD : 구조화된 데이터를 저장하기 위해 DB를 사용하는데, DB의 구조와 제약조건 등 다양한 기법을 설계하는 툴

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13),
    PRIMARY KEY(DEPTNO)
);

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13)
);

SELECT * FROM DEPT1;

CREATE TABLE EMP1( --제약조건은 부적합한 데이터 삽입을 방지하는 수단
    EMPNO NUMBER(4) PRIMARY KEY,  --제약조건 1. PRIMARY KEY
    ENAME VARCHAR(10) UNIQUE, --제약조건 2.UNIQUE
    JOB VARCHAR(9) NOT NULL, --제약조건 3. NOT NULL
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE, --제약조건 4. DEFAULT
    SAL NUMBER(7,2)CHECK(SAL>0), --제약조건 5. CHECK
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO) --제약조건 6. FOREIGN 키
);

SELECT * FROM EMP1;

INSERT INTO DEPT1 VALUES (10,'회계','신촌');
INSERT INTO DEPT1 VALUES (20,'설계','마포');
INSERT INTO DEPT1 VALUES (30,'영업','이대');
INSERT INTO DEPT1 VALUES (40,'전산','공덕');

--EMP1입력
INSERT INTO EMP1(EMPNO,ENAME,JOB,MGR,SAL, DEPTNO)
    VALUES (1111,'홍가', '회장', NULL,9000,40);
SELECT * FROM EMP1;
INSERT INTO EMP1(EMPNO,ENAME,JOB,MGR,SAL,DEPTNO)
    VALUES (1112,'홍군','전무',1111,1000,30);


INSERT INTO EMP01 VALUES(1113,'김군','물리',1112, TO_DATE('20201230','YYYYMMDD'),8000,200,40);
COMMIT;
--EX. 학생관리
DROP TABLE STUDENT;
DROP TABLE MAJOR;

CREATE TABLE MAJOR(
    major_CODE NUMBER(2) NOT NULL PRIMARY KEY,
    major_NAME VARCHAR(100) NOT NULL,
    major_OFFICE_LOC VARCHAR(255) NOT NULL
);

CREATE TABLE STUDENT(
    student_HAKBUN VARCHAR(10),
    student_NAME VARCHAR(30),
    SCORE NUMBER(3),
    major_CODE NUMBER(2) REFERENCES MAJOR(major_CODE)
 );

-- FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(major_CODE)  아래로 빼는 경우는 이렇게 쓸 것.

INSERT INTO MAJOR VALUES(1,'경영정보','3층 인문실');
INSERT INTO MAJOR VALUES(2,'소프트웨어공학','3층 인문실');
INSERT INTO MAJOR VALUES(3,'디자인','4층 과학실');
INSERT INTO MAJOR VALUES(4,'경제','4층 과학실');

INSERT INTO STUDENT VALUES ('A01','김길동',100,1);
INSERT INTO STUDENT VALUES ('A02','문길동',90,2);
INSERT INTO STUDENT VALUES ('A03','홍길동',95,1);

SELECT * FROM MAJOR;
SELECT * FROM STUDENT;



--EX. 도서관
DROP TABLE BOOK;
DROP TABLE BOOKCATEGORY;

CREATE TABLE BOOKCATEGORY (
CATEGORY_CODE NUMBER(3) PRIMARY KEY,
CATEGORY_NAME VARCHAR(20),
OFFICE_LOC VARCHAR(30)
);

CREATE TABLE BOOK(
CATEGORY_CODE NUMBER(3) REFERENCES BOOKCATEGORY(CATEGORY_CODE),
bookNO VARCHAR(20),
bookNAME VARCHAR(30),
PUBLISHER VARCHAR(20),
PUBYEAR NUMBER(4) DEFAULT TO_CHAR(SYSDATE,'YYYY')
);

INSERT INTO BOOKCATEGORY VALUES(100,'철학','3층 인문실');
INSERT INTO BOOKCATEGORY VALUES(200,'인문','3층 인문실');
INSERT INTO BOOKCATEGORY VALUES(300,'자연과학','4층 과학실');
INSERT INTO BOOKCATEGORY VALUES(400,'IT','4층 과학실');

INSERT INTO BOOK VALUES(100, '100A01', '철학자의 삶', '더존출판',2017);
INSERT INTO BOOK VALUES(400, '400A01', '이것이 DB다', '더존출판',2018);

SELECT * FROM BOOKCATEGORY;
SELECT * FROM BOOK;




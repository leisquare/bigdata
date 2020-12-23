-- [II] SELECT 문 
-- 1. SQL문 작성법
SELECT * FROM TAB; --현 계정 SCOTT이 가지고 있는 테이블들. 실행은 컨트롤 엔터
SELECT * FROM DEPT; --DEPT테이블의 모든 열,모든 행
SELECT * FROM EMP; --EMP 테이블의 모든 열, 모든 행
--DEPT 테이블의 구조 보기(ORACLE에서만 사용가능)
DESC DEPT;

-- 2. SQL문 실행(특정 열만 출력)
SELECT EMPNO,ENAME,SAL,JOB FROM EMP;
SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB AS "작업"
    FROM EMP; 
    --쌍따옴표 안에 스페이스 넣을 수 있지만 넣지 않는게 좋다. 다른 곳에서 불러오기 어려워짐
SELECT EMPNO AS 사번, ENAME AS 이름, SAL AS 급여, JOB AS 작업 FROM EMP; --띄어쓰기가 안 들어간다면 따옴표 없어도 가능. 출력 열에 별명 다는 것(타이틀조정)
SELECT EMPNO 사번, ENAME 이름, SAL 급여, JOB 작업 FROM EMP; --이것도 똑같이 나온다 

-- 3. WHERE 절(조건에 맞는 특정 행만 출력) 비교연산자를 이용
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP
    WHERE SAL=3000; -- SAL이 3000인 행만 출력 
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL!=3000; -- SAL이 3000이 아닌 행
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL^=3000; -- 상동
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<>3000; -- 상동
-- 10번 부서 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE DEPTNO = 10;
-- ENAME이 'FORD'인 직원의 모든 필드를 출력
SELECT * FROM EMP WHERE ENAME ='FORD'; --데이터는 대소문자 구분
--급여가 2000이상 3000미만인 직원의 모든 필드를 출력
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<3000;
--비교연산은 숫자, 문자, DATE형 모두 가능
SELECT * FROM EMP WHERE ENAME < 'F'; --'A', 'B','C','D','E'로 시작하는 사람.
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
--82년에 입사한 직원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE>= '82/01/01' AND HIREDATE<= '82/12/31';
--날짜 표기법 세팅
--ALTER SESSION SET NLS_CATE_FORMAT = "RR/MM/DD"; 를 실행합시다.
--연봉이 2400 이상인 직원의 ENAME, SAL, 연봉 출력(연봉 = SAL*12로)
SELECT ENAME 이름, SAL 급여, SAL*12 연봉 FROM EMP
    WHERE SAL*12 > 2400 --WHERE절에는 별명을 칠 수 없음.
    ORDER BY 연봉;

--4. 논리연산자
SELECT * FROM EMP WHERE DEPTNO=10 AND JOB='MANAGER';
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
SELECT * FROM EMP WHERE NOT DEPTNO = 10; 
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<=3000;

--5. 산술표현식
SELECT ENAME, SAL, SAL+300 UPGRADESAL FROM EMP;
-- 모든 사원의 사원명, 월급(SAL), 연봉(SAL*12+COMM)
SELECT ENAME 사원명, SAL 월급, COMM, SAL*12+NVL(COMM,0) 연봉 FROM EMP;
--산술연산 결과는 NULL이 포함되면 NULL로 출력됨.
--NVL(NULL일수도 있는 필드값, 대치값)둘의 유형은 같아야 함
--DESC EMP; 에서 유형 확인 가능
-- 모든 사원의 사원명, 월급(SAL), 연봉(SAL*12+COMM)을 출력하되 COMM이 NULL이면 0으로 출력하는 방법
SELECT ENAME, SAL, NVL(COMM,0),SAL*12+NVL(COMM,0) FROM EMP;
--모든 사원의 사원명(ENAME), 상사의 사번(MGR) 상사가 없으면 0 출력
SELECT ENAME, NVL(MGR,0) FROM EMP;

--6. 연결연산자(||): 열이나 문자를 연결
SELECT ENAME || '은 ' || JOB EMPLOYEES FROM EMP;
--SMITH IS CLERK 로 출력되고 TITLE EMPLOYEES 라고 모든 직원 출력

--7. 중복제거 (DISTINCT)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT MGR FROM EMP;

--중간 연습문제
--1. emp 테이블의 구조 출력
DESC EMP;
--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
--3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;
--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO,ENAME,SAL,JOB,HIREDATE FROM EMP;
--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;
--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>'81/02/01';
--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME,SAL FROM EMP WHERE SAL >=1500 AND SAL <=3000;
--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;
--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >=3000;
--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME,JOB,SAL FROM EMP WHERE SAL>=2500 AND JOB = 'MANAGER';
--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력
SELECT ENAME || '은 ' || JOB || '업무이고 연봉은' || SAL || '다' FROM EMP;

--8 SQL 연산자
--SAL이 1500 이상 3000 이하인 사번, 이름 급여
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL >=1500 AND SAL <=3000;
--BETWEEN A AND B(A~B까지, A와 B 포함)
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
--82년도에 입사
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE<= '82/12/31';
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31'; --앞이 더 작아야 함
--이름이 A~C로 시작하는 사람
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D';
--부서번호(DEPTNO)가 10,20인 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO = 20;
SELECT * FROM EMP WHERE DEPTNO IN (10,20);

SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20);

--EMPNO가 7902,7788,7566인 사원의 모든 필드 출력
SELECT * FROM EMP WHERE EMPNO IN (7902,7788,7566);
--이름이 M으로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; -- 0글자 이상. m만 있어도 된다
--이름에 n이 들어가는 모든 사원의 필드
SELECT * FROM EMP WHERE ENAME LIKE '%N%';
--이름이 S로 끝나는 모든 사원의 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S';
--이름에 % 들어가는 모든 사원의 필드
--DELETE EMP WHERE EMPNO =9999; 데이터 하나 잘못 넣어서 지웠음
INSERT INTO EMP VALUES (9999,'A%',NULL,NULL,NULL,9000,9000,40);
SELECT * FROM EMP;
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
ROLLBACK; --DML(데이터 조작어)를 취소
SELECT * FROM EMP;

--SAL이 5로 끝나는 사원의 모든필드
SELECT * FROM EMP WHERE SAL LIKE '%5';
DESC EMP;
--입사년도가 82년인 사원의 모든 필드
SELECT * FROM EMP
    WHERE HIREDATE>= '82/01/01' AND HIREDATE<= '82/12/31';
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT * FROM EMP WHERE HIREDATE LIKE '82/__/__';
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';

SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('1982/01/01','YYYY/MM/DD') AND TO_DATE('1982/12/31','YYYY/MM/DD');

--1월에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
--상여금이 없는 사원의 모든 필드
SELECT COMM FROM EMP;
SELECT * FROM EMP WHERE COMM = 0 OR COMM IS NULL;
-- 상여금이 있는 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM!=0;

--9. 정렬(오름차순 내림차순)
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC; --오름차순 정렬(ASCENDING은 생략해도 됨)
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC; -- 내림차순
--SAL이 높은 순으로 출력(단, 같은 SAL일 경우 입사일 최신 순으로 출력)
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE DESC, ENAME; -- SAL순서대로 나열하고 같은 것끼리 HIREDATE를 비교, 그 다음 ENAME비교.
--이름, 연봉(SAL*12+COMM)을 출력 (연봉 높은 순으로)
SELECT ENAME, SAL*12+NVL(COMM,0) 연봉 FROM EMP ORDER BY SAL*12+NVL(COMM,0) DESC;
--이름, 연봉을 출력(연봉 높은 순으로, 연봉이 2000이상인 직원의 이름, 연봉). WHERE절은 별명 사용 불가, ORDER절은 별명 사용 가능
SELECT ENAME, SAL*12+NVL(COMM,0) 연봉 FROM EMP WHERE SAL*12+NVL(COMM,0)>=2000 ORDER BY 연봉 DESC;


----총 연습문제.

--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB,SAL FROM EMP WHERE SAL>=3000;
 
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME,DEPTNO FROM EMP WHERE EMPNO = 7788;

--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL*12+NVL(COMM,0)>=24000 ORDER BY SAL;

--4.	EMP 테이블에서 hiredate가 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 
--ename,job,hiredate을 출력하는 SELECT 문장을 작성 (단 hiredate 순으로 출력)
SELECT ENAME, JOB,HIREDATE FROM EMP WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;

--5.	EMP 테이블에서 deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME;

--6.	EMP 테이블에서 sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME "employee", SAL "Monthly Salary" FROM EMP WHERE SAL>=1500 AND DEPTNO IN (10,30);

--7.	EMP 테이블에서 hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '82/__/__';

SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY,MM,DD') LIKE '1982%';


--날짜형을 문자형으로 바꾸는 것 (TO_CHAR(HIREDATE,'YYYY,MM,DD'))
--문자형을 날자형으로 바꾸는 것(TO_DATE('1982/12/12','YYYY,MM,DD'))-> 날짜형

--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME,SAL FROM EMP WHERE ENAME BETWEEN 'C%' AND 'P%';

--9.	EMP 테이블에서 comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
--출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM>=SAL*1.1;

--10.	EMP 테이블에서 job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE (JOB = 'CLERK' OR JOB = 'ANALYST') AND SAL NOT IN(1000,3000,5000);

--11.	EMP 테이블에서 ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
--모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;

--12.	사원 테이블에서 입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/__/__';

--13.	사원 테이블에서 입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
-- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/__/__'AND JOB^= 'SALESMAN';

--14.	사원 테이블의 사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO,ENAME,HIREDATE,JOB,SAL FROM EMP ORDER BY SAL DESC, HIREDATE ASC;

--15.	사원 테이블에서 사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--16.	사원 테이블에서연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, SAL*12+NVL(COMM,0) "연봉" FROM EMP WHERE SAL*12+NVL(COMM,0)>=35000;


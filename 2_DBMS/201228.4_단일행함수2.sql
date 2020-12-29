--(4) 형변환함수
--TO_CHAR(날짜, 패턴); 날짜값을 패턴에 맞게 문자로 형변환
    --YY(연도) MM(월) MON(월이름) DD(일) DY(요일)
    --HH24 (0~23 시간출력) AM(오전오수) HH(0~11시) MI(분) SS(초)
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY"년"-MM"월"-DD"일"DY"요일"')FROM EMP;

SELECT TO_CHAR(SYSDATE,'YY"년" MON DD"일" AM HH"시" MI"분" SS"초"') FROM DUAL;
--TO_CHAR(숫자, 패턴); 숫자값을 패턴에 맞게 문자로 형변환
    --패턴 내 0: 자릿수. 자릿수가 맞지 않으면 0으로 채움
    --패턴 내 9: 자릿수. 자릿수가 맞지 않으면 채우지 않음(자바에서는 #)(자릿수 넘치면 난리남)
    --패턴 내 $: 통화 단위 $가 숫자 앞에 붙음.
    --패턴 내 L: 지역통화단위가 숫자 앞에 붙음.
SELECT ENAME, TO_CHAR(SAL, 'L999,999') FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$999,999') FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$000,000') FROM EMP;

--TO_DATE(문자, 패턴); '81/01/01' 문자를 패턴에 맞게 날짜형으로 변환.
--81/5/1~83/5/1 사이에 입사한 직원 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '81/05/01' AND '83/05/01';
SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD') AND TO_DATE('19830501','YYYYMMDD');
--2020년 11월 30일부터 현재까지 날짜수를 출력. (SYSTEM의 날짜형 포맷을 모른다)
SELECT TRUNC(SYSDATE-TO_DATE('20201130','YYYYMMDD')) FROM  DUAL;
SELECT CEIL(SYSDATE-TO_DATE('20201130','YYYYMMDD')) FROM  DUAL;
--TO_NUMBER(문자, 패턴); 문자를 패턴에 맞게 숫자형으로 변환.
SELECT TO_NUMBER('1,000','9,999') FROM DUAL;
SELECT TO_NUMBER('1,000','9,999')*1.1 FROM DUAL;


--(5) NULL 관련함수 ; NVL(널일수도 있는 데이터, 널인 경우 대신할 값). 매개변수 2개는 타입이 일치할 것. 
--사원이름, 직속 상사의 이름(직속 상사가 없으면 CEO로 출력)
SELECT E.ENAME, NVL(D.ENAME,'CEO') FROM EMP E, EMP D WHERE E.MGR=D.EMPNO(+);

--사원이름, 직속 상사의 사번(직속상사가 없으면 CEO로 출력)
SELECT E.ENAME, NVL(TO_CHAR(E.MGR),'CEO') 상사사번 FROM EMP E, EMP D WHERE E.MGR=D.EMPNO(+);

--(6) DECODE (데이터, 값1, 결과 1, 값2, 결과 2, ..., 값N, 결과 N, 그외결과)
--이름, 부서번호, 부서이름
SELECT ENAME, D.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;
SELECT ENAME, DEPTNO, DECODE (DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATION','ETC1')AS DNAME FROM EMP;
SELECT ENAME, DEPTNO, 
    CASE WHEN DEPTNO = 10 THEN 'ACCOUNTING'
         WHEN DEPTNO = 20 THEN 'RESEARCH'
         WHEN DEPTNO = 30 THEN 'SALES' 
         WHEN DEPTNO = 40 THEN 'OPERATION' ELSE 'ETC1'
         END AS "DNAME"
         FROM EMP;
         
SELECT ENAME, DEPTNO, 
    CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                WHEN 20 THEN 'RESEARCH'
                WHEN 30 THEN 'SALES'
                WHEN 40 THEN 'OPERATION' ELSE 'ETC1'
                END AS "DNAME"
                FROM EMP;

--이름, 급여, 인상예정급여
    --JOB에 따라 'ANALYST' 10% 인상, 'MANAGER'면 20% 인상, PRESIDENT면 30% 인상, SALESMAN이면 40% 인상
SELECT DISTINCT JOB FROM EMP;
SELECT ENAME, SAL, DECODE(JOB, 'ANALYST', SAL*1.1, 'MANAGER', SAL*1.2, 'PRESIDENT', SAL*1.3, 'SALESMAN', SAL*1.4,SAL)AS 인상급여 FROM EMP;

SELECT ENAME, SAL 현급여,
    CASE WHEN JOB = 'ANALYST' THEN SAL*1.1
         WHEN JOB = 'MANAGER' THEN SAL*1.2
         WHEN JOB = 'PRESIDENT' THEN SAL*1.3
         WHEN JOB = 'SALESMAN' THEN SAL*1.4
         ELSE SAL
         END AS 인상급여
         FROM EMP;

--(7) 그 외 EXTRACT, 레벨별 출력
SELECT EXTRACT(YEAR FROM HIREDATE) YEAR FROM EMP; 
SELECT TO_CHAR(HIREDATE,'YYYY') YEAR FROM EMP;
SELECT EXTRACT(MONTH FROM HIREDATE) MONTH FROM EMP;
SELECT TO_CHAR(HIREDATE,'MM')MONTH FROM EMP;

-- LEVEL, START WITH(최상위레벨의 조건),CONNECT BY PRIOR(레벨들 연결조건)
SELECT LEVEL, LPAD(' ',LEVEL*2)||ENAME, MGR FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;


-- <셤 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT TO_CHAR(SYSDATE, 'YYYY"년"-MM"월"-DD"일" DY"요일"')AS "Current date" FROM DUAL;

-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "NEW Salary", SAL*1.15-SAL "증가액" FROM EMP;

--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE,6),'월') FROM EMP;

--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 근무개월수, SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 급여총계  FROM EMP;

--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL,15,'*') FROM EMP;

--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE,'DY') 입사요일 FROM EMP;

--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME)>=6;

--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, TO_NUMBER(NVL(COMM,0)) "보너스", SAL+TO_NUMBER(NVL(COMM,0)) "급여+보너스" FROM EMP;

-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME,2,3) FROM EMP;

--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')=12;

--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 
SELECT EMPNO, ENAME, LPAD(SAL,10,'*') 급여 FROM EMP;

-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD') 입사일 FROM EMP;

--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고 3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL,'$999,999') FROM EMP WHERE DEPTNO = 20;

-- 14. 사원 테이블에서 급여에 따라 사번, 이름, 급여, 등급을 검색하는 SQL 문장을 작성 하시 오.
-- 급여가 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL,
    CASE WHEN SAL BETWEEN 0 AND 1000 THEN 'E'
         WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
         WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
         WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
         WHEN SAL BETWEEN 4001 AND 5000 THEN 'A'
         ELSE 'ETC'
         END 
         FROM EMP;

-- **** 발상이 어렵다
SELECT EMPNO, ENAME,SAL,DECODE(TRUNC((SAL-1)/1000),0,'E',1,'D',2,'C',3,'B',4,'A') 등급 FROM EMP;


--SELECT EMPNO, ENAME,SAL,
--    DECODE (TRUNC(SAL/1000)=0, 'E', TRUNC((SAL-1)/1000)=1, D, TRUNC((SAL-1)/1000)=2, C, TRUNC((SAL-1)/1000)=3,B,TRUNC((SAL-1)/1000)=4,A) FROM EMP;

SELECT ENAME, TRUNC((SAL-1)/1000) FROM EMP;

--SELECT EMPNO, ENAME,SAL,
--   DECODE (SAL, TRUNC((SAL-1)/1000)=0, 'E', TRUNC((SAL-1)/1000)=1, D, TRUNC((SAL-1)/1000)=2, C, TRUNC((SAL-1)/1000)=3,B,TRUNC((SAL-1)/1000)=4,A) FROM EMP;

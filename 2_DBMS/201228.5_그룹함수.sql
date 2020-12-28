--[V] 그룹함수 : SUM, AVG, MIN, MAX, COUNT STDDEV, VARIANCE
SELECT ENAME, ROUND(SAL,-3) FROM EMP; --단일행함수

SELECT SUM(SAL) FROM EMP; --그룹함수

SELECT ENAME, SUM(SAL) FROM EMP; -- 그룹함수는 단일행과 같이 쓸 수 없다.
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;
--EMP테이블에서 평균 SAL
SELECT ROUND(AVG(SAL),2) FROM EMP;
SELECT COUNT(SAL) FROM EMP; 
SELECT COUNT(*) FROM EMP; --로우(행) 수
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP; --300,500,1400,0
SELECT COUNT(COMM), SUM(COMM) AVG(COMM) FROM EMP; --그룹함수는 NULL값을 제외하고 게산한다.
-- EMP 테이블에서 SAL의 평균, 합, 최소값, 최대값, 분산, 표준편차
SELECT ROUND(AVG(SAL)), SUM(SAL), MIN(SAL), MAX(SAL), ROUND(VARIANCE(SAL)), ROUND(STDDEV(SAL)) FROM EMP;
-- 부서번호별 급여 최대치
SELECT DEPTNO 부서번호, MAX(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO; --GROUP BY 절에는 필드 별칭이 올 수 없다.
--그룹함수는 숫자형, 문자형, 날짜형에 모두 사용 가능.
--부서번호별로 최초 입사년도, 최근 입사년도
SELECT DEPTNO, MIN(HIREDATE),MAX(HIREDATE) FROM EMP GROUP BY DEPTNO;
SELECT MIN(ENAME), MAX(ENAME) FROM EMP;
SELECT COUNT(DISTINCT JOB) FROM EMP;

--	탄탄 다지기
-- 가장 최근에 입사한 사원의 입사일과 입사한지 가장 오래된 사원의 입사일을 출력. 
--(결과) 80/12/17:14620일째 83/01/12:13864일째
SELECT MAX(HIREDATE)||':'||TRUNC(SYSDATE-MAX(HIREDATE))||'일째 ' ||MIN(HIREDATE)||':'||TRUNC(SYSDATE-MIN(HIREDATE)) FROM EMP;
	
--(결과) 80년12월17일 최초입사  :14,620일째 83년01월12일 최근입사 :13,864일째
	SELECT TO_CHAR(MAX(HIREDATE))||'최근입사'||TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)),'99,999')||' 최초입사' ||MIN(HIREDATE)||':'||TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)),'99,999')||'일째 ' FROM EMP;
   
--10번 부서 소속의 사원 평균급여
SELECT AVG(SAL) FROM EMP WHERE DEPTNO=10;
--	10번 부서 소속의 사원 중에서 커미션을 받는 사원의 수를 구해 보시오.


--2. GROUP BY 절
--EX. 부서별 최대급여
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE =(SELECT MAX(HIREDATE) FROM EMP);

--부서번호별 사원수, 최대급여, 최소급여, 평균급여
SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)) 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
    GROUP BY DNAME;

SELECT DEPTNO, JOB, SUM(SAL) FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO;
    
    
-- ★ 3. HAVING (그룹함수 결과의 조건
-- DEPTNO별로 평균급여(평균급여가 2000이상인 부서만 출력)
SELECT DEPTNO, AVG(SAL) FROM EMP
    GROUP BY DEPTNO
    HAVING AVG(SAL)>2000;

-- ★ 4. 피벗테이블
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;
-- 1단계
SELECT DEPTNO, DECODE(JOB,'CLERK', SAL, 0) "CLERK",
            DECODE(JOB,'MANAVER', SAL, 0) "MANAGER",
            DECODE(JOB,'PRISIDENT', SAL, 0) "PRISIDENT",
            DECODE(JOB,'ANALYST',SAL,0) "ANALYST",
            DECODE(JOB, 'SALESMAN',SAL,0) "SALESMAN" 
            FROM EMP;
            
-- 2단계
SELECT DEPTNO, SUM(DECODE(JOB,'CLERK', SAL, 0)) "CLERK",
            SUM(DECODE(JOB,'MANAGER', SAL, 0)) "MANAGER",
            SUM(DECODE(JOB,'PRESIDENT', SAL, 0)) "PRESIDENT",
           SUM(DECODE(JOB,'ANALYST',SAL,0)) "ANALYST",
           SUM(DECODE(JOB, 'SALESMAN',SAL,0)) "SALESMAN" 
           FROM EMP
            GROUP BY DEPTNO;
            
            DECODE(JOB, 'SALESMAN',SAL,0) "SALESMAN" FROM;
-- 3단계 : 합계추가

SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);

SELECT DEPTNO, SUM(DECODE(JOB,'CLERK', SAL, 0)) CLERK,
            SUM(DECODE(JOB,'MANAGER', SAL, 0)) MANAGER,
            SUM(DECODE(JOB,'PRESIDENT', SAL, 0)) PRESIDENT,
           SUM(DECODE(JOB,'ANALYST',SAL,0)) ANALYST,
           SUM(DECODE(JOB, 'SALESMAN',SAL,0)) SALESMAN,
           SUM(SAL) AS 소계
        FROM EMP GROUP BY ROLLUP(DEPTNO);



--1. 사원 테이블에서 인원수,최대 급여,최소 급여,급여의 합을 계산하여 출력
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;

--2. 사원테이블에서 업무별 인원수를 구하여 출력하는 SELECT 문장을 작성하여라.
SELECT JOB, COUNT(*)
    FROM EMP
    GROUP BY JOB;

--3. 사원테이블에서 최고 급여와 최소 급여의 차이는 얼마인가 출력하는 SELECT문장을 작성하여라.
SELECT MAX(SAL)-MIN(SAL) FROM EMP;
--4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력하되 급여의 합이 많은 순으로 출력하라.
SELECT COUNT(*), TRUNC(AVG(SAL)), MIN(SAL), MAX(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO 
    ORDER BY SUM(SAL) DESC;

--5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하라
--(출력결과는 부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*) "인원수" , TRUNC(AVG(SAL)), SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO, JOB 
    ORDER BY DEPTNO, JOB;


--6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 구하여 
-- 출력하라.(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO , COUNT(*) "인원수" , TRUNC(AVG(SAL)), SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO, JOB 
    ORDER BY DEPTNO, JOB;

--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력하시오.
SELECT DEPTNO, COUNT(*)
    FROM EMP
    HAVING COUNT(*)>=5
    GROUP BY DEPTNO;


-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력하시오
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    HAVING COUNT(*)>=5
    GROUP BY DNAME;

--9. 사원 테이블에서 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 
--급여의 합을 구하여 출력하라
SELECT JOB, TRUNC(AVG(SAL)), SUM(SAL)
    FROM EMP
    HAVING TRUNC(AVG(SAL))>=3000
    GROUP BY JOB;


--10. 사원테이블에서 급여합이 5000을 초과하는 각 업무에 대해서 업무와 급여합계를 출력하라 
        --단, 급여 합계로 내림차순 정렬하라.
SELECT JOB, SUM(SAL)
    FROM EMP
    HAVING SUM(SAL)>5000
    GROUP BY JOB
    ORDER BY SUM(SAL) DESC;

--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력하라.
SELECT DNAME, TRUNC(AVG(SAL)), SUM(SAL), MIN(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME;


--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 
            --부서별 최소급여의 최대치를 출력하라.
SELECT MAX(TRUNC(AVG(SAL))), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;
    

--13. 사원 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(년도별 연봉합)
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100

SELECT TO_CHAR(HIREDATE,'YY') AS H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'YY')
    ORDER BY H_YEAR;

-- 14.  사원테이블에서 아래의 결과를 출력하는 SELECT 문 작성
-- TOTAL	1980	1981	1982	1983
--  14		  1	     10	      2	      1
SELECT COUNT(*) AS TOTAL,
       SUM(DECODE(TO_CHAR(HIREDATE,'YYYY'),1980,1,0)) AS "1980",
       SUM(DECODE(TO_CHAR(HIREDATE,'YYYY'),1981,1,0)) AS "1981",
       SUM(DECODE(TO_CHAR(HIREDATE,'YYYY'),1982,1,0)) AS "1982",
       SUM(DECODE(TO_CHAR(HIREDATE,'YYYY'),1983,1,0)) AS "1983"
       FROM EMP;
     
     --**  (DECODE(TO_CHAR(HIREDATE,'YYYY'),1980,1,) null인 채로 두면 count 가능, 아닌 경우 sum 해야함.
       
--     GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'));
-- **안달아도되는거였다.

--15. 사원테이블에서 아래의 결과를 출력하는 SELECT 문 작성(JOB 순으로 오름차순 정렬)
-- JOB별, DEPTNO별 SUM(SAL)
--JOB		DEPTNO10	DEPTNO20	DEPTNO30     TOTAL
--ANALYST	     0		   6000		    0		6000
--CLERK		  1300		   1900		  950		4150
--….
--SALESMAN	      0	 		0	 5600		 5600

SELECT JOB, SUM(DECODE(DEPTNO,10,SAL,0)) AS DEPTNO10,
            SUM(DECODE(DEPTNO,20,SAL,0)) AS DEPTNO20,
             SUM(DECODE(DEPTNO,30,SAL,0)) AS DEPTNO30,
             SUM(SAL) AS TOTAL
    FROM EMP
    GROUP BY JOB
    ORDER BY JOB;


        
--16. 사원테이블에서 최대급여, 최소급여, 전체급여합, 평균을 구하시오
SELECT MAX(SAL), MIN(SAL), SUM(SAL), TRUNC(AVG(SAL))
    FROM EMP;


--17. 사원테이블에서 부서별 인원수를 구하시오
SELECT COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;


--18. 사원 테이블에서 부서별 인원수가 6명이상인 부서코드를 구하시오
SELECT DEPTNO, COUNT(*)
    FROM EMP
    HAVING COUNT(*)>=6
    GROUP BY DEPTNO;

--19. 사원테이블에서 다음과 같은 결과가 나오게 하시오
--DNAME               CLERK    MANAGER  PRESIDENT  ANALYST   SALESMAN
--ACCOUNTING          1300       2450       5000          0           0
--RESEARCH             1900       2975           0       6000          0
--SALES                  950       2850           0          0       5600

SELECT D.DNAME, SUM(DECODE(JOB,'CLERK', SAL, 0)) AS CLERK,
    SUM(DECODE(JOB,'MANAGER', SAL, 0)) AS MANAGER,
    SUM(DECODE(JOB,'PRESIDENT', SAL, 0)) AS PRESIDENT,
    SUM(DECODE(JOB,'ANALYST',SAL,0))AS  ANALYST,
    SUM(DECODE(JOB, 'SALESMAN',SAL,0)) AS SALESMAN
    FROM EMP E, DEPT D 
    WHERE D.DEPTNO = E.DEPTNO
    GROUP BY D.DNAME;

--20.  사원테이블에서 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. 
-- (힌트 self join, group by, count사용)
--ENAME	    등수
--________________________
--KING		1
--SCOTT		2
--……

            
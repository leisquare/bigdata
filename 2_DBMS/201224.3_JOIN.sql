--[III] JOIN : ���̺��� 2�� �̻� �����Ͽ� �˻�

SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT; 

--CROSS JOIN(FROM���� ���̺� 2�� �̻�)
SELECT * FROM EMP,DEPT WHERE ENAME = 'SCOTT';
--EQUI JOIN (���� �ʵ��� DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN)
SELECT * FROM EMP,DEPT WHERE ENAME = 'SCOTT' AND EMP.DEPTNO=DEPT.DEPTNO;
SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;
--��� ����� �̸�,�μ���, �μ���ȣ
SELECT ENAME ,DNAME, E.DEPTNO FROM EMP E ,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO;
SELECT E.*, DNAME,LOC
    FROM EMP E,DEPT D WHERE E.DEPTNO=D.DEPTNO;

--���, �̸�, �μ���ȣ, �μ��̸�, �ٹ��� ���
SELECT EMPNO, ENAME, E.DEPTNO, DNAME,LOC
    FROM EMP E,DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
--�޿� 2000 �̻� ������ �̸�, ����, �޿�, �μ���, �ٹ��� �ʵ� ���
SELECT ENAME,JOB,SAL,DNAME,LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000;
--LOC�� CHICAGO�� ����� �̸�, ����, �μ���, �ٹ��� ���
SELECT ENAME,JOB, DNAME,LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
--�μ���ȣ�� 10 �Ǵ� 20�� ����� �̸�, ����, �ٹ��� ���(�޿��� ����)
SELECT ENAME, JOB, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND D.DEPTNO IN (10,20)
    ORDER BY SAL;
--�̸�, �޿�, ��(COMM), ����((�޿�+COMM)*12),�μ���, �ٹ���
SELECT ENAME,SAL,COMM,(SAL+NVL(COMM,0))*12 "����", DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
--�̸�, �޿�, ��(COMM), ����((�޿�+COMM)*12),�μ���, �ٹ���
--JOB�� SALESMAN �Ǵ� MANAGER�� �����(������ ū ������ ����)
SELECT ENAME,SAL,COMM,(SAL+NVL(COMM,0))*12 "����", DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB IN('SALESMAN','MANAGER') --UPPER(JOB) ��밡��
    ORDER BY ���� DESC;
--COMM�� NULL�̰� �޿��� 1200 �̻��� ����� �̸�, �޿� �Ի���, �μ���ȣ, �μ���(�μ����, �޿�ū�� ����
SELECT ENAME, SAL,HIREDATE,E.DEPTNO,DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME, SAL DESC;

--EQUI JOIN ����

-- TO_CHAR(��¥��, 'YY')
-- TO_CHAR(������, 'YY')






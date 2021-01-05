-- 계정생성, 권한부여, 권한박탈, 계정삭제
-- DDL(제약조건, 시퀀스 없음),
-- DML(OUTER JOIN, AND=&&, OR = ||,  일부 단일행함수가 다름)
-- JAVA에서 쓸 데이터 넣고 연습해보기. 
show tables; -- select * from tab;
show databases; -- database들의 리스트
-- DCL
create user user01 identified by 'password';
grant all on *.* to user01;
grant all privileges on *.* to user01;
flush privileges;
revoke all on *.* from user01; -- 권한박탈
revoke all privileges on *.* from user01;
drop user user01;
-- 데이터베이스 들어감
show databases;
create database kimdb; -- 새로운 kimdb 데이터베이스가 생성
use kimdb;
select database(); -- 현재 들어와있는 데이터베이스 공간을 알려줌
create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique, -- 널 포함 가능, 널값이 아닐 경우 유일한 값 check
    sal numeric(7,2) check(sal>0),
    hiredate datetime default now(),
    comm numeric(7,2) default 0
);

drop table if exists emp;

create table emp(
	empno numeric(4),
    ename varchar(20) not null,
    nickname varchar(20),-- 널 포함 가능, 널값이 아닐 경우 유일한 값 check
    sal numeric(7,2),
    hiredate datetime default now(),
    comm numeric(7,2) default 0,
    primary key(empno),
    unique(nickname),
    chect(sal>0)
);
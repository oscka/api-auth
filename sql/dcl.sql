-- [참고] https://www.lesstif.com/dbms/postgresql-61899197.html

-- 계정 생성
-- CREATE USER {user_name} WITH PASSWORD '{user_password}';
create user openmsauser password 'open1234!!';

-- 계정에 ROLE 추가 (데이터베이스를 생성할 수 있는 Role)
ALTER ROLE openmsauser CREATEDB REPLICATION;

-- database 생성
create database openmsadb owner openmsauser ENCODING 'utf-8';

-- psql 연결
psql -U openmsauser -d openmsadb  -W -h localhost

-- 계정 조회 (psql)
\du

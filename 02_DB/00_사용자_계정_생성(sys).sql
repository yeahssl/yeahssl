-- 한 줄 주석

/*
 범위
 주석 
 */

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
-- CTRL + ENTER : 선택한 SQL 수행

-- 사용자 계정 생성
CREATE USER kh_lys IDENTIFIED BY "oracle_lys5034A";

-- 사용자 계정에 권한 부여
GRANT RESOURCE, CONNECT TO kh_lys;

-- 객체가 생성될 수 있는 공간 할당량 지정
ALTER USER kh_lys DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;



-- 비밀번호 모두 pass01!로 변경
UPDATE "MEMBER" SET
MEMBER_PW = '$2a$10$n91pgfw1ujRR1V3p14W8le1OS1NGcz4WsZakHqhxSEGXvVtYo4y72';

COMMIT;
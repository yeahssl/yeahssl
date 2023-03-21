SELECT EMP_ID, EMP_NAME,NVL(PHONE, '없음') PHONE, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME 
FROM EMPLOYEE 
NATURAL JOIN JOB 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE EMP_NAME LIKE '%동%' 
ORDER BY EMP_ID;



------------------------------------------------------------------------------------------
-- 2023/03/21

-- 사번, 이름, 직급명, 급여 조회
-- 급여 내림차순

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE SALARY BETWEEN 2000000 AND 3000000
ORDER BY SALARY DESC;

-- 입력 2개
-- 조회 결과 N행(List 필요)
------------------------------------------------------------------------------------------
SELECT MAX(EMP_ID) FROM EMPLOYEE;

-- 사번 생성 시퀀스 (223번 시작)
CREATE SEQUENCE SEQ_EMP_ID 
START WITH 223 -- 223번 시작
INCREMENT BY 1 -- 1씩증가
NOCYCLE -- 반복 없음
NOCACHE; -- 미리 만들어 두는 번호 없음

-- SEQ_EMP_ID.NEXTVAL : 다음 번호 생성
-- SEQ_EMP_ID.CURRVAL : 현재 번호 조회

-------------------------------------------------------------------------------------------
/*UPDATE EMPLOYEE 
SET EMAIL = ?, 
	PHONE = ?, 
 	SALARY = ?
WHERE EMP_ID = ?
*/
SELECT EMP_ID, EMP_NAME , PHONE, EMAIL, SALARY, ENT_YN  
FROM EMPLOYEE
WHERE EMP_ID = '226';


UPDATE EMPLOYEE 
SET ENT_YN = 'Y',
	ENT_DATE = SYSDATE
WHERE EMP_ID = 226; 












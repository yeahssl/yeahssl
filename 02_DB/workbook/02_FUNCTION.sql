-- 1. 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를 년도가 빠른 순으로 표시하는 SQL 문장을
--    작성하시오. (단, 해더는 "학번", "이름", "입학년도"가 표시되도록 한다.)
SELECT  STUDENT_NO 학번, STUDENT_NAME 이름, ENTRANCE_DATE 입학년도
FROM TB_STUDENT 
ORDER BY ENTRANCE_DATE ASC;

-- 2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다. 그 교수의
--    이름과 주민번호를 화명에 출력하는 SQL 문장을 작성해 보자.(* 이때 올바르게 작성한 SQL
--    문장의 결과 값이 예상과 다르게 나올 수 있다. 원인이 무것일지 생각해 볼 것)
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR 
WHERE PROFESSOR_NAME NOT LIKE '___';

-- 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 단 이때 나이가 적은 
--    사람에서 많은 사람 순서로 화면에 출력되도록 만드시오. (단, 교수 중 2000 년 이후 출생자는 없으며 )



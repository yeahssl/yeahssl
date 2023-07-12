
-- FAQ 전체 목록 조회
SELECT * 
FROM FAQ
LEFT JOIN "FAQ_CATEGORY"  USING (FAQ_CATEGORY)
WHERE FAQ_DELETE_FL = 'N';

SELECT * FROM FAQ;


CREATE TABLE "FAQ_CATEGORY" (
	"FAQ_CATEGORY"	CHAR(1)		NOT NULL,
	"CATEGORY_TITLE"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "FAQ_CATEGORY"."FAQ_CATEGORY" IS '문의 분류(P:영화관, M:영화, U:멤버쉽, B:예매/결제, H:홈페이지 A:계정)';

COMMENT ON COLUMN "FAQ"."FAQ_CATEGORY" IS '문의 분류(P:영화관, M:영화, U:멤버쉽)';



COMMENT ON COLUMN "FAQ_CATEGORY"."CATEGORY_TITLE" IS '카테고리 제목 사용';

ALTER TABLE "FAQ_CATEGORY" ADD CONSTRAINT "PK_FAQ_CATEGORY" PRIMARY KEY (
	"FAQ_CATEGORY"
);


-- 카테고리 종류 삽입
INSERT INTO "FAQ_CATEGORY" VALUES('P', '상영관');
INSERT INTO "FAQ_CATEGORY" VALUES('M', '회원');
INSERT INTO "FAQ_CATEGORY" VALUES('U', '멤버십');
INSERT INTO "FAQ_CATEGORY" VALUES('', '멤버십');
INSERT INTO "FAQ_CATEGORY" VALUES('U', '멤버십');

DELETE FROM FAQ
WHERE FAQ_CATEGORY = 'A';
DELETE FROM FAQ
WHERE FAQ_CATEGORY = 'B';

DELETE FROM FAQ; 


ROLLBACK;

COMMIT;

SELECT * FROM "FAQ_CATEGORY";
SELECT * FROM "FAQ";

-- FAQ 샘플 데이터 삽입
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '상영관은 몇 개인가요?', '상영관은 총 3개로 이루어져 있습니다.', 'N', 'P'
); 
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '분실물을 찾고 싶어요.', '안녕하세요. 드림가든 시네마입니다.
분실물이 생긴 경우 1:1문의를 통해 연락을 남겨주시면 도움을 드리도록 하겠습니다.', 'N', 'P'
); 
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '상영관에서 음식물 섭취가 가능한가요?', '코로나19로 섭취가 일시적으로 불가능 했으나, 현재는 섭취가 가능합니다.', 'N', 'P'
); 
 
 
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '회원탈퇴는 어떻게 하나요?', '내정보 수정에서 회원탈퇴를 하실 수 있습니다.', 'N', 'M'
); 
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '비회원으로 예매가 가능한가요?', '안녕하세요, 드림가든시네마 입니다. 
저희 영화관은 회원가입 후, 예매가 가능하십니다. 
감사합니다.', 'N', 'M'
); 
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '개인정보는 어디에서 수정할 수 있나요?', '마이페이지 > 내정보 변경 탭 에서 수정 가능 합니다.', 'N', 'M'
); 
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '회원가입은 어떻게 하나요?', '상단바에 있는 회원가입 탭에서 하실 수 있습니다.', 'N', 'M'
); 

INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '멤버십 등급은 어떻게 나누어 지나요?', '브론즈, 실버, 골드, 플래티넘으로 단계가 나누어져 있고, 자세한 사항은 멤버십 이용약관을 참고해 주세요.', 'N', 'U'
); 
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '멤버쉽 금액 기준을 알고싶어요.', '안녕하세요. 드림가든 시네마입니다.

일반 회원 기준 : 브론즈
4만원 이상 시 : 실버
10만원 이상 시 : 골드
20만원 이상 시: 플래티넘입니다.

감사합니다.
자세한 문의는 1:1문의하기에서 문의 바랍니다.', 'N', 'U'
); 
INSERT INTO "FAQ" VALUES(
	SEQ_FAQ_NO.NEXTVAL, '멤버십 쿠폰은 어디서 사용할 수 있나요?', '영화 예매시, 쿠폰사용하기를 클릭하시면 현재 가지고 계신 쿠폰을 사용하실 수 있습니다.
자세한 사항은 멤버십 페이지 혹은 멤버십 이용약관을 참고해 주세요.', 'N', 'U'
); 


COMMIT;

-- FAQ(상영관 이용 관련) 목록 조회
SELECT * 
FROM FAQ
LEFT JOIN "FAQ_CATEGORY"  USING (FAQ_CATEGORY)
WHERE FAQ_DELETE_FL = 'N'
AND FAQ_CATEGORY = 'U'
AND FAQ_TITLE LIKE '%은%'
;


SELECT * FROM "FAQ";

SELECT * FROM "NOTICE";

SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, TO_CHAR(NOTICE_ENROLL_DATE, 'yyyy-mm-dd')NOTICE_ENROLL_DATE, NOTICE_FL
FROM "NOTICE"
WHERE NOTICE_FL = 'N';




CREATE SEQUENCE SEQ_USER_COUPON_NO NOCACHE;
DROP SEQUENCE SEQ_USER_COUPON_NO;


CREATE OR REPLACE FUNCTION NEXT_UC_NO
RETURN NUMBER IS NEXT_NO NUMBER;
BEGIN
	SELECT SEQ_USER_COUPON_NO.NEXTVAL 
	INTO NEXT_NO
	FROM DUAL;
	RETURN NEXT_NO;
END;


SELECT NEXT_UC_NO() FROM DUAL;

SELECT * FROM QNA_IMG;


-- 비회원 문의하기 테이블 생성
CREATE TABLE "NONQNA" (
	"NONQNA_NO"	NUMBER		NOT NULL,
	"NONQNA_TITLE"	VARCHAR2(300)		NOT NULL,
	"NONQNA_CONTENT"	VARCHAR2(3000)		NOT NULL,
	"NONQNA_ENROLL_DATE"	DATE		NOT NULL,
	"NONQNA_DELETE_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"NONQNA_CHECK_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"NONQNA_CATEGORY"	CHAR(1)		NOT NULL,
	"NONQNA_TYPE"	CHAR(1)		NOT NULL,
	"NONMEMBER_NAME"	VARCHAR2(20)		NOT NULL,
	"NONMEMBER_EMAIL"	VARCHAR2(1000)		NOT NULL,
	"NONMEMBER_TEL"	CHAR(12)		NULL
);

COMMENT ON COLUMN "NONQNA"."NONQNA_NO" IS '비회원문의번호(SEQ_NON_NO)';

COMMENT ON COLUMN "NONQNA"."NONQNA_TITLE" IS '문의제목';

COMMENT ON COLUMN "NONQNA"."NONQNA_CONTENT" IS '문의내용';

COMMENT ON COLUMN "NONQNA"."NONQNA_ENROLL_DATE" IS '문의날짜';

COMMENT ON COLUMN "NONQNA"."NONQNA_DELETE_FL" IS '삭제여부(N:삭제X, Y:삭제O)';

COMMENT ON COLUMN "NONQNA"."NONQNA_CHECK_FL" IS '처리여부(N: 처리X, Y: 처리O)';

COMMENT ON COLUMN "NONQNA"."NONQNA_CATEGORY" IS '문의 분류(P:상영관, M:영화, U:멤버쉽, B:예매/결제, H:홈페이지 A:계정)';

COMMENT ON COLUMN "NONQNA"."NONQNA_TYPE" IS '문의종류(AM:영화관문의, ETC:기타문의)';

COMMENT ON COLUMN "NONQNA"."NONMEMBER_NAME" IS '비회원 이름';

COMMENT ON COLUMN "NONQNA"."NONMEMBER_EMAIL" IS '비회원 이메일';

COMMENT ON COLUMN "NONQNA"."NONMEMBER_TEL" IS '비회원 전화번호';

ALTER TABLE "NONQNA" ADD CONSTRAINT "PK_NONQNA" PRIMARY KEY (
	"NONQNA_NO"
);

CREATE SEQUENCE SEQ_NON_NO NOCACHE;


COMMIT;

SELECT * FROM NONQNA; 



-- 비회원 문의하기 이미지 테이블 생성
CREATE TABLE "NONQNA_IMG" (
	"QNA_IMG_NO"	NUMBER		NOT NULL,
	"QNA_IMG_ORDER"	NUMBER		NOT NULL,
	"QNA_IMG_PATH"	VARCHAR2(2000)		NOT NULL,
	"NONQNA_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "NONQNA_IMG"."QNA_IMG_NO" IS '이미지번호(SEQ_NONQNA_IMG_NO)';

COMMENT ON COLUMN "NONQNA_IMG"."QNA_IMG_ORDER" IS '이미지 순서';

COMMENT ON COLUMN "NONQNA_IMG"."QNA_IMG_PATH" IS '이미지 주소';

COMMENT ON COLUMN "NONQNA_IMG"."NONQNA_NO" IS '비회원문의번호(SEQ_NON_NO)';

ALTER TABLE "NONQNA_IMG" ADD CONSTRAINT "PK_NONQNA_IMG" PRIMARY KEY (
	"QNA_IMG_NO"
);


CREATE SEQUENCE SEQ_NONQNA_IMG_NO NOCACHE;

COMMIT;

SELECT * FROM NONQNA_IMG;

-- 문의하기 테이블 컬럼 추가(문의종류)
ALTER TABLE QNA ADD QNA_TYPE CHAR(1);

ALTER TABLE "QNA" DROP COLUMN QNA_TYPE;

COMMENT ON COLUMN "QNA"."QNA_CATEGORY" IS '문의 분류(P:상영관, M:영화, U:멤버쉽, B:예매/결제, H:홈페이지, A:계정, E:기타)';
COMMENT ON COLUMN "NONQNA"."NONQNA_CATEGORY" IS '문의 분류(P:상영관, M:영화, U:멤버쉽, B:예매/결제, H:홈페이지, A:계정, E:기타)';

ALTER TABLE "QNA" MODIFY (QNA_TYPE NOT NULL);

COMMIT;

SELECT * FROM "QNA";

ALTER TABLE "NONQNA" DROP COLUMN NONQNA_TYPE;

SELECT * FROM NONQNA;

-- nonQna_Img테이블 컬럼명 수정
ALTER TABLE "NONQNA_IMG" RENAME COLUMN QNA_IMG_NO TO NONQNA_IMG_NO;
ALTER TABLE "NONQNA_IMG" RENAME COLUMN QNA_IMG_ORDER TO NONQNA_IMG_ORDER;
ALTER TABLE "NONQNA_IMG" RENAME COLUMN QNA_IMG_PATH TO NONQNA_IMG_PATH;

COMMIT;

SELECT * FROM "QNA_IMG";


-- 문의 분류(P:상영관, M:영화, U:멤버쉽, B:예매/결제, H:홈페이지, A:계정, E:기타)
-- 문의글 삽입(회원일 경우)
INSERT INTO QNA VALUES(
	SEQ_USER_NO.NEXTVAL, #{qnaTitle}, #{qnaContent}, SYSDATE, DEFAULT, DEFAULT, #{qnaCategory}, ${userNo}
);


SELECT * FROM "USER_INFO";

DROP TABLE "NONQNA_IMG";

COMMIT;


-- QNA 테이블 수정(비회원 추가)

ALTER TABLE "QNA" ADD "NONMEMBER_NAME" VARCHAR2(20); 
ALTER TABLE "QNA" ADD "NONMEMBER_EMAIL" VARCHAR2(1000); 
ALTER TABLE "QNA" ADD "NONMEMBER_TEL" CHAR(12); 

COMMIT;

COMMENT ON COLUMN QNA.NONMEMBER_NAME IS '비회원 이름';
COMMENT ON COLUMN QNA.NONMEMBER_EMAIL IS '비회원 이메일';
COMMENT ON COLUMN QNA.NONMEMBER_TEL IS '비회원 전화번호';

SELECT
		Q.QNA_NO,QNA_TITLE,QNA_CONTENT,QNA_CHECK_FL,QNA_CATEGORY,QNA_ENROLL_DATE,QNA_COMMENT,USER_RATING
		FROM QNA Q
		JOIN USER_INFO U ON (U.USER_NO = USER_NO2)
		LEFT JOIN "QNA _COMMENT" C ON (Q.QNA_NO = C.QNA_NO)
		WHERE USER_NO2 = 12;

ALTER TABLE "QNA_IMG" ADD "QNA_IMG_ORIGINAL" VARCHAR2(300);
ALTER TABLE "QNA_IMG" ADD "QNA_IMG_RENAME" VARCHAR2(300);

COMMIT;

COMMENT ON COLUMN QNA_IMG.QNA_IMG_ORIGINAL IS '원본 이미지 이름';
COMMENT ON COLUMN QNA_IMG.QNA_IMG_RENAME IS '변경된 이미지 이름';

COMMIT;













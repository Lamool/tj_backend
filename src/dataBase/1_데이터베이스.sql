/* 여러 줄 주석 */
# 한 줄 주석
-- 한 줄 주석 -- 쓰고서 한 칸 띄어야 함
/* SQL질의어 */
/*
	1. 주의할점
		- sql명렁어 문장을 입력 후 ;(세미콜론) 마침, 자바와 비슷
        - 문자처리 ' ' 혹은 " "
        - 명령어/키워드에서는 대소문자 구분을 안 함, 데이터/자료는 당연히 구분 함.
	2. 실행
		- 명령어 단위 실행, 전체 실행
        - 명령어 단위 실행 : 실행 명령에게 커서 두고 ctrl+엔터, 상단 번개 모양의 I 있는
        - 전체 명령어 실행 : ctrl+shift+엔터, 상단 번개모양의 I 없는
	3. 실행 결과
		
    
	------------------------------------------------------------------------------------------------
    
    DDL (data Definition Language) 데이터 정의어
		- create database '새로운DB명';				: 데이터베이스 생성
    DDL (data Manipulation Language) 데이터 조작어
        - drop databse 삭제할DB명;					: 데이터베이스 삭제
			- drop database if exists 삭제할DB명;
		- 그 외
        show
			show databses							: DBSERVER 내 데이터베이스 목록 확인
            show variables like 'datadir'			: DBSERVER 내 데이터베이스 local 위치 확인
		use
			use 사용할데이터베이스명;						: DBSERVER 내 조작/사용 할 데이터베이스 선택
        
	DCL (data Control Language) 데이터 제어어
        
*/
# 1. 현재 DB SERVER 존재하는 데이터베이스 확인
show databases;

# 2. 현재 DB SERVER 존재하는 로컬(C:드라이브) 위치 확인
show variables like 'datadir';	#C:\ProgramData\MySQL\MySQL Server 8.0\Data\
/* ProgramData 얘 숨겨져 있으므로 숨긴 항목 체크해줘야 함 */

# 3. 현재 DB SERVER 내 데이터베이스 생성
create database myDB;

# 4. 데이터베이스 삭제
drop database mydb;

# 4-2. 만약에 해당 데이터베이스 존재하면 삭제
drop database if exists mydb;

# 5. DB SERVER에는 여러 개의 데이터베이스 존재
use mydb;



# 실습
# 1. 'test2' 이름의 데이터베이스가 존재하면 삭제하기
drop database if exists test2;

# 2. 'test2' 이름의 데이터베이스 생성 하기
create database test2;

# 3. 데이터베이스 목록 확인
show databases;

# 4. 로컬 PC에 데이터베이스가 만들어졌는지 확인하기
show variables like 'datadir';

# 5. 'test2' 데이터베이스 사용 활성화 하기
use test2;

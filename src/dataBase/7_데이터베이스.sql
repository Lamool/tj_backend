drop database if exists day06;
create database day06;
use day06;

# 1. 회원테이블
drop table if exists member;
create table member(	# 아이디, 비밀번호, 이름, 연락처, 가입일, 회원번호(pk, ai)
	mid varchar(30) not null unique,
    mpwd varchar(30) not null,
    mname varchar(20) not null,
    mphone varchar(15) not null,
    mdate datetime default now(),
    mno int auto_increment,
    primary key(mno)
);

select * from member;	-- 확인용


# 2. 게시물테이블
drop table if exists board;
create table board(		# 글제목, 글내용, 글작성일, 글작성자, 글조회수
	btitle varchar(100) not null,
    bcontent longtext,
    bdate datetime default now(),
    bview smallint default 0,
    mno int,
    bno int auto_increment,
    primary key(bno),
    foreign key(mno) references member(mno)
);

select * from board;


# 3. 댓글테이블
drop table if exists reply;
create table reply(		# 댓글내용, 댓글작성일, 댓글작성자
	rcontent varchar(200) not null,
    rdate datetime default now(),
    mno int,
    bno int,
    rno int auto_increment,
    primary key(rno),
    foreign key(mno) references member(mno),
    foreign key(bno) references board(bno)
);

select * from reply;

# ER다이어그램 확인

# 회원 5명
INSERT INTO member(mid, mpwd, mname, mphone) values('qwe1', '1234', '유재석', '010-0000-0000');
INSERT INTO member(mid, mpwd, mname, mphone) values('qwe2', '1234', '강호동', '010-1111-1111');
INSERT INTO member(mid, mpwd, mname, mphone) values('qwe3', '1234', '신동엽', '010-2222-2222');
INSERT INTO member(mid, mpwd, mname, mphone) values('qwe4', '1234', '유재석2', '010-3333-3333');
INSERT INTO member(mid, mpwd, mname, mphone) values('qwe5', '1234', '강호동2', '010-4444-4444');

# 게시물 5개
INSERT INTO board(btitle, bcontent, mno) values('제목입니다.1', '내용입니다.1', 1);	# 유재석이 쓴 글
INSERT INTO board(btitle, bcontent, mno) values('제목입니다.2', '내용입니다.2', 5);	# 강호동2이 쓴 글
INSERT INTO board(btitle, bcontent, mno) values('제목입니다.3', '내용입니다.3', 3);	# 신동엽이 쓴 글
INSERT INTO board(btitle, bcontent, mno) values('제목입니다.4', '내용입니다.4', 1);	# 유재석이 쓴 글
INSERT INTO board(btitle, bcontent, mno) values('제목입니다.5', '내용입니다.5', 5);	# 강호동2이 쓴 글

# 댓글 5개
INSERT INTO reply(rcontent, mno, bno) values('댓글내용1', 1, 1);	# 1번 게시물에 유재석이 쓴 댓글
INSERT INTO reply(rcontent, mno, bno) values('댓글내용2', 5, 1);	# 1번 게시물에 강호동2이 쓴 댓글
INSERT INTO reply(rcontent, mno, bno) values('댓글내용3', 2, 3);	# 3번 게시물에 강호동이 쓴 댓글
INSERT INTO reply(rcontent, mno, bno) values('댓글내용4', 1, 4);	# 4번 게시물에 유재석이 쓴 댓글
INSERT INTO reply(rcontent, mno, bno) values('댓글내용5', 3, 1);	# 1번 게시물에 신동엽이 쓴 댓글


# 검색
# 1. 전체 검색
SELECT * FROM member;

# 2. 조건 검색
SELECT * FROM MEMBER WHERE mno = 1;		-- mno가 '1'인 회원 레코드 검색
SELECT * FROM MEMBER WHERE mid = 'qwe1';	-- mid가 'qwe1'인 회원 레코드 검색
SELECT * FROM member WHERE mphone = '010-0000-0000';	-- mphone가 '010-0000-0000'인 회원레코드 검색

# 아이디찾기 / 비교 (회원명과 연락처가 동일한 회원 검색)
# 비교연산자 : >초과 <미만 >=이상 <=이하 =같다 !=같지않다.
# 관계연산자 : and or not 		vs	java : && || !
SELECT * FROM member where mname = '유재석' and mphone = '010-0000-0000'; 	# mysql : a = 1 and b = 2 vs java : a == 1 && b == 2
	# JDBC 매개변수 대입 : SELECT * FROM member where mname = ? and mphone = ?;

# 비밀번호찾기 / 비교 (아이디와 연락처가 동일한 회원 검색)
SELECT * FROM member where mid = 'qwe1' and mphone = '010-0000-0000';
	# JDBC 매개변수 대입 : SELECT * FROM member where mid = ? and mphone = ?;

# 로그인 / 비교 (아이디와 비밀번호가 동일한 회원 검색)
SELECT * FROM member where mid = 'qwe1' and mpwd = '1234';
	# JDBC 의 DAO SQL 작성시 : SELECT * FROM member where mid ? and mpwd = ?;


# 게시물 출력
use day06;

SELECT * FROM day06.board;

# 게시물 출력시 mno가 아닌 mid 출력
	# 1. 두 테이블을 출력한다.
select * from board, member;
    
	# 2. 두 테이블의 관계 기준으로 (내부/교집합) 조인한다.
select * from board, member where board.mno = member.mno;

select * from board natural join member;

select * from board join member on board.mno = member.mno;

select * from board join member using (mno);

select * from board inner join member on board.mno = member.mno;






use day06;

# 조회
# 1. 전체 조회
select * from board;
select * from member;

# 2. 개별 조회 (조건)
select * from board where bno = 3;	# 3번 게시물 개별 조회

# 삭제
delete from board where bno = 0;	# 0번 게시물을 삭제
# 작성자번호가 0이면서 게시물번호가 0인 게시물/레코드 삭제
delete from board where bno = 0 and mno = 0;


update member set mname = '유재석', mphone = '010-9999-9999' where mno = 4;


update board set btitle = '제목2', bcontent = '내용2' where bno = 10 and mno = 3;
use day06;

# 댓글 출력/조회
select * from reply;		# 댓글 전체 출력
select * from reply where mno = 1; # 회원번호가 '1'인 회원이 작성한 댓글들
select * from reply where bno = 1; # 게시물번호가 '1'인 게시물에 작성된 댓글들

# 댓글 쓰기
INSERT INTO reply(rcontent, mno, bno) values('댓글내용1', 2, 2);	# 2번 게시물에 회원번호 2번이 쓴 댓글



# 탈퇴
# 1. 회원번호가 '1'인 회원 삭제
delete from member where mno = 1;

# 2. 회원번호가 '1'이면서 비밀번호가 '2'인 회원 삭제
delete from member where mno = 1 and mpwd = 2;
	# delete from member where mno = ? and mpwd = ?;
    
    
    
select * from member;





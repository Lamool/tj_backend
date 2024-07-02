package day16.controller;       // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.model.dao.BoardDao;
import day16.model.dto.BoardDto;
import day16.model.dto.ReplyDto;

import java.util.ArrayList;

public class BoardController {          // BoardController 클래스 선언
    // ========== 싱글톤 만들기 ========== //
    // 싱글톤 : 프로그램내 해당 클래스의 하나의 객체만 갖는 패턴
        // 1. private static 변수에 해당 클래스의 객체 생성해서 대입
    private static BoardController bControl = new BoardController();
        // 2. 해당 클래스의 생성자를 private 한다. 다른 클래스에서 new 사용하지 못하게 차단하기
    private BoardController() {}
        // 3. 해당 객체(싱글톤)를 외부로부터 접근할 수 있도록 간접(추후에 유효성검사) 호출 메소드를 만들어야 한다
    public static BoardController getInstance() {

        // 유효성검사를 써줄 수 있다
        // 어떤 제한을 두기 위해 멤버변수 private로 해주고 getter and setter 사용

        return bControl;
    }
    // ============================== //


    // 4. 게시판(게시물 전체출력) 함수 : 매개변수 X, 반환타입 : ArrayList<BoardDto>
    public ArrayList<BoardDto> bPrint() {
        // BoardDao에게 전체 게시물 조회 요청 후 BoardView에게 반환
        return BoardDao.getInstance().bPrint();

    }


    // 5. 게시물 쓰기 함수, btitle, bcontent, *mno (작성자 회원번호 mno --> 현재 로그인된 회원번호 MemberContrller loginMno) / 반환 글쓰기 성공 여부 boolean
    public boolean bWrite(BoardDto boardDto) {
        // 매개변수로 전달받은 boardDto에 현재 로그인된 회원번호를 대입
        boardDto.setMno(MemberController.mcontrol.loginMno);
        // boardDto(제목, 내용, 작성자번호)를 BoardDao에게 전달 후 결과 받기
        return BoardDao.getInstance().bWrite(boardDto);

    }


    // 6. 게시물 개별 조회 함수
    public BoardDto bView(int bno) {
        // 해당 게시물 조회수 처리
        BoardDao.getInstance().viewIncrease(bno);
        return BoardDao.getInstance().bView(bno);

    }


    // 7. 게시물 삭제 함수
    public boolean bDelete(int bno) {
        int mno = MemberController.mcontrol.loginMno;
        return BoardDao.getInstance().bDelete(bno, mno);
    }


    // 8. 게시물 수정 함수
    public boolean bUpdate(BoardDto boardDto) {
        // 매개변수로 전달받은 boardDto에 현재 로그인된 회원번호를 대입
        boardDto.setMno(MemberController.mcontrol.loginMno);

        // boardDto(제목, 내용, 게시물번호, 로그인된 회원번호)를 BoardDao에게 전달 후 결과 받기
        return BoardDao.getInstance().bUpdate(boardDto);
    }

    // 9. 댓글 출력 함수
    public ArrayList<ReplyDto> rPrint(int bno) {
        return BoardDao.getInstance().rPrint(bno);

    }   // rPrint 함수 end

    // 10. 댓글 쓰기 함수
    public boolean rWrite(ReplyDto replyDto) {
        // 4. BoardView로부터 전달받은 ReplyDto에 로그인된 회원번호도 같이 묶어주기
        // 현재 로그인된 회원의 번호를 dto 대입, 즉) 작성자 회원번호
        replyDto.setMno(MemberController.mcontrol.loginMno);

        // 5. ReplyDto를 BoardDao에 전달하기 / BoardDao로부터 받은 반환값(댓글 쓰기 성공여부)을 BoardView에게 반환하기
        return BoardDao.getInstance().rWrite(replyDto);

    }   // rWrite 함수 end

}   // class end

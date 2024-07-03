package day16.view;             // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.controller.BoardController;
import day16.controller.MemberController;       // 다른 패키지에 속한 MemberController 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import day16.model.dto.BoardDto;
import day16.model.dto.MemberDto;               // 다른 패키지에 속한 MemberDto 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import day16.model.dto.ReplyDto;

import java.util.ArrayList;
import java.util.Scanner;           // java.util 패키지에 속한 Scanner 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드

public class BoardView {        // BoardView 클래스 선언
    // 0.
    // 접근제한자를 안 붙이면 기본이 default인데, default면 패키지 다른 경우 오류가 나서 public을 붙여주었다.
    // 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static도 써주었다.
    // BoardView 클래스의 생성자를 호출하여 객체를 생성한 뒤 주소값을 bView에 저장해준다
    public static BoardView bView = new BoardView();

    public Scanner scan = new Scanner(System.in);       // 사용자의 입력을 받기 위해 Scanner 클래스를 생성하고 초기화하는 것이다. System.in은 표준 입력 스트림을 의미한다.

    // 0. 로그인 성공시 초기화면 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void index2() {      // index2() start
        System.out.print(">> 1.로그아웃 2.회원수정 3.회원탈퇴 4.게시판 : ");   // 번호마다 어떤 기능을 수행시킬 수 있는지 알려주는 문장을 출력하는 코드
        int ch = scan.nextInt();        // Scanner를 통해 입력받은 정수값을 정수형 변수 ch에 대입하는 코드

        if (ch == 1) {                  // 만약 ch가 1이면
            logout();                       // logout 함수를 호출한다
            return;                         // index2() 함수를 종료한다
        } else if (ch == 2) {           // 만약 ch가 2면
            mUpdate();                      // mUpdate 함수를 호출한다
        } else if (ch == 3) {           // 만약 ch가 3이면
            if (mDelete()) {                // mDelete 함수를 호출한다. mDelete 반환값이 true면 logout 함수를 호출한다.
                logout();                   // 회원탈퇴를 하면 로그인된 회원번호를 비로그인 상태로 바꿔주어야 하기 때문에 logout 함수를 호출하는 것이다.
                return;                     // index2() 함수를 종료한다
            }   // else if (ch == 3) 안에 있는 if문 end
        } else if (ch == 4) {           // 만약 ch가 4면
            bprint();                       // bprint 함수를 호출한다
        } else {                        // else start
            System.out.println(">> 없는 기능 번호입니다.");      // ">> 없는 기능 번호입니다." 문장을 출력한다
        }   // else end

    }   // index2() end

    // 1. 로그아웃 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void logout() {      // logout() start
        // MemberController에 로그아웃 메소드 호출
        // MemberController 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mcontrol를 이용하여 logout()함수를 호출한다
        MemberController.mcontrol.logout();
        System.out.println(">> 로그아웃 성공 [초기메뉴로]");       // ">> 로그아웃 성공 [초기메뉴로]" 문장을 출력하고 줄바꿈 처리를 해준다
    }       // logout() end

    // 2. 회원 수정 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void mUpdate() {     // mUpdate() start
        System.out.println(">> 회원 정보 수정 페이지 <<");       // ">> 로그아웃 성공 [초기메뉴로]" 문장을 출력하고 줄바꿈 처리를 해준다
        // 수정할 회원 이름을 입력받는다
        System.out.print("수정할 회원 이름 : ");                // "수정할 회원 이름 : " 문장을 출력한다. 줄바꿈 처리 X
        String newMname = scan.next();                              // Scanner를 통해 입력받은 문자열을 String 변수 newMname에 대입하는 코드
        // 수정할 회원 연락처를 입력받는다
        System.out.print("수정할 회원 연락처 : ");              // "수정할 회원 연락처 : " 문장을 출력한다. 줄바꿈 처리 X
        String newMphone = scan.next();                             // Scanner를 통해 입력받은 문자열을 String 변수 newMphone에 대입하는 코드

        MemberDto memberDto = new MemberDto();      // MemberDto 클래스의 기본 생성자를 호출하여 객체를 생성한 뒤 주소값을 memberDto에 저장해준다.
        memberDto.setMname(newMname);               // 생성한 객체의 newMname 멤버변수를 입력받은 newMname 값으로 설정해준다
        memberDto.setMphone(newMphone);             // 생성한 객체의 newMphone 멤버변수를 입력받은 newMphone 값으로 설정해준다

        // 입력받은 값 2개(memberDto[이름, 연락처]를 MemberController에게 매개변수로 전달한다
            // MemberController 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mcontrol을 이용하여 mUpdate 함수를 호출한다
            // mUpdate 함수는 매개변수로 MemberDto(이름, 연락처)를 받고 있기에 MemberController에게 memberDto를 넘겨준다
            // boolean형으로 선언한 result 변수에 MemberController로부터 받은 반환값 회원 수정 성공 여부(true / false)를 대입한다.
        boolean result = MemberController.mcontrol.mUpdate(memberDto);
        //boolean result = MemberController.mcontrol.mUpdate(newMname, newMphone);      // memberDto로 값을 넘겨주지 않고 이렇게 변수로 값을 넘겨줄 수도 있다

        if (result) {                               // result가 true면
            System.out.println(">> 수정 성공");                // ">> 수정 성공" 문장을 출력하고 줄바꿈 처리를 해준다
        } else {                                    // result가 false면
            System.out.println(">> 수정 실패");                 // ">> 수정 실패" 문장을 출력하고 줄바꿈 처리를 해준다
        }       // else end
    }       // mUpdate() end

    // 3. 회원 탈퇴 함수 : 매개변수 X, 반환값 : 회원가입 성공 여부 boolean.
    public boolean mDelete() {      // mDelete() start
        System.out.println("[정말 탈퇴할까요?] ");         // "[정말 탈퇴할까요?] " 문장을 출력하고 줄바꿈 처리를 해준다
        System.out.print("확인 비밀번호를 입력 : ");        // "확인 비밀번호를 입력 : " 문장을 출력한다. 줄바꿈 처리 X
        String confirmPwd = scan.next();                        // Scanner를 통해 입력받은 문자열을 String 변수 confirmPwd에 대입하는 코드

        // MemberController 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mcontrol을 이용하여 mDelete 함수를 호출한다
        // mDelete 함수는 매개변수로 입력받은 비밀번호를 받고 있기에 MemberController에게 confirmPwd를 넘겨준다
        // boolean형으로 선언한 result 변수에 MemberController로부터 받은 반환값 회원 탈퇴 성공 여부(true / false)를 대입한다.
        boolean result = MemberController.mcontrol.mDelete(confirmPwd);

        if (result) {                                   // result가 true면
            System.out.println(">> 탈퇴성공");                   // ">> 탈퇴성공" 문장을 출력하고 줄바꿈 처리를 해준다
            return true;                                        // mDelete를 호출한 곳에 true를 반환한다
        } else {                                        // result가 false면
            System.out.println(">> 비밀번호 불일치");             // ">> 비밀번호 불일치" 문장을 출력하고 줄바꿈 처리를 해준다
            return false;                                       // mDelete를 호출한 곳에 false를 반환한다
        }       // else end
    }       // mDelete() end

    // 4. 게시판(게시물전체출력) 함수
    public void bprint() {      // bprint() start
        // BoardController에게 전체 게시물 조회 요청
        ArrayList<BoardDto> result = BoardController.getInstance().bPrint();

        System.out.println("번호\t조회수\t작성일\t\t\t작성자\t제목");
        // 리스트객체명.forEach( 반복변수 -> { 실행문; } );       // 리스트내 전체 dto를 하나씩 반복변수에 대입 반복
        result.forEach(dto -> {
            System.out.printf("%2d\t%2d\t%10s\t%10s\t%s \n", dto.getBno(), dto.getBview(), dto.getBdate(), dto.getMid(), dto.getBtitle());
        });

        System.out.print("-1.제목검색 0.글쓰기 1~.개별글(번호)조회 : ");
        int ch = scan.nextInt();
        if (ch == 0) {
            bWrite();
        } else if (ch >= 1) {
            bView(ch);
        } else if (ch == -1) {
            search();
        }

    }   // bprint() end


    // 5. 게시물 쓰기 함수, btitle, bcontent
    public void bWrite() {
        // 1. btitle , bcontent 입력받기
        scan.nextLine();
        System.out.print("제목 : ");
        String btitle = scan.nextLine();
        System.out.print("내용 : ");
        String bcontent = scan.nextLine();

        // 2. 입력받은 값들을 객체의 각각 매개변수에 값 대입
        BoardDto boardDto = new BoardDto();
        boardDto.setBtitle(btitle);
        boardDto.setBcontent(bcontent);

        // 3. 입력받은 객체를 컨트롤에게 전달 후 결과 응답 받기
        boolean result = BoardController.getInstance().bWrite(boardDto);
        if (result) {
            System.out.println(">> 글작성 성공");
        } else {
            System.out.println("글작성 실패");
        }

    }


    // 6. 게시물 개별 조회 함수
    public void bView(int bno) {
        // 매개변수로 선택 받은 게시물을 번호를 컨트롤에게 전달 후 해당 게시물 정보 얻기
        BoardDto result = BoardController.getInstance().bView(bno);

        if (result == null) {
            System.out.println(">> 존재하지 않는 게시물입니다");
            return;
        }

        System.out.println("제목 : " + result.getBtitle());
        System.out.println("작성자 : " + result.getMno());
        System.out.println("\t조회수 : " + result.getBview());
        System.out.println("작성일 : " + result.getBdate());
        System.out.println("내용 : " + result.getBcontent());

        // -------- 댓글 출력 -------- //
        rPrint(bno);
        // -------------------------- //

        System.out.print(">> 0.뒤로가기 1.삭제 2.수정 3. 댓글쓰기 : ");
        int ch = scan.nextInt();

        if (ch == 1) {
            bDelete(bno);
        } else if (ch == 2) {
            bUpdate(bno);
        } else if (ch == 3) {
            rWrite(bno);
        } else if (ch == 0) {
            return;
        }
    }


    // 7. 게시물 삭제 함수
    public void bDelete(int bno) {
        boolean result = BoardController.getInstance().bDelete(bno);
        if (result) {
            System.out.println(">> 삭제 성공");
        } else {
            System.out.println(">> 삭제 실패");
        }
    }


    // 8. 게시물 수정 함수
    public void bUpdate(int bno) {
        // 1. newBtitle , newBcontent 입력받기
        scan.nextLine();
        System.out.print("새로운 제목 : ");
        String newBtitle = scan.nextLine();
        System.out.print("새로운 내용 : ");
        String newBcontent = scan.nextLine();

        // 2. 입력받은 값들을 객체의 각각 매개변수에 값 대입
        BoardDto boardDto = new BoardDto();
        boardDto.setBtitle(newBtitle);
        boardDto.setBcontent(newBcontent);
        boardDto.setBno(bno);

        // 3. 입력받은 객체를 컨트롤에게 전달 후 결과 응답 받기
        boolean result = BoardController.getInstance().bUpdate(boardDto);

        if (result) {
            System.out.println(">> 수정 성공");
        } else {
            System.out.println(">> 수정 실패");
        }

    }   // bUpdate 함수 end

    // 9. 댓글 출력 함수, 게시물번호를 넘겨주고 / ArrayList<ReplyDto>를 받아온다
    public void rPrint(int bno) {
        ArrayList<ReplyDto> result = BoardController.getInstance().rPrint(bno);

        // 리스트객체명.forEach( 반복변수 -> { 실행문; } );       // 리스트내 요소들을 하나씩 반복변수에 대입 반복 처리
            // 리스트내 요소들을 하나씩 반복변수에 대입 반복 처리
        System.out.println("-----------------댓글-----------------");
        System.out.println("작성일\t\t\t작성자\t제목");
        result.forEach(reply -> {
            System.out.printf("%s %s %s \n", reply.getRdate(), reply.getMid(), reply.getRcontent());
        });

    }   // rPrint 함수 end

    // 10. 댓글 쓰기 함수, 게시물번호, 댓글내용을 넘겨주고 (Controller에서는 로그인된 회원번호를 추가로 넘겨주기 / 댓글 작성 성공 여부를 받아온다
    public void rWrite(int bno) {
        // 만약에 코드 상황 상 로그인 후 댓글쓰기가 아니었다면
            // 로그인상태를 확인 후 댓글 쓰기 진행
        if (MemberController.mcontrol.loginState()) {
            System.out.println(">> 로그인 후 가능합니다.");
            return;
        }

        // 1. 댓글 내용 입력 받기
        // 위에서 next() 후 엔터 쳤을 때 scan객체에 엔터/개행 기록이 남아있기 때문에 nextLine() 인식해서 입력했다는 걸로 간주
        // 해결방안 : next() nextLine() 사이에 의미 없는 scan.nextLine(); 코드 작성
        scan.nextLine();
        System.out.print("댓글 내용 : ");
        String rcontent = scan.nextLine();

        // 2. ReplyDto로 묶기
        ReplyDto replyDto = new ReplyDto();
        replyDto.setBno(bno);
        replyDto.setRcontent(rcontent);

        // 3. ReplyDto를 BoardController에게 전달하기 / 반환값을 result에 대입
        boolean result = BoardController.getInstance().rWrite(replyDto);

        // . BoardController로부터 받은 댓글 쓰기 성공 여부에 따라 문구 출력
        if (result) {
            System.out.println(">> 댓글 작성 성공");
        } else {
            System.out.println(">> 댓글 작성 실패");
        }

    }   // rWrite 함수 end


    // 12. 제목 검색 함수
    public void search() {
        // 1. 검색할 키워드를 입력받는다
        scan.nextLine();
        System.out.print(">> 제목 검색 : ");
        String searchTitle = scan.nextLine();

        // 2. 입력받은 값(String)을 BoardController에게 넘겨주기, ArrayList<BoardDto> 반환 받기
        ArrayList<BoardDto> result = BoardController.getInstance().search(searchTitle);

        // 게시물 출력
        if (result.isEmpty()) {
            System.out.println("찾는 게시물이 없습니다.");
        } else {
            System.out.println("번호\t조회수\t작성일\t\t\t작성자\t제목");
            // 리스트객체명.forEach( 반복변수 -> { 실행문; } );       // 리스트내 전체 dto를 하나씩 반복변수에 대입 반복
            result.forEach(dto -> {
                System.out.printf("%2d\t%2d\t%10s\t%10s\t%s \n", dto.getBno(), dto.getBview(), dto.getBdate(), dto.getMid(), dto.getBtitle());
            });
        }


    }   // search() end


}   // class end




/*

    [ 모든 글 출력 ] 글 1개 당 --> 레코드 1개 --> DTO 1개 --> 모든 글 --> 레코드 여러 개 --> DTO 여러 개 --> ArrayList<DTO>
    V       C       DAO
        x    ->    x
               <-  DTO 1개는 안 됨
                   ArrayList<DTO>

    [ 개별 글 출력 ] 글 1개 당 --> 레코드 1개 --> DTO 1개
    V       C       DAO
        게시물번호    -> 게시물번호
        BoardDto   <-  BoardDto




                   V                          C                               DAO
    [ 댓글 출력 ]
                       bno                           bno
                       ArrayList<ReplyDto>           ArrayList<ReplyDto>

    [ 댓글 쓰기 ]
                       rcontent bno                  rcontent bno mno(현재 로그인된 회원번호)
                       boolean                       boolean


    -------------------------------------------------------------------------------------------








*/
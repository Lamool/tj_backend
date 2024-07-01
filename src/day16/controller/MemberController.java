package day16.controller;           // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.model.dao.MemberDao;       // 다른 패키지에 속한 MemberDao 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import day16.model.dto.MemberDto;       // 다른 패키지에 속한 MemberDto 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드

public class MemberController {     // MemberController 클래스 선언
    // 0.
    // 접근제한자를 안 붙이면 기본이 default인데, default면 패키지 다른 경우 오류가 나서 public을 붙여주었다.
    // 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static도 써주었다.
    // MemberController 클래스의 생성자를 호출하여 객체를 생성한 뒤 주소값을 mcontrol에 저장해준다
        // 만약 이걸 지우고서 다른 곳에 new 해주게 되면
        // 멤버변수는 객체마다이기 때문에 loginMno(공유해서 사용하는 애)가 각각 생성됨.
        // 그래서 이렇게 미리 만들어주는 것. 서로 다른 곳에서 Controller 호출하면 같은 loginMno를 가리킨다
    public static MemberController mcontrol = new MemberController();

    // 1. 회원가입 화면 함수, 매개변수 : MemberDto(아이디 String, 비번 String, 이름 String, 전화번호 String), 반환값 : 회원가입 성공 여부 boolean
    public boolean signup(MemberDto memberDto) {        // signup 함수 start

        // MemberDao 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mdao를 이용하여 signup 함수를 호출한다
        // signup 함수는 매개변수로 MemberDto(아이디 String, 비번 String, 이름 String, 전화번호 String)를 받고 있기에 MemberView에게 매개변수로 받은 memberDto를 넘겨준다
        // boolean형으로 선언한 result 변수에 MemberDao로부터 받은 반환값 회원가입 성공 여부(true / false)를 대입한다.
        boolean result = MemberDao.mdao.signup(memberDto);
        return result;      // MemberView에 회원가입 성공 여부가 담겨있는 result 변수를 반환해준다
    }   // signup 함수 end

    // 2-1. 로그인 성공한 회원의 번호 저장하는 멤버변수
        // 글쓰기, 댓글쓰기 할 때 현재 로그인된 회원을 식별하기 위해서
        // 초기값 : 0 비로그인상태, 1 ~ : 로그인된 회원번호(로그인된상태)
    public int loginMno = 0;

    // 2-2. 로그아웃 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void logout() {      // logout 함수 start
        loginMno = 0;       // loginMno 값이 0일 때 비로그인상태라고 정해두었기에 로그아웃 함수를 호출하면 loginMno 값을 0으로 바꿔준다.
    }   // logout 함수 end

    // 2. 로그인 화면 함수 ㅡ 매개변수 : MemberDto(아이디, 비밀번호), 리턴값 : boolean (성공 / 실패)
    public boolean login(MemberDto memberDto) {     // login 함수 start
        // MemberDao 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mdao를 이용하여 login 함수를 호출한다
        // login 함수는 매개변수로 MemberDto(아이디, 비밀번호)를 받고 있기에 MemberView에게 매개변수로 받은 memberDto를 넘겨준다
        // int형으로 선언한 loginMno 변수에 MemberDao로부터 받은 반환값 회원번호를 대입한다.
        loginMno = MemberDao.mdao.login(memberDto);

        return loginMno == 0 ? false : true;    // loginMno가 0이면 false, 0이 아니면 true를 MemberView에 반환한다
    }   // login 함수 end


    // 3. 아이디찾기 화면 함수, 매개변수 : MemberDto(이름, 전화번호), 리턴값 : String (찾은 아이디 / null) - 찾았으면 문자열이 들어있고 못찾았으면 null 대입
    public String findId(MemberDto memberDto) {     // findId 함수 start
        // MemberDao 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mdao를 이용하여 findId 함수를 호출한다
        // findId 함수는 매개변수로 MemberDto(이름, 전화번호)를 받고 있기에 MemberView에게 매개변수로 받은 memberDto를 넘겨준다
        // MemberView에 MemberDao로부터 받은 반환값 찾은 아이디 또는 null을 반환한다.
        return MemberDao.mdao.findId(memberDto);
    }   // findId 함수 end

    // 4. 비밀번호찾기 화면 함수, 매개변수 : MemberDto(아이디, 전화번호), 리턴값 : String (찾은 비밀번호 / null) - 찾았으면 문자열이 들어있고 못찾았으면 null 대입
    public String findPwd(MemberDto memberDto) {        // findPwd 함수 start
        // MemberDao 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mdao를 이용하여 findPwd 함수를 호출한다
        // findPwd 함수는 매개변수로 MemberDto(아이디, 전화번호)를 받고 있기에 MemberView에게 매개변수로 받은 memberDto를 넘겨준다
        // MemberView에 MemberDao로부터 받은 반환값 찾은 비밀번호 또는 null을 반환한다.
        return MemberDao.mdao.findPwd(memberDto);
    }   // findPwd 함수 end

    // 5. 회원탈퇴 함수, 매개변수 : 입력받은 비밀번호 String, 리턴값 : 회원탈퇴 성공 여부 boolean
    public boolean mDelete(String confirmPwd) {         // mDelete 함수 start
        // MemberDao 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mdao를 이용하여 mDelete 함수를 호출한다
        // mDelete 함수는 매개변수로 입력받은 비밀번호, 로그인된 회원번호를 받고 있기에 confirmPwd, loginMno를 넘겨준다
        // boolean형으로 선언한 result 변수에 MemberDao로부터 받은 회원 탈퇴 성공 여부(true / false)를 대입한다.
        boolean result = MemberDao.mdao.mDelete(confirmPwd, loginMno);

        return result;      // BoardView에 회원 탈퇴 성공 여부가 담겨있는 result 변수를 반환해준다
    }   // mDelete 함수 end

    // 2. 회원수정 함수, 매개변수 : MemberDto(이름, 연락처), 리턴값 : 회원 수정 성공 여부 boolean
    public boolean mUpdate(MemberDto memberDto) {       // BoardView에게 매개변수로 수정할 memberDto[이름, 연락처] 받는다
        memberDto.setMno(loginMno);     // memberDto에 loginMno 값도 추가해준다
        // MemberDao 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mdao를 이용하여 mUpdate 함수를 호출한다
        // mUpdate 함수는 매개변수로 MemberDto(이름, 연락처)를 받고 있기에 BoardView에게 매개변수로 받은 memberDto를 넘겨준다
        // BoardView에 MemberDao로부터 받은 반환값 회원 수정 성공 여부(true / false)를 반환한다.
        return MemberDao.mdao.mUpdate(memberDto);

    }   // login 함수 end

}   // class end

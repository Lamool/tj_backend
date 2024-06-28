package day16.view;             // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.controller.MemberController;       // 다른 패키지에 속한 MemberController 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import day16.model.dto.MemberDto;               // 다른 패키지에 속한 MemberDto 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드

import java.util.InputMismatchException;        // java.util 패키지에 속한 InputMismatchException 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import java.util.Scanner;                       // java.util 패키지에 속한 Scanner 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드

public class MemberView {       // MemberView 클래스 선언
    // 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static을 써줌
    // ((접근제한자 안 붙이면 기본이 default임. 패키지 다른 경우 default면 오류나서 public 붙여준 것))
    // MemberView 클래스의 생성자를 호출하여 객체를 생성한 뒤 주소값을 mView에 저장해준다
    public static MemberView mView = new MemberView();

    // 멤버변수 : 입력객체
    Scanner scan = new Scanner(System.in);      // 사용자의 입력을 받기 위해 Scanner 클래스를 생성하고 초기화하는 것이다. System.in은 표준 입력 스트림을 의미한다.

    // 0. 초기화면 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void index() {       // index() start
        while(true) {   // while문은 반복문을 수행할 때 사용하는 것으로 ()에 true 값을 넣어주었기 때문에 {} 안에 있는 실행문들이 무한반복하여 실행된다.
            try {       // 예외가 발생 하거나 발생 할 것 같은 코드를 포함하고 있는데 만약 실행 도중 예외가 발생한다면 프로그램의 제어를 catch 블록으로 넘긴다.
                System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : ");   // 번호마다 어떤 기능을 수행시킬 수 있는지 알려주는 문장을 출력하는 코드
                int ch = scan.nextInt();    // Scanner를 통해 입력받은 정수값을 정수형 변수 ch에 대입하는 코드

                if (ch == 1) {          // 만약 ch가 1이면
                    signup();               // signup 함수를 호출한다
                } else if (ch == 2) {   // 만약 ch가 2면
                    login();                // login 함수를 호출한다
                } else if (ch == 3) {   // 만약 ch가 3이면
                    findId();               // findId 함수를 호출한다
                } else if (ch == 4) {   // 만약 ch가 4면
                    findPw();               // findPw 함수를 호출한다
                } else {                // 만약 ch가 위 조건들을 다 해당하지 않는다면
                    System.out.println(">> 없는 기능 번호입니다.");      // ">> 없는 기능 번호입니다." 문장을 출력한다
                }   // else end
            } catch (InputMismatchException e) {    // try 블록에서 InputMismatchException 예외가 발생했을 때 실행될 코드를 정의한 곳이다
                                                    // InputMismatchException은 사용자 입력과 예상한 형식이 일치하지 않을 때 발생할 수 있는 예외이다
                System.out.println(">> 잘못된 입력이 있습니다. 초기메뉴로" + e);   // ">> 잘못된 입력이 있습니다. 초기메뉴로" 문장과 예외 메시지를 출력한다
                scan = new Scanner(System.in);      // scan변수를 Scanner 클래스의 새로운 인스턴스로 초기화한다
            }   // catch end

        }   // while end
    }   // index() end

    // 1. 회원가입 화면 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void signup() {      // signup() start
        // 1. 입력
        System.out.println(" >> 회원가입 페이지 << ");     // " >> 회원가입 페이지 << " 문장을 출력하고 줄바꿈 처리를 해준다
        System.out.print("아이디 : ");                    // "아이디 : " 문장을 출력한다. 줄바꿈 처리 X
        String mid = scan.next();                            // Scanner를 통해 입력받은 문자열을 String 변수 mid에 대입하는 코드
        System.out.print("비밀번호 : ");        // "비밀번호 : " 문장을 출력한다. 줄바꿈 처리 X
        String mpwd = scan.next();                  // Scanner를 통해 입력받은 문자열을 String 변수 mpwd에 대입하는 코드
        System.out.print("이름 : ");           // "이름 : " 문장을 출력한다. 줄바꿈 처리 X
        String mname = scan.next();                 // Scanner를 통해 입력받은 문자열을 String 변수 mname에 대입하는 코드
        System.out.print("전화번호 : ");        // "전화번호 : " 문장을 출력한다. 줄바꿈 처리 X
        String mphone = scan.next();                // Scanner를 통해 입력받은 문자열을 String 변수 mphone에 대입하는 코드

        // 2. 유효성 검사

        // 3. 객체화
        // MemberDto 클래스의 회원가입용 생성자를 호출하여 객체를 생성한 뒤 주소값을 memberDto에 저장해준다.
        // 회원가입용 생성자는 매개변수로 아이디, 비밀번호, 이름, 전화번호를 갖고 있어 () 안에 해당하는 값을 적어줘서 넘겨준다
        MemberDto memberDto = new MemberDto(mid, mpwd, mname, mphone);
        // 4. Controller에게 전달
        // MemberController 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mcontrol을 이용하여 signup 함수를 호출한다
        // signup 함수는 매개변수로 MemberDto(아이디 String, 비번 String, 이름 String, 전화번호 String)를 받고 있기에 MemberController에게 memberDto를 넘겨준다
        // boolean형으로 선언한 result 변수에 MemberController로부터 받은 반환값 회원가입 성공 여부(true / false)를 대입한다.
        boolean result = MemberController.mcontrol.signup(memberDto);

        if (result) {                                   // result가 true면
            System.out.println(">> 회원가입 성공");           // ">> 회원가입 성공" 문장을 출력하고 줄바꿈 처리를 해준다
        } else {                                        // result가 false면
            System.out.println(">> 회원가입 실패");           // ">> 회원가입 실패" 문장을 출력하고 줄바꿈 처리를 해준다
        }   // else end
    }   // signup() end

    // 2. 로그인 화면 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void login() {       // login() start
        System.out.print("아이디 : ");         // "아이디 : " 문장을 출력한다. 줄바꿈 처리 X
        String mid = scan.next();                   // Scanner를 통해 입력받은 문자열을 String 변수 mid에 대입하는 코드
        System.out.print("비밀번호 : ");       // "비밀번호 : " 문장을 출력한다. 줄바꿈 처리 X
        String mpwd = scan.next();                  // Scanner를 통해 입력받은 문자열을 String 변수 mpwd에 대입하는 코드

        // MemberDto 클래스의 기본 생성자를 호출하여 객체를 생성한 뒤 주소값을 memberDto에 저장해준다.
        MemberDto memberDto = new MemberDto();
        memberDto.setMid(mid);      // 생성한 객체의 mid 멤버변수를 입력받은 mid 값으로 설정해준다
        memberDto.setMpwd(mpwd);    // 생성한 객체의 mpwd 멤버변수를 입력받은 mpwd 값으로 설정해준다

        // MemberController 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mcontrol을 이용하여 login 함수를 호출한다
        // login 함수는 매개변수로 MemberDto(아이디, 비밀번호)를 받고 있기에 MemberController에게 memberDto를 넘겨준다
        // boolean형으로 선언한 result 변수에 MemberController로부터 받은 반환값 로그인 성공 여부(true / false)를 대입한다.
        boolean result = MemberController.mcontrol.login(memberDto);

        if (result) {                               // result가 true면
            System.out.println("로그인 성공");           // "로그인 성공" 문장을 출력하고 줄바꿈 처리를 해준다
            BoardView.bView.index2();                   // 로그인 성공시 BoardView 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 bView를 이용하여 index2()함수를 호출한다
        } else {                                    // result가 false면
            System.out.println("로그인 실패");           // "로그인 실패" 문장을 출력하고 줄바꿈 처리를 해준다
        }
    }   // login() end

    // 3. 아이디찾기 화면 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void findId() {       // findId() start
        System.out.print("이름 : ");          // "이름 : " 문장을 출력한다. 줄바꿈 처리 X
        String mname = scan.next();                 // Scanner를 통해 입력받은 문자열을 String 변수 mname에 대입하는 코드
        System.out.print("연락처 : ");        // "연락처 : " 문장을 출력한다. 줄바꿈 처리 X
        String mphone = scan.next();                // Scanner를 통해 입력받은 문자열을 String 변수 mphone에 대입하는 코드

        // MemberDto 클래스의 기본 생성자를 호출하여 객체를 생성한 뒤 주소값을 memberDto에 저장해준다.
        MemberDto memberDto = new MemberDto();
        memberDto.setMname(mname);        // 생성한 객체의 mname 멤버변수를 입력받은 mname 값으로 설정해준다
        memberDto.setMphone(mphone);      // 생성한 객체의 mphone 멤버변수를 입력받은 mphone 값으로 설정해준다

        // MemberController 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mcontrol을 이용하여 findId 함수를 호출한다
        // findId 함수는 매개변수로 MemberDto(이름, 전화번호)를 받고 있기에 MemberController에게 memberDto를 넘겨준다
        // String으로 선언한 result 변수에 MemberController로부터 받은 반환값 찾은 아이디 또는 null을 대입한다.
        String result = MemberController.mcontrol.findId(memberDto);

        if (result != null) {                                   // result가 null이 아니면
            System.out.println("회원 아이디 : " + result);           // "회원 아이디 : " 문장과 result 값을 출력하고 줄바꿈 처리를 해준다
        } else {                                                // result가 null이면
            System.out.println("동일한 회원정보가 없습니다.");         // "동일한 회원정보가 없습니다." 문장을 출력하고 줄바꿈 처리를 해준다
        }       // else end

    }       // findId() end

    // 4. 비밀번호찾기 화면 함수 : 매개변수 X, 반환타입은 void로 리턴할 값이 없을 때 써준다.
    public void findPw() {       // findPw() start
        System.out.print("아이디 : ");         // "아이디 : " 문장을 출력한다. 줄바꿈 처리 X
        String mid = scan.next();                   // Scanner를 통해 입력받은 문자열을 String 변수 mid에 대입하는 코드
        System.out.print("연락처 : ");         // "연락처 : " 문장을 출력한다. 줄바꿈 처리 X
        String mphone = scan.next();                // Scanner를 통해 입력받은 문자열을 String 변수 mphone에 대입하는 코드

        // MemberDto 클래스의 기본 생성자를 호출하여 객체를 생성한 뒤 주소값을 memberDto에 저장해준다.
        MemberDto memberDto = new MemberDto();
        memberDto.setMid(mid);              // 생성한 객체의 mid 멤버변수를 입력받은 mid 값으로 설정해준다
        memberDto.setMphone(mphone);        // 생성한 객체의 mphone 멤버변수를 입력받은 mphone 값으로 설정해준다

        // MemberController 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mcontrol을 이용하여 findPwd 함수를 호출한다
        // findPwd 함수는 매개변수로 MemberDto(아이디, 전화번호)를 받고 있기에 MemberController에게 memberDto를 넘겨준다
        // String으로 선언한 result 변수에 MemberController로부터 받은 반환값 찾은 비밀번호 또는 null을 대입한다.
        String result = MemberController.mcontrol.findPwd(memberDto);

        if (result != null) {                                   // result가 null이 아니면
            System.out.println("회원 비밀번호 : " + result);          // "회원 비밀번호 : " 문장과 result 값을 출력하고 줄바꿈 처리를 해준다
        } else {                                                // result가 null이면
            System.out.println("동일한 회원정보가 없습니다.");          // "동일한 회원정보가 없습니다." 문장을 출력하고 줄바꿈 처리를 해준다
        }   // else end

    }   // findPw() end

}   // class end

package day16;                      // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.view.MemberView;       // 다른 패키지에 속한 MemberView 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드

public class AppStart {             // AppStart 클래스 선언
    public static void main(String[] args) {        // main 함수
        MemberView.mView.index();       // MemberView 클래스에 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수인 mView를 이용하여 index()함수를 호출한다

    }   // main end
}   // class end

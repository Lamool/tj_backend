package day06.step6;

import java.util.Scanner;

public class Step6 {
    /*
        실습 [ step6 패키지 ]
            [ 요구사항 ]
            1. 기능이 무한적으로 반복되도록 구현
                - 단 종료 버튼/입력 선택시 종료
            2. 기능 : 예금, 출금, 잔고확인, 종료
                예금 : 입력받은 금액을 예금액에 더한다.
                출금 : 입력받은 금액을 예금액에서 빼기.
                잔고 : 현재 예금액을 확인
                종료 : 무한반복 종료/프로그램 종료
            3. 메뉴 : 1. 예금  2. 출금  3. 잔고확인  4. 종료
            4. 설계
                Account 클래스 정의
                    - balance : 예금액
                    - number : 계좌번호
                Stemp6 클래스
                    - main함수
    */
    //print 많이 찍기

    public static void main(String[] args) {
        // 1. 입력 객체 : 입력 기능( .next() )을 사용하기 위해 객체를 만드는 것
            // .next() 관련된 기능을 scanner 객체가 가지고 있으니까
        Scanner scanner = new Scanner(System.in);

        int balance = 0;
        String number = "123-123";

        // 1. 객체 생성
        Account myAccount = new Account();

        // 2. 객체 내 필드/멤버변수에 값 대입
        myAccount.balance = 0;
        myAccount.number = "123-123";

        while (true) {      // 무한반복
            // 출력
            System.out.println("===============================================");
            System.out.print("메뉴 : 1. 예금  2. 출금  3. 잔고확인  4. 종료 : ");

            // 입력
            int ch = scanner.nextInt();
            System.out.println("ch = " + ch);

            // 3. 입력값에 따른 서로 다른 로직 처리(조건문)
            if (ch == 1) {      // 만약에 내가 입력한 값이 1 이면 예금처리
                System.out.println("예금처리");
                System.out.print("예금할 금액 입력 : ");
                int money = scanner.nextInt();
//                System.out.println("money = " + money);
                myAccount.balance += money;
//                System.out.println("balance = " + balance);
            } else if (ch == 2) {       // 만약에 내가 입력한 값이 2 이면 출금처리
                System.out.println("출금처리");
                System.out.print("출금할 금액 입력 : ");
                int money = scanner.nextInt();
                myAccount.balance -= money;
            } else if (ch == 3) {       // 만약에 내가 입력한 값이 3 이면 잔고확인처리
                System.out.println("잔고확인처리");
                System.out.println("balance = " + myAccount.balance);
            } else if (ch == 4) {       // 만약에 내가 입력한 값이 4 이면 종료
                System.out.println("종료");
                break;
            } else {
                System.out.println("알 수 없는 번호입니다.");
            }

        }   // while end
    }   // main end
}   // class end




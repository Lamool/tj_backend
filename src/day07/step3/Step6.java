package day07.step3;

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


    public static void main(String[] args) { // main s

        // 1. 입력 객체 : 입력기능( .next() )을 사용하려고
        // .next() 관련된 기능을 scanner 객체가 가지고 있으니까

        Scanner scanner = new Scanner(System.in);

        // 1. 생성자를 이용한 객체의 초기값 대입
        Account myAccount = new Account(0, "123-123");

        // 2. 디폴트 생성자를 이용한 객체 생성후 멤버변수의 값 대입
        //Account myAccount = new Account();
        //myAccount.balance = 0;
        //myAccount.number = "123-123";

        while ( true ){ // w s : 무한반복
            // 출력
            System.out.println("==============================");
            System.out.print("1.예금 2.출금 3.잔고 4.종료 : ");

            // 입력
            int ch = scanner.nextInt();     System.out.println("ch = " + ch);

            // 3. 입력값에 따른 서로 다른 로직 처리 ( 조건문 )
            if( ch ==1 ){
                System.out.println("예금처리");     System.out.print("예금할 금액 입력 : ");
                int money = scanner.nextInt();
                myAccount.setBalance(myAccount.getBalance() + money);
            } // 만약에 내가 입력한 값이 1 이면 예금처리
            else if( ch==2 ){
                System.out.println("출금처리");     System.out.print("출금할 금액 입력 : ");
                int money = scanner.nextInt();
                myAccount.setBalance(myAccount.getBalance() - money);
            }  // 만약에 내가 입력한 값이 2 이면 출금처리
            else if( ch==3 ){
                System.out.println("잔고확인처리");
                System.out.println(myAccount.getBalance());
            } // 만약에 내가 입력한 값이 3 이면 잔고확인처리
            else if( ch==4 ){
                System.out.println("종료");
                break;
            } // 만약에 내가 입력한 값이 4 이면 종료
            else{
                System.out.println("알수없는 번호 입니다.");
            } // 그외

        } // w end
    } // main e
}




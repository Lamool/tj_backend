package day06.step5;

import java.util.Scanner;

public class step5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int speed = 0;  // 속도변수 선언하고 0으로 초기화
//        String color = "빨강";
//        String carNumber = "250가4471";
        // 변수 3개 대신에 'Car' 클래스/설계도를 정의하기
        // 정의한 'Car' 클래스로 객체 생성
        Car myCar = new Car();              // 객체 생성
        myCar.speed = 0;                    // 객체내 멤버변수/필드에 값 대입
        myCar.color = "빨강";                // 객체내 멤버변수/필드에 값 대입
        myCar.carNumber = "250가4471";      // 객체내 멤버변수/필드에 값 대입

        // 2. 무한루프
        while(true) {
            // 출력함수
            System.out.println("------------------------------");
            System.out.print(">>> 1. 증속 2. 감속 3. 중지 : ");

            // 입력함수 이용해서 키보드로분터 입력받은 값을 정수형으로 반환해서 변수에 저장
            int ch = scanner.nextInt();

            // 조건문
            if (ch == 1) {
                myCar.speedFast();
            } else if (ch == 2) {
                myCar.speedSlow();
            } else if (ch == 3) {
                myCar.stop();
                break;      // 가장 가까운 반복문, switch문 {}을 탈출/끝내기
            } else {
                myCar.error();
            }


        }

    }

}

package day06.step5;

public class Car {
    int speed;
    String color;
    String carNumber;

    public void speedFast() {
        speed++;// 속도 1 증가
        System.out.println("> 증속(속도 증가) 현재속도 : " + speed);
    }

    public void speedSlow() {
        speed--;    // 속도 1 감소
        System.out.println("> 감속(속도 감소) 현재속도 : " + speed);
    }

    public void stop() {
        System.out.println("> 중지");
        speed = 0;  // 속도 0으로 변경
    }

    public void error() {
        System.out.println("> 알 수 없는 입력번호입니다.");
    }
}

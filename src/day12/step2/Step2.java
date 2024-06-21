package day12.step2;

public class Step2 {
    public static void main(String[] args) {

        Car car = new Car();
        car.speedUp();      // 함수호출
        car.speedUp();
        System.out.println("car : " + car.speed);   // 2
        // System.out.println("car : " + car.power);

        SportCar sportCar = new SportCar();
        sportCar.speedUp();
        System.out.println("SportCar : " + sportCar.speed);     // 1
        System.out.println("SportCar : " + sportCar.power);

        Car car2 = new Car();
        car2.speedUp();
        System.out.println("car2 : " + car2.speed);     // 1

    }

}


/*
    - Category Add, Category List 구현 코드에서 사용되는 지역변수, static변수, 멤버변수, 객체들이 저장되는 구역 찾기
    - 위 함수에서 사용되는 코드들의 JVM들의 분지어 PPT/캔바로 표현
    - ArrayList 포함
*/

package day06.step3;

public class Step3 {
    public static void main(String[] args) {

        // 1. 첫 번째 객체 생성
        Phone p1 = new Phone();
            // 1. 클래스명
            // 2. 변수명
            // 3. 대입
            // 4. new 연산자
            // 5. 생성자명(),       생성자명과 클래스명 동일

        // 1. 두 번째 객체 생성
        Phone p2 = new Phone();

        // 2. 객체의 멤버(필드/메소드) 접근/참조하기
            // 객체 안에 들어가서 객체가 가지고 있는 것들을 사용
        p1.name = "갤럭시23";
        System.out.println(p1.name);

        p1.전화걸기();

        p2.name = "갤럭시24";
        System.out.println(p2.name);

        p2.전화걸기();


        // ======================================= //

        // [실습]
        // 1. 생활속 객체를 구성해서 클래스 정의/만들기
        // 2. 위에서 만든 클래스를 이용한 객체 생성
            // - 2개 이상의 객체 생성
            // 각 객체의 멤버변수/필드에 임의값 대입하는 코드
            // 각 객체의 멤버변수/필드 값 호출하고 출력하는 코드
            // 각 멤버함수를 호출하는 코드

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.shape = "직육면체";
        cart1.x = 20;
        cart1.y = 10;
        cart1.z = 10;

        System.out.println(cart1.shape);
        System.out.println(cart1.x);
        System.out.println(cart1.y);
        System.out.println(cart1.z);

        cart1.move();
        cart1.put();


        cart2.shape = "정육면체";
        cart2.x = 30;
        cart2.y = 30;
        cart2.z = 30;

        System.out.println(cart2.shape);
        System.out.println(cart2.x);
        System.out.println(cart2.y);
        System.out.println(cart2.z);

        cart2.move();
        cart2.put();

    }

}

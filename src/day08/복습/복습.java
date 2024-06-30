package day08.복습;

public class 복습 {
    public static void main(String[] args) {
        /*
            데이터 자료 저장
                - 리터럴 , 객체 를 저장
                - 자료형 변수명 = 리터럴 혹은 객체 혹은 메소드반환값
        */

        // 1. 회원정보의 이름, 나이 1명 저장
        String name = "유재석";
        int age = 40;
            // vs
        회원 m1 = new 회원();
        m1.name = "유재석";
        m1.age = 40;

        // 2. 100명 저장해주세요.
            // name 변수와 age 변수를 x100 생성
            // 가능하지만. 변수가 많아지면 관리가 힘들다.
            // 붕어빵 만들기 위해 붕어빵틀을 만드는것 처럼
            // 회원1명을 만들기 위해 회원틀을 만들자 ---> 클래스 만들자
        // 자바에서의 배열은 *같은 타입의 자료끼리 저장 가능.
            // 1.
            String[] names = new String[100];
            int[] ages = new int[100];
            // 2.
            회원[] members = new 회원[100];

        // 3. 생성자 : 클래스에서 생성(만드는 것),
            // 클래스 만드는 이유 : 객체를 만들기 위해
                // 객체를 왜 만들죠? 객체는 속성/고유성질과 메소드/행위로 구성된 실체
                // 왜 실체가 필요한 이유? 현실 세계를 디지털화
                // 왜 디지털화 하죠? 컴퓨터는 피로도가 없고 전기세가 있으면 사람대신에 일을 하니까.
        // 예] 쿠팡 물류 공장에서 내가 제품을 포장을 하는 역할
            // - 사람은 피로도 , 급여
            // - 포장하는 행위/메소드 을 객체화 --> 사람대신에 컴퓨터가 포장하는 행위/메소드
                // - 포장을 어떻게 하는지 순서? 알고리즘/순서도
                // - 박스 선택 -> 박스 접고 -> 제품 넣고 -> 박스 테이핑 -> 점검
        // 1. 기본[디폴트] 생성자
            // - new 연산자 옆에 클래스명과 동일한 -- > 생성자
        게시판 b1 = new 게시판();
        b1.번호 = 1;
        b1.제목 = "안녕하세요";

            // vs
        // 2. 정의된 생성자
        // 게시판 b2 = new 게시판("안녕하세요", 2);
            // 선언된 생성자와 우리가 생성자 대입한 타입이 불일치라서 오류
        게시판 b3 = new 게시판(2, "안녕하세요");

        // 메소드
        // 1. 객체 생성
        제품 p1 = new 제품();

        // 2. 객체를 통해 메소드 호출
        p1.구매함수();
        // 왜?? 객체 없이 메소드 호출하면 될까 안 될까? X (누가 그걸 할지 그 주체가 빠졌다(나한테는 객체지만 컴퓨터한테는 주체다?)
            // 메소드란? 여러 개 실행문;/로직을 묶음

        int result1 = p1.환불함수("코카콜라");
        
        // public(공개용) vs private(비공개용)
            // 현재 클래스 기준의 다른 클래스로부터 공개 여부
            // 관례적으로 멤버변수는 private 사용
        // p1.제품번호 = "사이다";
            // 오류 이유 : 제품번호 멤버변수는 private라서 접근 불가능
        // getter and setter 활용하자, 멤버변수가 private일 때 외부에서 접근하기 위해
        // p1.제품번호 = "사이다";
        p1.set제품명("사이다");
        //System.out.println(p1.제품번호);
        System.out.println(p1.get제품명());


    }

}

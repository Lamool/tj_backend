package day14.step2;

public class Step2 {
    public static void main(String[] args) {
        //인터페이스 타입의 변수 선언
        StepInterface si;
        // 인터페이스는 스스로 객체/인스턴스를 생성불가능
        // 구현 안 한 메소드가 있으니까 --> 추상메소드
        // 구현[implements]을 해준 클래스가 필요하다
        // implements 한 클래스로 객체 생성한다. --> 구현(객)체

        new ImplementClass();       // <----- (인터페이스를 구현한 클래스의) 객체
        si = new ImplementClass();



        // si.method5(5);  // static 객체 없이 사용하는 멤버들
        // si.method6("JAVA");  // static 객체 없이 사용하는 멤버들
        //StepInterface.method(5);    // 이렇게 사용해줘야 됨


    }

}

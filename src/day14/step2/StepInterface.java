package day14.step2;

public interface StepInterface {

    // 1. 상수 : public static final
    public static final int value1 = 10;
    int value2 = 20;            // 인터페이스 안에서는 변수 생성시 무조건 상수.
                                // public static final이 기본적으로 들어가 생략 가능


    // 2. 추상메소드 : abstract        (: 구현하지 않은 것을 추상메소드라고 함)
    abstract void method1(int a);
    int method2(String a);          // (abstract가 추상이라는 뜻을 갖고 있다. 생략 가능)


    // 3. 디폴트메소드 : default
    default void method3(int a) {
        System.out.println("StepInterface.method3");
    }

    default int method4(String a) {
        System.out.println("StepInterface.method4");
        return 3;
//        method7(3);
//        method9(3);
        // private static을 쓰는 이유
        // 7은 오류나고 9는 되는 이유
    }


    // 4. 정적메소드 : static
    static void method5(int a) {
        System.out.println("StepInterface.method5");

    }

    static int method6(String a) {
        System.out.println("StepInterface.method6");
        return 3;
    }


    // 5. private 메소드 : private
    private void method7(int a) {
        System.out.println("StepInterface.method7");
    }

    private int method8(String a) {
        System.out.println("StepInterface.method8");
        return 3;
    }


    // 6. private 정적메소드 : private static
    private static void method9(int a) {
        System.out.println("StepInterface.method9");
    }

    private static int method10(String a) {
        System.out.println("StepInterface.method10");
        return 3;
    }
}

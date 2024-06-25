package day14.step3;

public interface Buy {
    // 추상메소드        -> 구현이 없고 선언부만 있는 것
    void buy();

    static void pay() {}

    default void order() {}
}

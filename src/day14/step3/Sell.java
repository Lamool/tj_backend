package day14.step3;

public interface Sell {
    // 추상메소드
    void sell();

    static void pay() {}

    default void order() {}
}

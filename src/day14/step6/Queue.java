package day14.step6;

public interface Queue {
    // 추상메소드
    void enQueue(String title);     // 배열의 맨 마지막에 추가
    String deQueue();               // 배열의 맨 처음 항목 반환
    int getSize();                  // 현재 Queue에 있는 개수 반환

}

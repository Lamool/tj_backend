package day06.step3;

public class Cart {
    String shape;   // 카트 모양
    int x;          // 카트 가로 길이
    int y;          // 카트 세로 길이
    int z;          // 카트 높이
    // 메소드 : 움직이기, 담기

    public void move() {
        System.out.println(shape + " 모양 카트 움직임");
    }

    public void put() {
        System.out.println(shape + " 모양 카트에 담음");
    }
}

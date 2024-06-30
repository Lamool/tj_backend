package day14.step6;

import java.util.ArrayList;

public class Shelf {    // 선반 역할 하는 클래스
    // 1. 멤버변수
    protected ArrayList<String> shelf;
    // protected ArrayList<String> shelf = new ArrayList<String>();     와 같이 해줄 수 있으나 생성자 안에 써주면 로직 추가와 유효성 검사를 해줄 수 있다.
        // protected vs public vs private vs 생략(default)
        // ArrayList<타입> 리스트변수명   vs   타입[] 배열변수명
            // 1. .add() : 리스트에 요소를 추가하는 함수
            // 2. .size() : 리스트내 요소들의 총 개수 반환 함수  vs length
            // 3. .remove(인덱스) : 리스트내 해당 인덱스의 요소 삭제 함수

    // 2. 생성자
    public Shelf() {
        // 추가적인 로직
        this.shelf = new ArrayList<String>();       // this 지금 여기서 안 적어도 됨
    }

    // 3. 메소드
    public ArrayList<String> getShelf() {
        return this.shelf;
    }

    public int getCount() {
        return this.shelf.size();
    }

}

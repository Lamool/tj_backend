package day15.step3_MVC;

import java.util.ArrayList;

public class Controller {
    // 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static변수
    static Controller controller = new Controller();

    // 2. 등록 제어 함수, 매개변수 : 저장할 값 String, 리턴 : 등록성공여부 boolean
    public boolean signupC(String name) {
        boolean result = Dao.dao.signupC(name);
        return result;
    }

    // 3. 출력 제어 함수, 매개변수 : x, 리턴 : 회원목록 ArrayList<String>
    public ArrayList<String> printC() {
        ArrayList<String> result = Dao.dao.printC( );
        return result;
    }

    // 4. 수정 제어 함수, 매개변수 : 기존이름 String, 새로운 이름 String, 리턴 : 수정성공여부 boolean
    public boolean updateC(String oldName, String newName) {
        boolean result = Dao.dao.updateC( oldName , newName );
        return result;
    }

    // 5. 삭제 제어 함수, 매개변수 : 삭제할이름 String, 리턴 : 삭제성공여부 boolean
    public boolean deleteC(String name) {
        boolean result = Dao.dao.deleteC( name );
        return result;
    }

}

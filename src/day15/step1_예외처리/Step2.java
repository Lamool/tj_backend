package day15.step1_예외처리;

public class Step2 {
    public static void main(String[] args) {
        try{  method1( ); }
        catch ( ClassNotFoundException e ){ System.out.println("함수해서 예외가 발생했어.");  }
        //[1] static 메소드 호출하는 방법
        // method1( );
        // staitc 함수가 아니라서 ??
        // main함수가 static 이므로 우선할당 되서 실행되는데 그때 method1 메소드를 몰른다.
        // [2] static 메소드가 아닌 메소드를 호출하는 방법
        // [2-1]
        //Step2 step2 = new Step2();  // 힙여역에 주소를 지역변수에 저장하고
        //step2.method1();            // 지역변수에 있는 힙영역에 접근해서 메소드 호출
        // [2-2]
        //new Step2().method1();  // 지역변수가 없이 바로 힙영역으로부터 메소드호출
        
        
        
    }
    static void method1( ) throws ClassNotFoundException {
        // void method1( ){
        // 예외 [ 해당 함수를 호출했던 곳으로 - 리턴과 비슷 ] 던지기/떠넘기기
        Class.forName("java.lang.String");
        Class.forName("java.lang.String2");
        // 1. 직접처리 : try{}catch{} 2.떠넘기기 : throws
    }
    
    
    


    /*
    내가
    // method1();       // static 함수가 아니라서?? main함수가 static이므로 우선할당 돼서



        // 두 번째 방법이

        new Step2().method1();



        // [2] static 메소드가 아닌 메소드를호출하는 방법
            // [2-1]
        Step2 step2 = new Step2();
        step2.method1();



        // main이 static이 아니었으면


    }

    static void method1() {
        // 예외 던지기/떠넘기기
        Class.forName("java.lang.String");
        // 1. 직접처리 : try{}cahtch{} throws

        // forName
        // throws 안 써주면 forName에 빨간줄
        // 예외는 이미 발생한 거고 main한테 던지면
    
    
    
    */

}

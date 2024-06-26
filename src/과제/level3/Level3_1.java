package 과제.level3;

import java.time.LocalDateTime;

public class Level3_1 {
    public static void main(String[] args) {
        System.out.println(" >> Level3_1 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

        System.out.println("--------------- for 없이 출력 10회 --------------------");
        System.out.println("안녕하세요1");
        System.out.println("안녕하세요2");
        System.out.println("안녕하세요3");
        System.out.println("안녕하세요4");
        System.out.println("안녕하세요5");
        System.out.println("안녕하세요6");
        System.out.println("안녕하세요7");
        System.out.println("안녕하세요8");
        System.out.println("안녕하세요9");
        System.out.println("안녕하세요10");
        System.out.println("--------------- for 사용해서 출력 10회 --------------------");

        /* 문제풀이 위치 */

        for (int i = 1; i <= 10; i++) {
            System.out.println("안녕하세요" + i);
        }

        /* ----------- */

    }

}

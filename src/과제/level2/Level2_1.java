package 과제.level2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level2_1 {
    public static void main(String[] args) {
        System.out.println(" >> Level2_1 answer >> ");

        // 현재 날짜/시간
        LocalDateTime answer = LocalDateTime.now();
        System.out.println(" >> answer time : "+ answer + " >> \n");

        Scanner scanner = new Scanner(System.in);
        while( true ) {
            System.out.print(" 음악 재생 중 종료버튼[x] : ");
            char btn = scanner.next().charAt(0);

            if (btn == 'x') {
                System.out.println(">> 음악종료");
                break;
            }
        }

    }

}

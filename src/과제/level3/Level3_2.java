package 과제.level3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_2 {
    public static void main(String[] args) {
        System.out.println(" >> Level3_2 answer >> ");

        // 현재 날짜/시간
        LocalDateTime answer = LocalDateTime.now();
        System.out.println(" >> answer time : "+ answer + " >> \n");

        Scanner scanner = new Scanner(System.in);
        int count = 1;
        String input = "";

        while (true) {
            System.out.print(count + "회 입력 : ");
            input = scanner.next();

            if (input.equals("end")) {
                break;
            }

            count++;
        }

        System.out.println("안내) 프로그램 종료 합니다.[총 " + --count + "회 입력]");
    }

}

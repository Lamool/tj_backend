package 과제.level3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_4 {
    public static void main(String[] args) {
        System.out.println(" >> Level3_4 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("input : ");
            sum += scanner.nextInt();

            if (sum < 0) {
                break;
            }

            for (int i = 0; i < sum; i++) {
                System.out.print("■ ");
            }

            System.out.println();

        }

    }

}

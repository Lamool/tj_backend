package 과제.level3;

import java.time.LocalDateTime;

public class Level3_3 {
    public static void main(String[] args) {
        System.out.println(" >> Level3_3 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

        int july1 = 3532100;
        int july2 = 9123700;
        int july3 = 5183400;
        int july4 = 11738700;
        int count = 0;

        System.out.println(" -------- 7월 매출액 -------- ");

        for (int i = 1; i <= 4; i++) {
            System.out.print(i + "주차 : ");

            if (i == 1) {
                count = july1 / 1000000;
                july1 /= 10000;
            } else if (i == 2) {
                count = july2 / 1000000;
                july2 /= 10000;
            } else if (i == 3) {
                count = july3 / 1000000;
                july3 /= 10000;
            } else if (i == 4) {
                count = july4 / 1000000;
                july4 /= 10000;
            }

            while (count > 0) {
                System.out.print("■");

                count--;
            }

            if (i == 1) {
                System.out.println(july1 + "만원");
            } else if (i == 2) {
                System.out.println(july2 + "만원");
            } else if (i == 3) {
                System.out.println(july3 + "만원");
            } else if (i == 4) {
                System.out.println(july4 + "만원");
            }

        }
    }

}

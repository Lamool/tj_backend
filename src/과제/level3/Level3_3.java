package 과제.level3;

import java.time.LocalDateTime;

public class Level3_3 {
    public static void main(String[] args) {
        System.out.println(" >> Level3_3 answer >> ");

        // 현재 날짜/시간
        LocalDateTime answer = LocalDateTime.now();
        System.out.println(" >> answer time : "+ answer + " >> \n");

        int july1 = 353;
        int july2 = 912;
        int july3 = 518;
        int july4 = 1173;
        int count = 0;

        System.out.println(" -------- 7월 매출액 -------- ");

        for (int i = 1; i <= 4; i++) {
            System.out.print(i + "주차 : ");

            if (i == 1) {
                count = july1 / 100;
            } else if (i == 2) {
                count = july2 / 100;
            } else if (i == 3) {
                count = july3 / 100;
            } else if (i == 4) {
                count = july4 / 100;
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

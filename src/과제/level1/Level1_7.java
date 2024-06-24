package 과제.level1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_7 {
    public static void main(String[] args) {
        System.out.println(" >> Level1_7 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

        Scanner scanner = new Scanner(System.in);

        System.out.print("회원명 String : ");
        String memberName = scanner.next();

        System.out.print("상태 boolean : ");
        boolean condition = scanner.nextBoolean();

        System.out.print("회원번호 byte : ");
        byte memberNumber = scanner.nextByte();

        System.out.print("성별 char : ");
        char gender = scanner.next().charAt(0);

        System.out.print("나이 short : ");
        short age = scanner.nextShort();

        System.out.print("포인트 int : ");
        int point = scanner.nextInt();

        System.out.print("예금액 long : ");
        long deposit = scanner.nextLong();

        System.out.print("키 float : ");
        float height = scanner.nextFloat();

        System.out.print("몸무게 double : ");
        double weight = scanner.nextDouble();

        System.out.println();

        System.out.println("==========회원 개인정보=============");
        System.out.printf("|        회원명 : %s     %8s \n", memberName, "|");
        System.out.printf("|        상태 : %b       %8s \n", condition, "|");
        System.out.printf("|        회원번호 : %d    %10s \n", memberNumber, "|");
        System.out.printf("|        성별 : %c       %11s \n", gender, "|");
        System.out.printf("|        나이 : %d       %10s \n", age, "|");
        System.out.printf("|        포인트 : %d     %7s \n", point, "|");
        System.out.printf("|        예금액 : %d     %5s \n", deposit, "|");
        System.out.printf("|        키 : %.1f      %10s \n", height, "|");
        System.out.printf("|        몸무게 : %.2f   %9s\n", weight, "|");
        System.out.println("==================================");


    }

}

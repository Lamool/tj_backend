package 과제.level1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
    public static void main(String[] args) {
        System.out.println(" >> Level1_3 answer >> ");

        // 현재 날짜/시간
        LocalDateTime answer = LocalDateTime.now();
        System.out.println(" >> answer time : "+ answer + " >> \n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("input boolean : ");
        boolean bool1 = scanner.nextBoolean();


        System.out.print("input byte : ");
        byte byteNum = scanner.nextByte();

        System.out.print("input char : ");
        char ch = scanner.next().charAt(0);

        System.out.print("input short : ");
        short shortNum = scanner.nextShort();

        System.out.print("input int : ");
        int intNum = scanner.nextInt();

        System.out.print("input long : ");
        long longNum = scanner.nextLong();

        System.out.print("input float : ");
        float floatNum = scanner.nextFloat();

        System.out.print("input double : ");
        double doubleNum = scanner.nextDouble();

        System.out.println("output boolean : " + bool1);
        System.out.println("output byte : " + byteNum);
        System.out.println("output char : " + ch);
        System.out.println("output short : " + shortNum);
        System.out.println("output int : " + intNum);
        System.out.println("output long : " + longNum);
        System.out.println("output float : " + floatNum);
        System.out.println("output double : " + doubleNum);

    }

}

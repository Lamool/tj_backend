package 과제.level1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
    public static void main(String[] args) {
        System.out.println(" >> Level1_3 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

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

        System.out.print("output boolean : " + bool1 + "\n");
        System.out.print("output byte : " + byteNum + "\n");
        System.out.print("output char : " + ch + "\n");
        System.out.print("output short : " + shortNum + "\n");
        System.out.print("output int : " + intNum + "\n");
        System.out.print("output long : " + longNum + "\n");
        System.out.print("output float : " + floatNum + "\n");
        System.out.print("output double : " + doubleNum + "\n");

    }

}

package 과제.level1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_8 {
    public static void main(String[] args) {
        System.out.println(" >> Level1_8 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

        Scanner scanner = new Scanner(System.in);

        String header = "\n============방문록===============\n번호\t    작성자 \t 방문록";
        String boardlist = "";
        String footer = "================================\n";
        String output = "";


        /* 문제풀이 위치 */

        // 1번 방문록
        output += " 1\t    ";

        System.out.print("[1]작성자 : ");
        boardlist = scanner.next();
        output += boardlist;
        output += " \t ";

        scanner.nextLine(); // 의미없는 입력메소드
        System.out.print("[1]방문록 : ");
        boardlist = scanner.nextLine();
        output += boardlist;

        // 방문록 출력
        System.out.println(header);
        System.out.println(output);
        System.out.println(footer);


        // 2번 방문록
        output += "\n 2\t    ";

        System.out.print("[2]작성자 : ");
        boardlist = scanner.next();
        output += boardlist;
        output += " \t ";

        scanner.nextLine();
        System.out.print("[2]방문록 : ");
        boardlist = scanner.nextLine();
        output += boardlist;

        System.out.println(header);
        System.out.println(output);
        System.out.println(footer);


        // 3번 방문록
        output += "\n 3\t    ";

        System.out.print("[3]작성자 : ");
        boardlist = scanner.next();
        output += boardlist;
        output += " \t ";

        scanner.nextLine();
        System.out.print("[3]방문록 : ");
        boardlist = scanner.nextLine();
        output += boardlist;

        System.out.println(header);
        System.out.println(output);
        System.out.println(footer);


        // 4번 방문록
        output += "\n 4\t    ";

        System.out.print("[4]작성자 : ");
        boardlist = scanner.next();
        output += boardlist;
        output += " \t ";

        scanner.nextLine();
        System.out.print("[4]방문록 : ");
        boardlist = scanner.nextLine();
        output += boardlist;

        System.out.println(header);
        System.out.println(output);
        System.out.println(footer);


        // 5번 방문록
        output += "\n 5\t    ";

        System.out.print("[5]작성자 : ");
        boardlist = scanner.next();
        output += boardlist;
        output += " \t ";

        scanner.nextLine();
        System.out.print("[5]방문록 : ");
        boardlist = scanner.nextLine();
        output += boardlist;

        System.out.println(header);
        System.out.println(output);
        System.out.println(footer);

        /* ----------- */




    }

}

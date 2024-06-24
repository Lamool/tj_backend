package 과제.level2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level2_4 {
    public static void main(String[] args) {
        System.out.println(" >> Level2_4 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

        Scanner scanner = new Scanner(System.in);

        // player가 낼 가위 바위 보 입력 받기
        System.out.print("가위 바위 보 선택 : ");
        String player = scanner.next();

        // 컴퓨터가 낼 가위 바위 보를 정하기 위해 랜덤으로 난수 생성
        int randomNum = (int)(Math.random() * 3);
        String com = "";

        if (randomNum == 0) {
            com = "보";
        } else if (randomNum == 1) {
            com = "바위";
        } else if (randomNum == 2) {
            com = "가위";
        }

        System.out.println("comran) " + com);

        // player와 com의 가위 바위 보 비교
        if (player.equals(com)) {
            System.out.println("result) 비겼습니다");
        } else if (player.equals("가위") && com.equals("보")
                || player.equals("바위") && com.equals("가위")
                || player.equals("보") && com.equals("바위")) {
            System.out.println("result) player 승리");
        } else {
            System.out.println("result) com 승리");
        }

    }

}

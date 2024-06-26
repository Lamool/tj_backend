package 과제.level3;

import java.time.LocalDateTime;
import java.util.Random;

public class Level3_5 {
    public static void main(String[] args) {
        System.out.println(" >> Level3_5 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

        String authNumber = "";

        for (int i = 0; i < 6; i++) {
            int random = new Random().nextInt(10);
            authNumber += random;
        }

        System.out.println("본인확인 인증번호 : " + authNumber);

    }

}

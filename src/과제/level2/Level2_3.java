package 과제.level2;

import java.time.LocalDateTime;

public class Level2_3 {
    public static void main(String[] args) {
        System.out.println(" >> Level2_3 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );

        System.out.println("--------------------------------------------------------------");

        int kor = 89;           // 국어 점수
        int eng = 49;           // 영어 점수
        int math = 72;          // 수학 점수
        int sum = kor + eng + math;     // 합계
        double avg = sum / 3;           // 평균
        boolean multiple3 = (sum % 3 == 0) ? true : false;
        boolean multiple8 = (sum % 8 == 0) ? true : false;
        String oddEven = (sum % 2 == 0) ? "짝수" : "홀수";
        String result = sum >= 65 ? "합격" : "탈락";

        System.out.printf("%-3s %-4s %-4s %-5s %-5s %-6s %-7s %-5s %s \n" +
                            "%-5d %-5d %-5d %-5d  %-5.1f   %-5b   %-5b    %-5s %-5s",
                          "국어", "영어", "수학", "합계", "평균", "3배수", "8배수", "홀짝", "결과",
                            kor, eng, math, sum, avg, multiple3, multiple8, oddEven, result);

    }

}

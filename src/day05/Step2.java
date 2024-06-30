package day05;

public class Step2 {
    public static void main(String[] args) {

        // 조건문 왜? 판단의 흐름 제어
        // 반복문 왜? 동일한 실행을 반복으로 실행

        // 1.
        int num = 1;
        num = num + 2;
        num = num + 3;
        num = num + 4;
        num = num + 5;
        num = num + 6;
        num = num + 7;
        num = num + 8;
        num = num + 9;
        num = num + 10;
        System.out.println(num);

        int num2 = 1;
        for (int i = 2; i <= 10; i++) {
            num2 = num2 + i;
        }
        System.out.println(num2);

        // 2.
            /*

            초기값
            while(조건문) {
                실행문;
                증감식;
            }

            for (초기값; 조건문; 증감식) {실행문}
            */

        int num3 = 1;
        int i = 2;
        while (i <= 10) {
            num3 = num3 + i;

            i++;
        }
        System.out.println(num3);


        // * 연산하거나 그 값을 가져다 사용하려면 변수에 반드시 어떤 값을 가지고 있어야 한다.
        // int sum;
        int sum = 0;
        sum = sum + 3;

        // 무한반복 : 24시간 서비스를 제공할 때 끊임없이 돌아야 하는 경우
//      while (true) {
//          System.out.println(">>loop<<");
//      }

//      for ( ; ;) {
//           System.out.println(">>loop<<");
//      }

        // do~while
        int num4 = 1;
        int sum2 = 0;   // 0을 대입하는 이유 : sum2에 연산하기 위해 초기값 대입
        do {
            sum2 += num4;
            num4++;
        } while (num4 <= 10);
        System.out.println(sum2);       // 55

        // vs
        sum2 = 0;
        for (int num5 = 1; num5 <= 10; num5++) {
            sum2 += num5;
        }
        System.out.println(sum2);   // 55


        //  관례
        // while : 무한루프 구현할 떼 while(true){}
        // do~while : 반드시 한 번 이상 수행해야 할 때
        // for : 일반적이다.


        // for문 중첩
            /*
                외부
                dan = 2
                    내부 times = 1 times = 2 times = 3 times = 4 times = 5 times = 6 times = 7 times = 8 times = 9
                dan = 3
                    내부 times = 1 times = 2 times = 3 times = 4 times = 5 times = 6 times = 7 times = 8 times = 9
                dan = 4
                    내부 times = 1 times = 2 times = 3 times = 4 times = 5 times = 6 times = 7 times = 8 times = 9
                dan = 5
                    내부 times = 1 times = 2 times = 3 times = 4 times = 5 times = 6 times = 7 times = 8 times = 9
                dan = 6
                    내부 times = 1 times = 2 times = 3 times = 4 times = 5 times = 6 times = 7 times = 8 times = 9
                dan = 7
                    내부 times = 1 times = 2 times = 3 times = 4 times = 5 times = 6 times = 7 times = 8 times = 9
                dan = 8
                    내부 times = 1 times = 2 times = 3 times = 4 times = 5 times = 6 times = 7 times = 8 times = 9
                dan = 9
                    내부 times = 1 times = 2 times = 3 times = 4 times = 5 times = 6 times = 7 times = 8 times = 9
            */
        // 외부 for문
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("dan = " + dan);

            // 내부 for문
            for (int times = 1; times <= 9; times++) {
                // %d 정수형식, $2d 2칸차지 정수, 포멧(형식) :
                System.out.printf("%2d * %2d = %2d\n", dan, times, dan * times);
            }
            System.out.println("===========================");
        }   // for end



        // continue : 반복문 안에서 continue문을 만난면 이후의 문장은 수행하지 않고 for문의 증감식으로 이동
            // 특정 조건에서는 수행하지 않고 건너뛰어야 할 때
        int total = 0;
        for (int num5 = 1; num5 <= 100; num5++) {
            // 만약에 num5가 짝수이면
            if (num5 % 2 == 0) { continue; }    //      // 코드의 흐름이 continue; 만나면 for문의 증감식으로 이동

            total += num5;
        }



        // break;
        // 예제 : 1부터 1씩 증가 하면서 누적 합계가 100초과이면 중지
        int sum3 = 0;
        for (int num5 = 1; sum3 < 100; num5++) {
            sum3 += num5;
        }
        System.out.println(sum3);
        //  ======================== vs ================
        sum3 = 0;
        for (int num5 = 0; ; num5++) {
            sum3 += num5;
            if (sum3 >= 100) break;
        }
        System.out.println(sum3);



        // p.123 연습문제 풀이
        // 1.
        int number1 = 10;
        int number2 = 2;
        char operator = '+';
        int result = 0;

        // if문
        if (operator == '+') {
            result = number1 + number2;
        } else if (operator == '-') {
            result = number1 - number2;
        } else if (operator == '*') {
            result = number1 * number2;
        } else if (operator == '/') {
            result = number1 / number2;
        }
        System.out.println("if문 : " + result);

        // vs switch~case문
        switch (operator) {
            case '+' :
                result = number1 + number2;
                break;
            case '-' :
                result = number1 - number2;
                break;
            case '*' :
                result = number1 * number2;
                break;
            case '/' :
                result = number1 / number2;
                break;
        }
        System.out.println("switch~case문 : " + result);


        // 2.
        for (int dan = 2; dan <= 9; dan++) {
            // 만약에 단이 홀수 이면
            if (dan % 2 != 0) continue;

            System.out.println(dan + "단");
            for (int j = 1; j <= 9; j++) {
                System.out.println(dan + " * " + j + " = " + dan * j);
            }
            System.out.println();
        }


        // 3.
        for (int dan = 2; dan <= 9; dan++) {
            for (int j = 1; j <= 9; j++) {
                if (j > dan) break;

                System.out.println(dan + " * " + j + " = " + dan * j);
            }
            System.out.println();
        }


        // 4.
        int count = 4;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 7; y++) {
                if (count == y) {
                    System.out.print("*");
                    count--;
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }


    }   // main end

}   // class end

package day03;

import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {

        // 모든 문제의 공통인 입력객체는 한 번만 생성
        Scanner scanner = new Scanner(System.in);

        //    [ 제어문/반복문 없이 풀이 ]

        // 문제1 : 하나의 정수형으로  입력받아 7의 배수 이면 'O' 아니면 'X' 출력 하시오.
        // 배수찾기 : 값 % 수 == 0, 나머지가 0이면 값은 그 수의 배수
        System.out.print("정수 입력 : ");
        int num1 = scanner.nextInt();
        System.out.println(num1 % 7 == 0 ? "O" : "X");



        // 문제2 : 하나의 정수형으로  입력받아 홀수 이면 'O' 아니면 'X' 출력 하시오.
        // 홀수 찾기 : 값 % 2 == 1, 나머지가 1이면 홀수, 나머지가 0이면 짝수
        System.out.print("정수 입력 : ");
        int num2 = scanner.nextInt();
        System.out.println(num2 % 2 == 1 ? "O" : "X");



        // 문제3 : 하나의 정수형으로 입력받아 7의 배수 이면서 짝수 이면 'O' 아니면 'X' 출력 하시오.
            // && : 이면서 면서 이고 그리고 모두
        System.out.print("정수를 입력하세요 : ");
        int num3 = scanner.nextInt();
        System.out.println((num3 % 7 == 0 && num3 % 2 == 0) ? "O" : "X");



        // 문제4 : 하나의 정수형으로  입력받아 11의 배수 이거나 짝수 이면 'O' 아니면 'X' 출력 하시오.
        System.out.print("정수 입력 : ");
        int num4 = scanner.nextInt();
        System.out.println(num4 % 11 == 0 || num4 % 2 == 0 ? "O" : "X");



        // 문제5 : 두개의 정수형으로 입력받아 더 큰수 출력 하시오.
        System.out.print("정수 1 : ");
        int num5 = scanner.nextInt();
        System.out.print("정수 2 : ");
        int num55 = scanner.nextInt();
        System.out.println(num5 >= num55 ? num5 : num55);



        // 문제6 : 정수형으로 반지름을 입력받아 원 넓이 출력 하시오. 소수점 둘째 자리 까지 출력하시오.
        // 계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]
        System.out.print("반지름 : ");
        double r  = scanner.nextDouble();
        double 넓이 = r * r * 3.14;
        System.out.printf("원 넓이 : %.2f\n", 넓이);



        // 문제7 : 실수형으로 두번 입력받아 앞 실수의 값이 뒤의 값의 몇% 인지 소수점 첫째 자리까지 출력하시오.
        //      예) 54.5   84.3 실수 2개입력시 결과는   64.285714%
        //      printf() 에서 % 출력시 %%
        System.out.print("실수1 : ");
        double value1 = scanner.nextDouble();
        System.out.print("실수2 : ");
        double value2 = scanner.nextDouble();
        double result = value1 / value2 * 100;
        System.out.printf("%.1f%%\n", result);



        // 문제8 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 , 소수점 첫째 자리까지 출력하시오.
        // 계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2
        System.out.print("윗변 : ");
        int top = scanner.nextInt();
        System.out.print("밑변 : ");
        int bottom = scanner.nextInt();
        System.out.print("높이 : ");
        int height = scanner.nextInt();
        double result8 = (top + bottom) * height / 2.0;
        System.out.printf("넓이 : %.1f\n", result8);



        // 문제9 : 키를 정수를 입력받아 표준체중 출력하기 , 정수형으로 출력하시오.
        // 계산식) 표준체중 계산식 = > (키 - 100) * 0.9
        System.out.print("키 입력 : ");
        int cm9 = scanner.nextInt();
        int weight9 = (cm9 - 100) * 9 / 10;
        System.out.printf("표준체중 : %dkg\n", weight9);



        // 문제10 : 키와 몸무게를 입력받아 BMI 출력하기 , 소수점 둘째 자리 까지 출력하시오.
        //      계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))
        System.out.print("키 입력 : ");
        double cm10 = scanner.nextDouble();
        System.out.print("몸무게 입력 : ");
        double weight10 = scanner.nextDouble();
        double bmi = weight10 / ((cm10 / 100) * (cm10 / 100));
        System.out.printf("BMI : %.2f\n", bmi);



        // 문제11 : inch 를 입력받아 cm 로 변환하기  , 소수점 둘째 자리까지 출력하시오.
        //      계산식) 1 inch -> 2.54cm
        System.out.print("cm로 변환할 inch를 입력 : ");
        double inch = scanner.nextDouble();
        double cm = inch * 2.54;
        System.out.printf("%.2f\n", cm);


//        System.out.print("cm로 변환할 inch를 입력하세요 : ");
//        int inch = scanner.nextInt();
//        double cm = inch * 2.54;
//        System.out.printf("%.2f", cm);



        // 문제12:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오
        // 계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %
        System.out.print("중간고사 점수 : ");
        int midScore = scanner.nextInt();
        System.out.print("기말고사 점수 : ");
        int finalScore = scanner.nextInt();
        System.out.print("수행평가 점수 : ");
        int testScore = scanner.nextInt();
        double score = midScore * 0.3 + finalScore * 0.3 + testScore * 0.4;
        System.out.printf("%.2f\n", score);



        // 문제13 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
        int x = 10;
        int y = x-- + 5 + --x;
        System.out.printf(" x의 값 : %d , y의값 : %d \n", x, y);
        // x = 8, y = 23
        // 1. x-- + 5   -> x = 10 + 5 => 15     [x는 + 연산후 1차감]
        // 2. 15 + --x  -> x = 8 + 15 => 23     [x는 + 연산전 1차감]



        // 문제14 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기
        System.out.print("나이 : ");
        int age = scanner.nextInt();
        System.out.println( age >= 40 ? "중년" : age >= 20 ? "성인" : age >= 10 ? "학생" : "");
        // System.out.println( 나이>=10?"학생":나이>=20?"성인":나이>=40?"중년":""); // 코드오류는 아니지만 조건상의 문제발생


        // 문제15 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력
        System.out.print("국어 점수를 입력하세요 : ");
        int kScore = scanner.nextInt();
        System.out.print("영어 점수를 입력하세요 : ");
        int eScore = scanner.nextInt();
        System.out.print("수학 점수를 입력하세요 : ");
        int mScore = scanner.nextInt();

        double totScore = (double) (kScore + eScore + mScore);
        System.out.printf("총점: %.0f\n", totScore);    // 총점(소수점 0자리)
        double avrScore = totScore / 3;
        System.out.printf("평균: %.2f\n", avrScore);    // 평균(소수점 2자리)



        // 문제16 : 3개의 정수형으로 입력받아 가장 큰수 출력
        System.out.print("정수1 입력 : ");
        int 정수1 = scanner.nextInt();
        System.out.print("정수2 입력 : ");
        int 정수2 = scanner.nextInt();
        System.out.print("정수3 입력 : ");
        int 정수3 = scanner.nextInt();

        int 큰정수 = 정수1 > 정수2 && 정수1 > 정수3 ? 정수1 : 정수2 > 정수3 ? 정수2 : 정수3;
        System.out.println("큰정수 = " + 큰정수);



        // 문제17 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 '로그인성공' 아니면 '로그인실패' 출력 하시오
            // 문자열(String)은 비교연산자 사용 불가능[객체]
            // 객체 비교 메소드 : 객체.equals()
            // 문자열 비교 : "문자열".equals("비교문자열")
        System.out.print("아이디 : ");
        String id = scanner.next();
        System.out.print("비밀번호 : ");
        String pw = scanner.next();

        // id == "admin" && pw == "1234" [불가능]
        System.out.println((id.equals("admin") && pw.equals("1234")) ? "로그인성공" : "로그인실패");


    }

}

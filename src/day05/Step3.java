package day05;

import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {

        // [ 입력 ] : 입력객체
        Scanner scanner = new Scanner(System.in);
/*
        // [1] 입력받은 수만큼 별 출력
        System.out.print("[1]별 개수 : ");
            // 1. 키보드로부터 정수형으로 입력받아 정수형 변수에 저장
        int star1 = scanner.nextInt();
        System.out.println("> star1 = " + star1);

            // 2. 입력받은 수 만큼 '*' 출력
        for (int i = 0; i < star1; i++) {
            System.out.print("*");
        }

        System.out.println("\n========== 구분선 ==========");


        // [2] 입력받은 수 만큼 별 출력 3의 배수마다 줄바꿈 처리 하시오.
        System.out.print("[2]별 개수 : ");
        int star2 = scanner.nextInt();      // scanner 객체 생성은 { } 마다 1번 선언
        System.out.println("> star2 = " + star2);

        // 2. 입력받은 수 만큼 '*' 출력 만약에 3의 배수이면 줄바꿈처리
        for (int i = 1; i <= star2; i++) {
            System.out.print("*");

            if (i % 3 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n========== 구분선 ==========");


        // [3] 입력받은 수 만큼 별을 하나의 변수에 하나씩 추가후 해당 변수 출력
        System.out.print("[3] 별 개수 : ");
        int star3 = scanner.nextInt();
        String starTotal = "";
        for (int i = 1; i <= star3; i++) {
            starTotal += "*";
        }
        System.out.println("starTotal = " + starTotal);

        System.out.println("\n========== 구분선 ==========");


        // [4] 입력받은 줄 만큼 아래와 같이 출력하시오.
        //  - 만일 5를 입력했으면 5줄 모양의 별 출력
        // *
        // **
        // ***
        // ****
        // *****
        // 줄 : \n
        // 줄은 1부터
        // 별 : 별은 1부터
        System.out.print("[4] 줄 수 입력 : ");
        int star4 = scanner.nextInt();
        for (int i = 0; i < star4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }



        // [5] 입력받은 줄 만큼 아래와 같이 출력하시오.
        //     *
        //    **
        //   ***
        //  ****
        // *****
        System.out.print("[5] 줄 수 입력 : ");
        int star5 = scanner.nextInt();
        for (int i = 1; i <= star5; i++) {
            for (int j = star5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }


        // [6] 입력받은 줄 만큼 아래와 같이 출력하시오.
        // *****
        // ****
        // ***
        // **
        // *
        System.out.print("[6] 줄 수 입력 : ");
        int star6 = scanner.nextInt();
        for (int i = 1; i <= star6; i++) {
            for (int j = star6; j >= i; j--) {
                System.out.print("*");
            }

            System.out.println();
        }



        // [7] 입력받은 줄 만큼 아래와 같이 출력하시오.
        // *****
        //  ****
        //   ***
        //    **
        //     *
        System.out.print("[7] 줄 수 입력 : ");
        int star7 = scanner.nextInt();
        for (int i = 1; i <= star7; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = star7; j >= i; j--) {
                System.out.print("*");
            }

            System.out.println();
        }



        // [8] 입력받은 줄 만큼 아래와 같이 출력하시오.
        //     *
        //    ***
        //   *****
        //  *******
        System.out.print("[8] 줄 수 입력 : ");
        int star8 = scanner.nextInt();
        for (int i = 1; i <= star8; i++) {
            for (int j = star8; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }



        // [9] 입력받은 줄 만큼 아래와 같이 출력하시오.
        //  *******
        //   *****
        //    ***
        //     *
        System.out.print("[9] 줄 수 입력 : ");
        int star9 = scanner.nextInt();
        for (int i = 1; i <= star9; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = star9 * 2 - 1; j >= i * 2 - 1; j--) {
                System.out.print("*");
            }

            System.out.println();
        }



        // [10] 입력받은 줄 만큼 아래와 같이 출력하시오.
        //     *
        //    ***
        //   *****
        //  *******
        //   *****
        //    ***
        //     *
//        System.out.print("[10] 줄 수 입력 : ");
//        int star10 = scanner.nextInt();
//        for (int i = 1; i <= star10; i++) {
//            if (i <= star10 / 2 + 1) {
//                for (int j = star10; j > i; j--) {
//                    System.out.print(" ");
//                }
//                for (int j = 1; j <= i * 2 - 1; j++) {
//                    System.out.print("*");
//                }
//            } else {
//                for (int j = 1; j <= i - 1; j++) {
//                    System.out.print(" ");
//                }
//                for (int j = star10 * 2 - 1; j >= i * 2 - 1; j--) {
//                    System.out.print("*");
//                }
//            }
//
//            System.out.println();
//        }



        System.out.print("[10] 줄 수 입력 : ");
        int star10 = scanner.nextInt();
        for (int i = 1; i <= star10; i++) {
            if (i <= star10 / 2 + 1) {
                for (int j = star10 / 2 + 1; j > i; j--) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i * 2 - 1; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 1; j <= i - 4; j++) {
                    System.out.print(" ");
                }
                for (int j = star10 * 2 - 1; j >= i * 2 - 1; j--) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }



        // [11] 입력받은 줄 만큼 아래와 같이 출력하시오.
        //  *   *
        //   * *
        //    *
        //   * *
        //  *   *
        System.out.print("[11] 줄 수 입력 : ");
        int star11 = scanner.nextInt();
        for (int i = 1; i <= star11; i++) {
            for (int j = 1; j <= star11; j++) {
                if (i == j || j == star11 - i + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
*/


        // [12]
        // *        *
        // **      **
        // ***    ***
        // ****  ****
        // **********
        // ****  ****
        // ***    ***
        // **      **
        // *        *




        // [13]
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        System.out.print("[13] 줄 수 입력 : ");
        int star13 = scanner.nextInt();
        for (int i = 1; i <= star13; i++) {
            if (i <= star13 / 2 + 1) {
                for (int j = 1; j <= i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = star13; j >= star13 - i + 1; j--) {
                    System.out.print("*");
                }
            } else {
                for (int j = 1; j <= star13 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = star13 - i + 1; j <= i; j++) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }





//        System.out.print("[13] 줄 수 입력 : ");
//        int star13 = scanner.nextInt();
//        for (int i = 1; i <= star13; i++) {
//            if (i < star13 / 2 + 1) {
//                for (int j = 1; j <= i - 1; j++) {
//                    System.out.print(" ");
//                }
//                for (int j = star13 * 2 - 1; j >= i * 2 - 1; j--) {
//                    System.out.print("*");
//                }
//            } else {
//                for (int j = star13; j > i; j--) {
//                    System.out.print(" ");
//                }
//                for (int j = 1; j <= i * 2 - 1; j++) {
//                    System.out.print("*");
//                }
//            }
//
//            System.out.println();
//        }





    }

}

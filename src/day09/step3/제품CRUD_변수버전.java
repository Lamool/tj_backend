package day09.step3;

import java.util.Scanner;

public class 제품CRUD_변수버전 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 제품 메모리 설계
        String productCode1 = "";
        String productName1 = "";
        int productPrice1 = 0;

        String productCode2 = "";
        String productName2 = "";
        int productPrice2 = 0;

        String productCode3 = "";
        String productName3 = "";
        int productPrice3 = 0;


        while(true) {   // 무한반복
            System.out.print("1. 등록(C) 2. 출력(R) 3. 수정(U) 4. 삭제(D) 5. 종료 선택 >> ");  // 무한출력
            int ch = scanner.nextInt(); // 무한입력
            if (ch == 1) {
                System.out.print("제품코드 : ");
                String code = scanner.next();

                System.out.print("제품명 : ");
                String name = scanner.next();

                System.out.print("제품가격 : ");
                int price = scanner.nextInt();

                if (productCode1.equals("") && productName1.equals("") && productPrice1 == 0) {
                    productCode1 = code;
                    productName1 = name;
                    productPrice1 = price;
                } else if (productCode2.equals("") && productName2.equals("") && productPrice2 == 0) {
                    productCode2 = code;
                    productName2 = name;
                    productPrice2 = price;
                } else if (productCode3.equals("") && productName3.equals("") && productPrice3 == 0) {
                    productCode3 = code;
                    productName3 = name;
                    productPrice3 = price;
                } else {
                    System.out.println("[경고] 제품등록 자리가 부족합니다.");
                }

            } else if (ch == 2) {
                System.out.println("========== 제품목록 ==========");

                if (!productCode1.equals("") && !productName1.equals("") && productPrice1 != 0) {
                    System.out.println("\t" + productCode1 + "\t" + productName1 + "\t" + productPrice1);
                }

                if (!productCode2.equals("") && !productName2.equals("") && productPrice2 != 0) {
                    System.out.println("\t" + productCode2 + "\t" + productName2 + "\t" + productPrice2);
                }

                if (!productCode3.equals("") && !productName3.equals("") && productPrice3 != 0) {
                    System.out.println("\t" + productCode3 + "\t" + productName3 + "\t" + productPrice3);
                }


            } else if (ch == 3) {
                System.out.print("수정할 제품코드 : ");
                String updateCode = scanner.next();

                System.out.print("새로운 제품명 : ");
                String updateName = scanner.next();

                System.out.print("새로운 제품가격 : ");
                int updatePrice = scanner.nextInt();

                if (productCode1.equals(updateCode)) {
                    productName1 = updateName;
                    productPrice1 = updatePrice;
                } else if (productCode2.equals(updateCode)) {
                    productName2 = updateName;
                    productPrice2 = updatePrice;
                } else if (productCode3.equals(updateCode)) {
                    productName3 = updateName;
                    productPrice3 = updatePrice;
                } else {
                    System.out.println("[경고] 존재하지 않는 제품코드 입니다.");
                }

            } else if (ch == 4) {
                System.out.print("삭제할 제품코드 ");
                String deleteCode = scanner.next();

                if (productCode1.equals(deleteCode)) {
                    productCode1 = "";
                    productName1 = "";
                    productPrice1 = 0;
                } else if (productCode2.equals(deleteCode)) {
                    productCode2 = "";
                    productName2 = "";
                    productPrice2 = 0;
                } else if (productCode3.equals(deleteCode)) {
                    productCode3 = "";
                    productName3 = "";
                    productPrice3 = 0;
                } else {
                    System.out.println("[경고] 존재하지 않는 제품코드 입니다.");
                }

            } else if (ch == 5) {
                break;
            } else {
                System.out.println("[안내] 알 수 없는 번호입니다.");
            }

        }   // while end

    }   // main end

}   // class end

package day09.step3;

import java.util.Scanner;

public class 제품CRUD_객체와배열버전 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 제품 메모리 설계
        String[] productCode = {"", "", ""};
        String[] productName = {"", "", ""};
        int[] productPrice = new int[3];

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

                if (productCode[0].equals("") && productName[0].equals("") && productPrice[0] == 0) {
                    productCode[0] = code;
                    productName[0] = name;
                    productPrice[0] = price;
                } else if (productCode[1].equals("") && productName[1].equals("") && productPrice[1] == 0) {
                    productCode[1] = code;
                    productName[1] = name;
                    productPrice[1] = price;
                } else if (productCode[2].equals("") && productName[2].equals("") && productPrice[2] == 0) {
                    productCode[2] = code;
                    productName[2] = name;
                    productPrice[2] = price;
                } else {
                    System.out.println("[경고] 제품등록 자리가 부족합니다.");
                }

            } else if (ch == 2) {
                System.out.println("========== 제품목록 ==========");

                if (!productCode[0].equals("") && !productName[0].equals("") && productPrice[0] != 0) {
                    System.out.println("\t" + productCode[0] + "\t" + productName[0] + "\t" + productPrice[0]);
                }

                if (!productCode[1].equals("") && !productName[1].equals("") && productPrice[1] != 0) {
                    System.out.println("\t" + productCode[1] + "\t" + productName[1] + "\t" + productPrice[1]);
                }

                if (!productCode[2].equals("") && !productName[2].equals("") && productPrice[2] != 0) {
                    System.out.println("\t" + productCode[2] + "\t" + productName[2] + "\t" + productPrice[2]);
                }


            } else if (ch == 3) {
                System.out.print("수정할 제품코드 : ");
                String updateCode = scanner.next();

                System.out.print("새로운 제품명 : ");
                String updateName = scanner.next();

                System.out.print("새로운 제품가격 : ");
                int updatePrice = scanner.nextInt();

                if (productCode[0].equals(updateCode)) {
                    productName[0] = updateName;
                    productPrice[0] = updatePrice;
                } else if (productCode[1].equals(updateCode)) {
                    productName[1] = updateName;
                    productPrice[1] = updatePrice;
                } else if (productCode[2].equals(updateCode)) {
                    productName[2] = updateName;
                    productPrice[2] = updatePrice;
                } else {
                    System.out.println("[경고] 존재하지 않는 제품코드 입니다.");
                }

            } else if (ch == 4) {
                System.out.print("삭제할 제품코드 ");
                String deleteCode = scanner.next();

                if (productCode[0].equals(deleteCode)) {
                    productCode[0] = "";
                    productName[0] = "";
                    productPrice[0] = 0;
                } else if (productCode[1].equals(deleteCode)) {
                    productCode[1] = "";
                    productName[1] = "";
                    productPrice[1] = 0;
                } else if (productCode[2].equals(deleteCode)) {
                    productCode[2] = "";
                    productName[2] = "";
                    productPrice[2] = 0;
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

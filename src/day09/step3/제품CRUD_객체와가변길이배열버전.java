package day09.step3;

import java.util.Scanner;

public class 제품CRUD_객체와가변길이배열버전 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 제품 메모리 설계
        int count = 0;
        제품[] product = new 제품[count]; // [null][null][null] // 201번지 -- > 301번지

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

                count++;

                제품[] productCopy = new 제품[count]; // 301번지
                for (int i = 0; i < product.length; i++) {
                    productCopy[i] = product[i];
                }

                product = productCopy;

                product[count-1] = new 제품(code, name, price);

            } else if (ch == 2) {
                System.out.println("========== 제품목록 ==========");

                for (int i = 0; i < product.length; i++) {
                    if (product[i] != null) {
                        System.out.println("\t" + product[i].getProductCode() + "\t" + product[i].getProductName() + "\t" + product[i].getProductPrice());
                    }
                }

            } else if (ch == 3) {
                System.out.print("수정할 제품코드 : ");
                String updateCode = scanner.next();

                System.out.print("새로운 제품명 : ");
                String updateName = scanner.next();

                System.out.print("새로운 제품가격 : ");
                int updatePrice = scanner.nextInt();

                boolean updateCheck = false;

                for (int i = 0; i < product.length; i++) {
                    if (product[i] != null) {
                        if (product[i].getProductCode().equals(updateCode)) {
                            product[i].setProductName(updateName);
                            product[i].setProductPrice(updatePrice);
                            updateCheck = true;
                            break;
                        }
                    }
                }

                if (updateCheck == false) {
                    System.out.println("[경고] 존재하지 않는 제품코드 입니다.");
                }

            } else if (ch == 4) {
                System.out.print("삭제할 제품코드 ");
                String deleteCode = scanner.next();
                boolean deleteCheck = false;

                for (int i = 0; i < product.length; i++) {
                    if (product[i] != null) {
                        if (product[i].getProductCode().equals(deleteCode)) {
                            product[i] = null;
                            deleteCheck = true;
                            break;
                        }
                    }
                }

                if (deleteCheck == false) {
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

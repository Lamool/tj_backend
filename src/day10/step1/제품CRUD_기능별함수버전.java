package day10.step1;

import day09.step6.제품;

import java.util.Scanner;

public class 제품CRUD_기능별함수버전 {
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

/*

    5. 제품CRUD_기능별함수버전
    - [메모리 설계] 외 모든 조건이 동일합니다.
    [ 메모리 설계 ]
        - 최대 제품 개수는 [!!!]제한없음
        - 제품의 속성은 제품코드 , 제품명 , 제품가격 3개
        - 배열은 1개 선언 가능 합니다.
        - 제품 클래스를 선언하고 객체를 활용 하시오.
        - 제품 등록시 제품객체는 생성되므로 while문 밖에 미리 배열내 객체를 임의로 생성하지 마시오.
        - 반복문을 최대한 활용하여 코드을 줄이시오.
        - 제품 클래스의 모든 멤버변수는 private 사용 합니다.
        - 제품 객체 생성시 매개변수가 3개인 생성자를 활용 합니다.
        [추가]
        - main 함수내 1,2,3,4 입력시 실행되는 실행문들을 함수로 구현하여
            함수 호출를 호출하는 방식으로 기능별로 함수화 를 하시오.

*/

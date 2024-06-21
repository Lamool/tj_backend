package day11.step1;

import day11.*;
import day11.CartRow;
import day11.CategoryRow;
import day11.MenuRow;
import day11.OrderInfoRow;
import day11.OrderRow;

import java.util.ArrayList;
import java.util.Scanner;

public class Step1 {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        ArrayList<CartRow> cartTable = new ArrayList<>();

        ArrayList<CategoryRow> categoryTable=new ArrayList<>();
        //메모리설계 셈플
        CategoryRow c1= new CategoryRow(); //객체

        c1.setCategoryCode(1);
        c1.setCategoryName("커피");

        CategoryRow c2= new CategoryRow();
        c2.setCategoryCode(2);
        c2.setCategoryName("스무디");

        CategoryRow c3= new CategoryRow();
        c3.setCategoryCode(3);
        c3.setCategoryName("에이드");

        categoryTable.add(c1);
        categoryTable.add(c2);
        categoryTable.add(c3);

        ArrayList<MenuRow> menuTable= new ArrayList<>();
        MenuRow m1= new MenuRow( 1, 1, 1000,"아메리카노");
        MenuRow m2= new MenuRow( 2,1 ,2000 ,"라떼");
        MenuRow m3= new MenuRow( 3,3 ,3000 ,"청포도에이드");

        menuTable.add(m1);
        menuTable.add(m2);
        menuTable.add(m3);

        ArrayList<OrderRow> orderTable =new ArrayList<>();
        OrderRow o1= new OrderRow(1,"2024-06-20");
        OrderRow o2= new OrderRow(2,"2024-06-19");
        OrderRow o3= new OrderRow(3,"2024-06-18");

        orderTable.add(o1);                 //주문목록1  아메리카노 5 라떼 2
        orderTable.add(o2);                 //주문목록2 :주문2 : 청포도에이드 3
        orderTable.add(o3);                 //주문목록3 : 티 3

        ArrayList<day11.OrderInfoRow>orderInfoTable=new ArrayList<>();
        OrderInfoRow i1= new OrderInfoRow(1, 5,1,1);
        OrderInfoRow i2= new OrderInfoRow(2, 2,2,1);
        OrderInfoRow i3= new OrderInfoRow(3, 1,3,3);

        orderInfoTable.add(i1);
        orderInfoTable.add(i2);
        orderInfoTable.add(i3);

        System.out.println(categoryTable);
        System.out.println(menuTable);
        System.out.println(orderTable);
        System.out.println(orderInfoTable);

        // 기능 구현
        while(true){
            System.out.println(" ===== ADMIN MENU ===== ");
            System.out.println("1.Category Add");   System.out.println("2.Category List");
            System.out.println("3.Product Add");    System.out.println("4.Product List");
            System.out.println("5.Cart Add");      System.out.println("6.Cart List");
            System.out.println("7.Order Add");      System.out.println("8.Order List");
            System.out.print("Menu choose : ");     int ch = scan.nextInt();
            if( ch == 1 ){
                // 1. 무엇을 입력받을지 안내/출력
                System.out.print("카테고리명 : ");
                // ===================== 카테고리 객체를 만들 준비물 ====================== //
                // 2. 위에 출력문을 보고 입력받은 값을 변수에 저장
                String category = scan.next();
                // 3. 카테고리리스트내 마지막인덱스의 카테고리코드+1
                int categoryCode = categoryTable.get( categoryTable.size()-1 ).getCategoryCode()+1;
                // js : categoryTable[ categoryTable.length-1 ].code+1
                // ===================================================================== //
                // 4. 위 객체ㅂ준비를 생성자에 넣어서 객체 생성
                CategoryRow categoryRow = new CategoryRow( categoryCode , category );
                // 5  위 생성된 객체를 리스트에 저장
                categoryTable.add( categoryRow );
                // 확인
                System.out.println(categoryTable);
            }
            else if ( ch == 2 ){
                for (int i = 0; i < categoryTable.size(); i++ ){
                    System.out.println(categoryTable.get(i));
                }
            }
            else if ( ch == 3 ){
                boolean check=false;
                System.out.print("카테고리번호 : ");
                int categoryNum = scan.nextInt();
                System.out.print("제품명 : ");
                String menuName = scan.next();
                System.out.print("제품가격 : ");
                int menuPrice = scan.nextInt();

                for(int i=0; i< categoryTable.size(); i++){
                    if(categoryTable.get(i).getCategoryCode()==categoryNum){
                        int menuCode = menuTable.get( menuTable.size()-1 ).getMenuCode()+1;
                        MenuRow menuRow = new MenuRow( menuCode , categoryNum, menuPrice, menuName );
                        menuTable.add( menuRow );
                        check=true;
                        break;
                    }
                }
                if(check==false){
                    System.out.println("[경고]없는 카테고리번호 입니다.");
                }

                //확인
                System.out.println(menuTable);

            }
            else if ( ch == 4 ){

                for(int i=0; i< categoryTable.size(); i++) {

                    for (int j = 0; j < menuTable.size(); j++) {
                        if (categoryTable.get(i).getCategoryCode() == menuTable.get(j).getCategoryCode()) {

                            System.out.println(menuTable.get(j));
                        }
                    }
                }

            }
            else if ( ch == 5 ){
                boolean check=false;

                System.out.print("제품번호 : ");
                int menuCode = scan.nextInt();

                System.out.print("주문수량 : ");
                int orderAmount = scan.nextInt();

                for(int i=0; i< menuTable.size(); i++){
                    if(menuTable.get(i).getMenuCode()==menuCode){
                        int cartCode = 0;

                        if (cartTable.size() == 0) {
                            cartCode = 1;
                        } else {
                            cartCode = cartTable.get( cartTable.size() - 1 ).getCartCode()+1;
                        }

                        CartRow cartRow = new CartRow( cartCode , menuCode, orderAmount );
                        cartTable.add( cartRow );
                        check=true;
                        break;
                    }
                }
                if(check==false){
                    System.out.println("[경고]없는 제품번호 입니다.");
                }

                //확인
                System.out.println(cartTable);

            }
            else if ( ch == 6 ){
                for (int i = 0; i < cartTable.size(); i++ ){
                    System.out.println(cartTable.get(i));
                }

            }
            else if ( ch == 7 ){
                System.out.print("주문날짜 :");
                String orderDate = scan.next();

                int orderCode = orderTable.get( orderTable.size()-1 ).getOrderCode()+1;
                // 주문 객체
                OrderRow orderRow = new OrderRow( orderCode , orderDate );
                // 주문 객체를 주문리스트에 담기
                orderTable.add( orderRow );

                // 주문상세 객체
                for( int i = 0 ; i < cartTable.size() ; i++ ){

                    // 객체 넣을준비물
                    int orderInfoCode = orderInfoTable.get( orderInfoTable.size()-1).getOrderInfoCode()+1;
                    int orderAmount =  cartTable.get(i).getOrderAmount();
                    int menuCode = cartTable.get(i).getMenuCode();
                    int oCode = orderCode;
                    // 객체 만들고
                    OrderInfoRow orderInfo = new OrderInfoRow( orderInfoCode , orderAmount , menuCode , oCode );
                    // 주문상세 객체를 주문상세리스트에 담기
                    orderInfoTable.add( orderInfo );
                }
                cartTable.clear();

                //확인
                System.out.println(orderInfoTable);
                System.out.println(orderTable);

            }
            else if ( ch == 8 ){

                for(int i=0; i< orderInfoTable.size(); i++) {

                    int menuAmount = orderInfoTable.get(i).getOrderAmount();

                    for(int j=0; j<menuTable.size(); i++) {
                        if(orderInfoTable.get(i).getMenuCode()==menuTable.get(j).getMenuCode()){
                            String menuName = menuTable.get(j).getMenuName();
                            System.out.println(menuName);
                            System.out.println(menuAmount);
                            break;

                        }

                    }



                }

            }
            else {}
        } // w end

    }



}

/*
    [자바 메모리 설계]
        1. 데이터베이스에서 설계한 테이블 기반으로 자바의 클래스를 선언/구현
        2. day11 -> step1 클래스에
            - 각 선언한 클래스를 이용하여 샘플코드 기반으로 각 객체 생성(각 클래스별 객체 3개 이상 생성)
            - 동일한 타입의 객체들을 각 ArrayList 선언해서 저장하고 출력


*/

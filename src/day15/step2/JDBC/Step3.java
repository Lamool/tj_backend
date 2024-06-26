package day15.step2.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {
        Connection conn = null;        // try에서도 써야 하고 while문 안에서도 써야 하기에 선언을 밖에 함. try 안에다 쓰면 지역변수라 while문에서는 못쓰니까

        // DB연동
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05", "root", "1234");
        } catch (Exception e) {
            System.out.println(">> 연동 실패 : " + e);
        }

        Scanner scan = new Scanner(System.in);
        // ArrayList<String> nameList = new ArrayList<>();     // 여러 개 String 객체(문자열)를 저장하는 리스트 객체      -> 여기서 쓸 이유가 없다. 어차피 다시 실행하면 리스트에 넣은 값들이 사라지니까

        while (true) {
            try {
                System.out.print("1.등록 2.출력 3.수정 4.삭제 : ");

                int ch = scan.nextInt();

                if (ch == 1) {
                    // 1. 입력받고
                    System.out.print(">> [저장C] 이름 : ");
                    String name = scan.next();

                    // 2. DB 저장     "insert into table1 values('유재석')"; -> "insert into table1 values('변수명')";
                    String sql = "insert into table1 values('" + name + "');";       System.out.println("sql : " + sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();

                } else if (ch == 2) {
                    System.out.println("===== 이름 명단 =====");
                    // 2. DB SQL 레코드 전체 검색/조회 : "select * from table1;"
                    String sql = "select * from table1;";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();       // ((ResultSet은 결과물을 조작할 때))
                    while (rs.next()) {     // 첫 번째 레코드부터 마지막 레코드까지 순회
                        System.out.println(rs.getString("name"));
                    }

                } else if (ch == 3) {
                    System.out.print("[수정U] 기존이름 : ");
                    String oldName = scan.next();
                    System.out.print("[수정U] 새로운이름 : ");
                    String newName = scan.next();

                    // 2. DB SQL 레코드 수정 : update table1 set name = '신동엽2' where name='신동엽';
                    String sql = "update table1 set name = '" + newName + "' where name='" + oldName + "'";         System.out.println("sql : " + sql);

                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();
                } else if (ch == 4) {
                    System.out.print(">>[삭제D] 이름 : ");
                    String name = scan.next();

                    // 2. DB SQL 레코드 삭제 : "delete from table1 where name = '유재석'";
                    String sql = "delete from table1 where name = '"+ name +"'";    System.out.println("sql : " + sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();

                } else {
                    System.out.println(">> 없는 기능 번호 입니다.");
                }

            } catch (InputMismatchException e) {
                System.out.println(" >> 잘못된 입력입니다. ");
                // ((int ch = scan.nextInt();))
                scan = new Scanner(System.in);  // 잘못 입력받은 값을 가지고 있는 객체를 초기화
            } catch (SQLException e) {
                System.out.println(" >> SQL 구문이 틀렸습니다." + e);
            }
        }

    }

}

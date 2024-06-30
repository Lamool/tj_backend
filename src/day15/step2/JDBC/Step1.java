package day15.step2.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class Step1 {
    public static void main(String[] args) {

        try {
            // 1.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 여기서 오류 발생시 : 현재 프로젝트내 라이브러리가 제대로 등록 안 될 때
            System.out.println("<< JDBC 드라이버 호출 성공 >>>");

            // 2.
            Connection conn;    // 인터페이스 타입의 변수 선언
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05", "root", "1234");
            System.out.println("<< DB 연동 성공 >>");

        } catch (Exception e) {
            System.out.println("JDBC 연동 실패 " + e);
        }

    }

}


/*
    JDBC : JAVA DATABASE CONNECT : 자바 데이터베이스 연동

    ((자바가 JDBC라는 인터페이스의 껍데기를 만들고
    각 회사들마다 JDBC의 구현체를 제공?))


                                각 DBMS 회사별
    자바                             구현 클래스 제공
    JDBC 인터페이스 제공               - MYSQL : mysql-connector-j-8.4.0.jar
                                     - ORACLE :
                                     -
                                     (다운로드 각각 받아야 함)


    2.
    ((jar 파일만 있으면 된다))



    - 연동 코드
        1. Class.forName("com.mysql.cj.jdbc.Driver");   : (JDBC 구현체) 드라이버 클래스 호출
            MYSQL : com.mysql.cj.jdbc.Driver
            ORACLE : oracle.jdbc.OracleDriver
        2. 연동
        DriverManager.getConnection("DB SERVER URL", "계정명", "비밀번호");
            - DB SERVER URL : jdbc:mysql:ip주소:port번호/DB명




        - Connection 인터페이스 : DB와 연동 성공한 객체 정보를 가지고 조작/기능/메소드 제공 하는 인터페이스


    //


    2. 연동

    DDL 자바에서 못함
    * 연동 성공시 연동성공한 정보를 가진 객체를 반환, 해당 연동객체를 가지고 DML(



*/
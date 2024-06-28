package day16.model.dao;            // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.model.dto.MemberDto;           // 다른 패키지에 속한 MemberDto 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드

import java.sql.Connection;                 // 데이터베이스 서버에 연결하고, SQL 문을 실행하며, 트랜잭션을 관리하는 Connection 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import java.sql.DriverManager;              // JDBC 드라이버를 등록하고, 데이터베이스와의 연결을 설정하는 DriverManager 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import java.sql.PreparedStatement;          //
import java.sql.ResultSet;                  //

public class MemberDao {            // MemberDao 클래스 선언
    // 0.
    // 접근제한자를 안 붙이면 기본이 default인데, default면 패키지 다른 경우 오류가 나서 public을 붙여주었다.
    // 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static도 써주었다.
    // MemberDao 클래스의 생성자를 호출하여 객체를 생성한 뒤 주소값을 mdao에 저장해준다
    public static MemberDao mdao = new MemberDao();

    // 0. DB연동
        // JDBC 인터페이스 변수 3개
    Connection conn;
    PreparedStatement ps;   // ((SQL을 실행해주는 애))
    ResultSet rs;
        // 생성자에 연동 코드
    MemberDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "1234");
        } catch (Exception e) {
            System.out.println(">> 연동 실패" + e);
        }
    }

    // 1. 회원가입 함수, 매개변수 : 아이디 String, 비번 String, 이름 String, 전화번호 String, 반환값 : 회원가입 성공 여부 boolean
    public boolean signup(MemberDto memberDto) {
        try {
            // 1. SQL 작성한다
            String sql = "INSERT INTO member(mid, mpwd, mname, mphone) values(?, ?, ?, ?);";
            // 2. SQL 기재한다
            ps = conn.prepareStatement(sql);
            // 2. SQL 문법의 ?(와일드카드) 매개변수 기재한다
            ps.setString(1, memberDto.getMid());        // .setString(?순서번호, 값 또는 변수명)
            ps.setString(2, memberDto.getMpwd());
            ps.setString(3, memberDto.getMname());
            ps.setString(4, memberDto.getMphone());
            // 3. SQL 실행한다. // 4. SQL 실행결과
            int count = ps.executeUpdate();     // executeUpdate() 등록된 레코드 수 반환
            if (count == 1) {
                return true;        // 1개 레코드 등록되면 성공
            }
        } catch (Exception e) {
            System.out.println(e);

        }

        return false;           // 5. 메소드 반환
    }

    // 2. 로그인 함수, 매개변수 : MemberDto(아이디, 비밀번호), 리턴값 : 로그인 성공한 회원번호 반환
    public int login(MemberDto memberDto) {
        try {
            // 1. SQL 작성한다
            String sql = "SELECT * FROM member where mid = ? and mpwd = ?;";
            // 2. DB연동객체에 SQL을 기재
            ps = conn.prepareStatement(sql);
            // 3. SQL의? 매개변수에 변수값 대입
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            // 4. 실행
            rs = ps.executeQuery();     // 5. 쿼리 실행 후 결과를 rs로 받는다.
            // 6. 다음 레코드 : 로그인 성공시 레코드 1개, 로그인 실패시 레코드 0개
            if (rs.next()) {   // 다음 레코드가 1개라도 존재하면 회원번호 반환
                return rs.getInt("mno");
            }

            // return rs.next(); 이렇게 해도 됨
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;   // 0을 반환하게 되면 로그인 실패
    }

    // 3. 아이디찾기 함수, 매개변수 : MemberDto(이름, 전화번호), 리턴값 : String (찾은 아이디 / null) - 찾았으면 문자열이 들어있고 못찾았으면 null 대입
    public String findId(MemberDto memberDto) {
        try {
            // 1. SQL 작성한다
            String sql = "SELECT * FROM member where mname = ? and mphone = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMname());
            ps.setString(2, memberDto.getMphone());
            rs = ps.executeQuery();

            if (rs.next()) {
                String findId = rs.getString("mid");     // rs.getString("필드명") : 현재 레코드의 해당 필드명에 필드값 반환
                return findId;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // 4. 비밀번호찾기 함수, 매개변수 : MemberDto(아이디, 전화번호), 리턴값 : String (찾은 비밀번호 / null) - 찾았으면 문자열이 들어있고 못찾았으면 null 대입
    public String findPwd(MemberDto memberDto) {
        try {
            // 1. SQL 작성한다
            String sql = "SELECT * FROM member" +
                    " where mid = ? and mphone = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMphone());
            rs = ps.executeQuery();

            if (rs.next()) {
                String findPwd = rs.getString("mpwd");     // rs.getString("필드명") : 현재 레코드의 해당 필드명에 필드값 반환
                return findPwd;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    // 5. 회원탈퇴 함수
    public boolean mDelete(String confirmPwd, int loginMno) {
        try {
            String sql = "delete from member where mno = ? and mpwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, loginMno);
            ps.setString(2, confirmPwd);

            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

    // 2. 회원수정 함수
    public boolean mUpdate(MemberDto memberDto) {
        try {
            String sql = "update member set mname = ?, mphone = ? where mno = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMname());
            ps.setString(2, memberDto.getMphone());
            ps.setInt(3, memberDto.getMno());
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

}

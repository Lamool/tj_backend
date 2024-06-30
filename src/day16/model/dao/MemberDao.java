package day16.model.dao;            // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.model.dto.MemberDto;           // 다른 패키지에 속한 MemberDto 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드

import java.sql.Connection;                 // 데이터베이스 서버에 연결하고, SQL 문을 실행하며, 트랜잭션을 관리하는 Connection 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import java.sql.DriverManager;              // JDBC 드라이버를 등록하고, 데이터베이스와의 연결을 설정하는 DriverManager 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import java.sql.PreparedStatement;          // JDBC를 사용하여 SQL 쿼리를 실행하기 위한 PreparedStatement 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드
import java.sql.ResultSet;                  // JDBC를 사용하여 데이터베이스에서 결과를 가져오기 위해 필요한 ResultSet 클래스를 현재 파일에서 사용할 수 있도록 해주는 코드

public class MemberDao {            // MemberDao 클래스 선언
    // 0.
    // 접근제한자를 안 붙이면 기본이 default인데, default면 패키지 다른 경우 오류가 나서 public을 붙여주었다.
    // 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static도 써주었다.
    // MemberDao 클래스의 생성자를 호출하여 객체를 생성한 뒤 주소값을 mdao에 저장해준다
    public static MemberDao mdao = new MemberDao();

    // 0. DB연동
        // JDBC 인터페이스 변수 3개
    Connection conn;            // DB와 연동 성공한 객체 정보를 가지고 조작/기능/메소드 제공 하는 인터페이스
    PreparedStatement ps;       // SQL 조작/기능/메소드 제공 하는 인터페이스
    ResultSet rs;               // select문법의 실행결과를 조작/기능/메소드 제공하는 인터페이스
        // 생성자에 연동 코드
    MemberDao() {       // MemberDao() start
        try {       // 예외가 발생 하거나 발생 할 것 같은 코드를 포함하고 있다. 만약 실행 도중 예외가 발생한다면 프로그램의 제어를 catch 블록으로 넘긴다.
            Class.forName("com.mysql.cj.jdbc.Driver");          // (JDBC 구현체) 드라이버 클래스 호출
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "1234");        // DB연동     // DriverManager.getConnection(" DB SERVER URL" , "계정명" , "비밀번호" );
        } catch (Exception e) {     // catch 블록은 예외 처리를 담당하는 곳. Exception은 모든 예외의 최상위 클래스이기 때문에, 모든 종류의 예외를 처리할 수 있다.
                                        // 예외가 발생하면 해당 예외 객체가 e라는 변수에 할당된다
            System.out.println(">> 연동 실패" + e);         // ">> 연동 실패" 문장과 발생한 예외의 정보를 출력하고 줄바꿈 처리를 해준다
        }       // catch end
    }       // MemberDao() end

    // 1. 회원가입 함수, 매개변수 : 아이디 String, 비번 String, 이름 String, 전화번호 String, 반환값 : 회원가입 성공 여부 boolean
    public boolean signup(MemberDto memberDto) {
        try {       // 예외가 발생 하거나 발생 할 것 같은 코드를 포함하고 있다. 만약 실행 도중 예외가 발생한다면 프로그램의 제어를 catch 블록으로 넘긴다.
            // 1. SQL 작성한다
            // member 테이블에 아이디, 비번, 이름, 전화번호 데이터를 삽입하기 위한 구문
            // 각각의 ?는 나중에 PreparedStatement에서 설정할 값들을 나타낸다
            String sql = "INSERT INTO member(mid, mpwd, mname, mphone) values(?, ?, ?, ?);";
            // 2. DB연동 객체에 SQL을 기재
            ps = conn.prepareStatement(sql);
            // 2. SQL 문법의 ?(와일드카드) 매개변수 기재한다
            ps.setString(1, memberDto.getMid());        // .setString(?순서번호, 값 또는 변수명)      // 물음표 첫 번째 자리에 memberDto 객체의 mid 필드 값을 설정해준다
            ps.setString(2, memberDto.getMpwd());       // 물음표 두 번째 자리에 memberDto 객체의 mpwd 필드 값을 설정해준다
            ps.setString(3, memberDto.getMname());      // 물음표 세 번째 자리에 memberDto 객체의 mname 필드 값을 설정해준다
            ps.setString(4, memberDto.getMphone());     // 물음표 네 번째 자리에 memberDto 객체의 mhpone 필드 값을 설정해준다
            // 3. SQL 실행한다. // 4. SQL 실행결과
            int count = ps.executeUpdate();     // executeUpdate() : insert , update , delete 문법을 실행하고 최신화된 레코드수 반환.     // 등록된 레코드 수 반환값을 count 변수에 대입한다
            if (count == 1) {           // 1개 레코드 등록되면 성공
                return true;            // count가 1이면 회원 가입 성공을 뜻하는 true 반환
            }
        } catch (Exception e) {             // catch 블록은 예외 처리를 담당하는 곳. Exception은 모든 예외의 최상위 클래스이기 때문에, 모든 종류의 예외를 처리할 수 있다.
                                                // 예외가 발생하면 해당 예외 객체가 e라는 변수에 할당된다
            System.out.println(e);          // 발생한 예외의 정보를 콘솔에 출력한다
        }       // catch end

        return false;           // 5. 메소드 반환        // 회원 가입 실패를 뜻하는 false 반환
    }

    // 2. 로그인 함수, 매개변수 : MemberDto(아이디, 비밀번호), 리턴값 : 로그인 성공한 회원번호 반환
    public int login(MemberDto memberDto) {     // 로그인 함수 start
        try {       // 예외가 발생 하거나 발생 할 것 같은 코드를 포함하고 있다. 만약 실행 도중 예외가 발생한다면 프로그램의 제어를 catch 블록으로 넘긴다.
            // 1. SQL 작성한다
            String sql = "SELECT * FROM member where mid = ? and mpwd = ?;";
            // 2. DB연동 객체에 SQL을 기재
            ps = conn.prepareStatement(sql);
            // 3. SQL의? 매개변수에 변수값 대입
            ps.setString(1, memberDto.getMid());        // .setString(?순서번호, 값 또는 변수명)      // 물음표 첫 번째 자리에 memberDto 객체의 mid 필드 값을 설정해준다
            ps.setString(2, memberDto.getMpwd());       // 물음표 두 번째 자리에 memberDto 객체의 mpwd 필드 값을 설정해준다
            // 4. 실행
            rs = ps.executeQuery();     // 5. 쿼리 실행 후 결과를 rs로 받는다.
            // 6. 다음 레코드 : 로그인 성공시 레코드 1개, 로그인 실패시 레코드 0개
            if (rs.next()) {   // 다음 레코드가 1개라도 존재하면 회원번호 반환
                return rs.getInt("mno");
            }

            // return rs.next(); 이렇게 해도 됨
        } catch (Exception e) {             // catch 블록은 예외 처리를 담당하는 곳. Exception은 모든 예외의 최상위 클래스이기 때문에, 모든 종류의 예외를 처리할 수 있다.
                                                // 예외가 발생하면 해당 예외 객체가 e라는 변수에 할당된다
            System.out.println(e);          // 발생한 예외의 정보를 콘솔에 출력한다
        }
        return 0;   // 0을 반환하게 되면 로그인 실패
    }           // 로그인 함수 end

    // 3. 아이디찾기 함수, 매개변수 : MemberDto(이름, 전화번호), 리턴값 : String (찾은 아이디 / null) - 찾았으면 문자열이 들어있고 못찾았으면 null 대입
    public String findId(MemberDto memberDto) {
        try {       // 예외가 발생 하거나 발생 할 것 같은 코드를 포함하고 있다. 만약 실행 도중 예외가 발생한다면 프로그램의 제어를 catch 블록으로 넘긴다.
            // 1. SQL 작성한다
            String sql = "SELECT * FROM member where mname = ? and mphone = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMname());      // 물음표 첫 번째 자리에 memberDto 객체의 mname 필드 값을 설정해준다
            ps.setString(2, memberDto.getMphone());     // 물음표 두 번째 자리에 memberDto 객체의 mphone 필드 값을 설정해준다
            rs = ps.executeQuery();

            if (rs.next()) {
                String findId = rs.getString("mid");     // rs.getString("필드명") : 현재 레코드의 해당 필드명에 필드값 반환
                return findId;
            }

        } catch (Exception e) {             // catch 블록은 예외 처리를 담당하는 곳. Exception은 모든 예외의 최상위 클래스이기 때문에, 모든 종류의 예외를 처리할 수 있다.
                                                // 예외가 발생하면 해당 예외 객체가 e라는 변수에 할당된다
            System.out.println(e);          // 발생한 예외의 정보를 콘솔에 출력한다
        }
        return null;                        // null 반환
    }

    // 4. 비밀번호찾기 함수, 매개변수 : MemberDto(아이디, 전화번호), 리턴값 : String (찾은 비밀번호 / null) - 찾았으면 문자열이 들어있고 못찾았으면 null 대입
    public String findPwd(MemberDto memberDto) {
        try {       // 예외가 발생 하거나 발생 할 것 같은 코드를 포함하고 있다. 만약 실행 도중 예외가 발생한다면 프로그램의 제어를 catch 블록으로 넘긴다.
            // 1. SQL 작성한다
            String sql = "SELECT * FROM member" +
                    " where mid = ? and mphone = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());        // 물음표 첫 번째 자리에 memberDto 객체의 mid 필드 값을 설정해준다
            ps.setString(2, memberDto.getMphone());     // 물음표 두 번째 자리에 memberDto 객체의 mphone 필드 값을 설정해준다
            rs = ps.executeQuery();

            if (rs.next()) {
                String findPwd = rs.getString("mpwd");     // rs.getString("필드명") : 현재 레코드의 해당 필드명에 필드값 반환
                return findPwd;             // 찾은 비밀번호 MemberController에 반환
            }

        } catch (Exception e) {             // catch 블록은 예외 처리를 담당하는 곳. Exception은 모든 예외의 최상위 클래스이기 때문에, 모든 종류의 예외를 처리할 수 있다.
                                                // 예외가 발생하면 해당 예외 객체가 e라는 변수에 할당된다
            System.out.println(e);          // 발생한 예외의 정보를 콘솔에 출력한다
        }
        return null;

    }

    // 5. 회원탈퇴 함수
    public boolean mDelete(String confirmPwd, int loginMno) {
        try {       // 예외가 발생 하거나 발생 할 것 같은 코드를 포함하고 있다. 만약 실행 도중 예외가 발생한다면 프로그램의 제어를 catch 블록으로 넘긴다.
            String sql = "delete from member where mno = ? and mpwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, loginMno);                 // 물음표 첫 번째 자리에 loginMno 값을 설정해준다
            ps.setString(2, confirmPwd);            // 물음표 두 번째 자리에 confirmPwd 값을 설정해준다

            int count = ps.executeUpdate();
            if (count == 1) {       // count가 1이면
                return true;            // 회원 탈퇴 성공을 뜻하는 true를 반환한다
            }
        } catch (Exception e) {             // catch 블록은 예외 처리를 담당하는 곳. Exception은 모든 예외의 최상위 클래스이기 때문에, 모든 종류의 예외를 처리할 수 있다.
                                                // 예외가 발생하면 해당 예외 객체가 e라는 변수에 할당된다
            System.out.println(e);          // 발생한 예외의 정보를 콘솔에 출력한다
        }

        return false;                   // 회원 탈퇴 실패를 뜻하는 false를 반환한다

    }

    // 2. 회원수정 함수
    public boolean mUpdate(MemberDto memberDto) {
        try {       // 예외가 발생 하거나 발생 할 것 같은 코드를 포함하고 있다. 만약 실행 도중 예외가 발생한다면 프로그램의 제어를 catch 블록으로 넘긴다.
            String sql = "update member set mname = ?, mphone = ? where mno = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMname());          // 물음표 첫 번째 자리에 memberDto 객체의 mname 필드 값을 설정해준다
            ps.setString(2, memberDto.getMphone());         // 물음표 두 번째 자리에 memberDto 객체의 mphone 필드 값을 설정해준다
            ps.setInt(3, memberDto.getMno());               // 물음표 세 번째 자리에 memberDto 객체의 mno 필드 값을 설정해준다
            int count = ps.executeUpdate();
            if (count == 1) {           // count가 1이면
                return true;                // 회원 수정 성공을 뜻하는 true를 반환한다
            }

        } catch (Exception e) {             // catch 블록은 예외 처리를 담당하는 곳. Exception은 모든 예외의 최상위 클래스이기 때문에, 모든 종류의 예외를 처리할 수 있다.
                                                // 예외가 발생하면 해당 예외 객체가 e라는 변수에 할당된다
            System.out.println(e);          // 발생한 예외의 정보를 콘솔에 출력한다
        }

        return false;                       // 회원 수정 실패를 뜻하는 false를 반환한다

    }

}

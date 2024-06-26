package day16.model.dao;            // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.model.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {             // BoardDao 클래스 선언
    // 싱글톤
    // 1. private static 변수에 해당 클래스의 객체 생성해서 대입
    public static BoardDao bDao = new BoardDao();

    // 2. 해당 클래스의 생성자를 private 한다. 다른 클래스에서 new 사용하지 못하게 차단하기
    BoardDao() {
        try {   // DB 연동
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // 3. 해당 객체(싱글톤)를 외부로부터 접근할 수 있도록 간접(추후에 유효성검사) 호출 메소드를 만들어야 한다
    public static BoardDao getInstance() {
        return bDao;
    }

    // JDBC 인터페이스
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    // 4. 게시판(게시물 전체출력) 함수 : 매개변수 : X, 리턴값 : 여러 개 게시물 -> 여러 개 레코드 -> 여러 개 DTO
    public ArrayList<BoardDto> bPrint() {
        // 여러 개 DTO 담을 리스트 선언
        ArrayList<BoardDto> list = new ArrayList<>();

        try {   // 0. 예외처리
            String sql = "select * from board;";    // 1. SQL 작성
            ps = conn.prepareStatement(sql);        // 2. SQL 기재
            rs = ps.executeQuery();                 // 3. 기재된 sql 실행 하고 결과 반환
                                                        // rs에 대입해주지 않으면 Cannot invoke "java.sql.ResultSet.next()" because "this.rs" is null 오류 발생
            while (rs.next()) {                     // 4. 결과 레코드 전체를 하나씩 순회하기
                // ((rs가 조작을 할 수 있는 기능을 가지고 있는데))
                // ((rs.next() 처음부터 첫 번째 레코드를 가지고 있는 게 아님. 한 번 했을 때 첫 번째 레코드를 가지게 됨.))
                // rs.next() : 다음 레코드 이동, 존재하면 true, 없으면 false
                // 레코드 1개 당 --> Dto 1개

                // rs.getString("필드명") : 현재 레코드의 해당 필드명 값 호출
                String btitle = rs.getString("btitle");
                String bcontent = rs.getString("bcontent");
                String bdate = rs.getString("bdate");
                int bview = rs.getInt("bview");
                int mno = rs.getInt("mno");
                int bno = rs.getInt("bno");

                // Dto 만들기
                BoardDto boardDto = new BoardDto(btitle, bcontent, bdate, bview, mno, bno);

                list.add(boardDto);     // 리스트에 dto 담기
                // return list;     // 여기서 return하면 안 됨. 결과 레코드 전체를 하나씩 순회해야 하는데 하나만 받아오고 함수를 끝내기 때문
            }

            return list;        // 여러 개 담긴 Dto의 리스트를 반환
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;    // 여러 개 담긴 Dto의 리스트를 반환
    }

    // 5. 게시물 쓰기 함수
    public boolean bWrite(BoardDto boardDto) {
        try {   // 0. 예외처리
            String sql = "INSERT INTO board(btitle, bcontent, mno) VALUES(?, ?, ?);";   // 1. SQL 작성
            ps = conn.prepareStatement(sql);    // 2. sql 기재
            ps.setString(1, boardDto.getBtitle());      // 3. 기재된 sql의 매개변수 값 대입
            ps.setString(2, boardDto.getBcontent());
            ps.setInt(3, boardDto.getMno());

            int count = ps.executeUpdate();     // 4. sql 실행 후 결과받기
            if (count == 1) {       // 결과에 따른 처리    // insert 결과 레코드가 1개
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }


    // 6. 게시물 개별 조회 함수
    public BoardDto bView(int bno) {
        try {       // 0. 예외처리
            String sql = "select * from board where bno = ? ";      // 1. SQL 작성
            ps = conn.prepareStatement(sql);        // 2. SQL 기재
            ps.setInt(1, bno);      // 3. 기재된 SQL ? 매개변수 대입
            rs = ps.executeQuery();     // 4. SQL 실행 후 결과 반환
            if (rs.next()) {    // 결과에 따른 처리
                // 현재 레코드들의 필드값 각 호출 해서 생성자에 매개변수로 대입
                BoardDto boardDto = new BoardDto(
                    rs.getString("btitle"),
                    rs.getString("bContent"),
                    rs.getString("bdate"),
                    rs.getInt("bview"),
                    rs.getInt("mno"),
                    rs.getInt("bno")
                );
                return boardDto;    // 생성된 boardDto 반환
            }

        } catch(Exception e) {
            System.out.println(e);
        }
        return null;    // 오류 또는 게시물이 존재하지 않을 때 null 반환

    }


    // 7. 게시물 삭제 함수, 매개변수 : bno, mno (게시물번호, 로그인된 회원번호)
    public boolean bDelete(int bno, int mno) {
        try {       // 0. 예외처리
            String sql = "delete from board where bno = ? and mno = ?;";        // 1. SQL  작성
            ps = conn.prepareStatement(sql);     // 2. sql 기재
            ps.setInt(1, bno);      // 3. 기재된 sql의 ? 매개변수 값 대입
            ps.setInt(2, mno);
            int count = ps.executeUpdate();     // 4. sql 실행 후 결과 받기
            if (count == 1)  return true;      // 5. 결과에 따른 반환처리
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 8. 게시물 수정 함수
    public boolean bUpdate(BoardDto boardDto) {
        try {       // 0. 예외처리
            String sql = "update board set btitle = ?, bcontent = ? where bno = ? and mno = ?;";    // 1. SQL 작성
            ps = conn.prepareStatement(sql);        // 2. sql 기재
            ps.setString(1, boardDto.getBtitle());          // 3. 기재된 sql의 ? 매개변수 값 대입
            ps.setString(2, boardDto.getBcontent());
            ps.setInt(3, boardDto.getBno());
            ps.setInt(4, boardDto.getMno());

            int count = ps.executeUpdate();     // 4. sql 실행 후 결과 받기
            if (count == 1) return true;        // 5. 결과에 따른 반환처리

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

}   // class end

package day16.model.dao;            // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

import day16.model.dto.BoardDto;
import day16.model.dto.ReplyDto;

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
            // String sql = "select * from board;";    // 1. SQL 작성
            // pk랑 fk만
            String sql = "select * from board b inner join member m on b.mno = m.mno order by bdate desc;";     // order by bno desc도 가능    // 게시물 최신순으로 출력

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
                BoardDto boardDto = new BoardDto(btitle, bcontent, bdate, bview, mno, bno);     // Dto 1개 만들기
                boardDto.setMid(rs.getString("mid"));

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

    // 9. 댓글 출력 함수
    public ArrayList<ReplyDto> rPrint(int bno) {
        ArrayList<ReplyDto> list = new ArrayList<>();   // 여러 개 ReplayDto 담을 리스트

        try {   // 0. 예외처리
            //String sql = "select * from reply where bno = ?;";  // 1. SQL 작성
            String sql = "select * from reply r inner join member m on r.mno = m.mno where r.bno = ?;";
            ps = conn.prepareStatement(sql);    // 2. SQL 기재
            ps.setInt(1, bno);  // 3. 기재된 SQL의 ? 매개변수 값 대입
            rs = ps.executeQuery();     // 4. sql 실행 후 결과 반환

            while (rs.next()) {     // 5. 결과에 따른 처리, rs.next() : 결과에서 다음 레코드 이동
                ReplyDto replyDto = new ReplyDto(
                        rs.getString("rcontent"), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5)
                );
                replyDto.setMid(rs.getString(6));
                // 생성된 dto를 리스트에 담기
                list.add(replyDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }   // rPrint 함수 end

    // 10. 댓글 쓰기 함수
    public boolean rWrite(ReplyDto replyDto) {
        // 6.
        try {   // 0. 예외처리
            String sql = "INSERT INTO reply(rcontent, mno, bno) values(?, ?, ?);";      // 1. SQL 작성
            ps = conn.prepareStatement(sql);        // 2. SQL 기재
            ps.setString(1, replyDto.getRcontent());    // 기재된 SQL의 매개변수 값 대입
            ps.setInt(2, replyDto.getMno());
            ps.setInt(3, replyDto.getBno());
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }   // rWrite 함수 end

    // 11. 조회수 증가 처리
    public boolean viewIncrease(int bno) {
        try {
            String sql = "update board set bview = bview + 1 where bno = ?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            int count = ps.executeUpdate();
            if(count == 1) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 12. 제목 검색 함수
    public ArrayList<BoardDto> search(String searchTitle) {
        ArrayList<BoardDto> list = new ArrayList<>();

        try {
            // String sql = "select * from board where btitle like '%제%';";                 // [O] : 문자일 때 작은따옴표 처리 해줬으니 가능
            // String sql = "select * from board where btitle like '%?%';";                 // [X] : ? 파라미터가 인식 불가능
            // String sql = "select * from board where btitle like ?;";                     // [O] : ? -> "%"+searchTitle+"%"       // 얘는 밑에 퍼센트 있는 걸로 써주고서 실행해보기
            // String sql = "select * from board where btitle like '%"+searchTitle+"%';";   // [O] : 연결연산자        // 얘는 밑에 거 다 주석 하고서 실행해보기
            // String sql = "select * from board where bview like %?%;";                    // [X]      // 얘는 ps.setInt(1, 3); 이거로 실행해보기
            // String sql = "select * from board where bview like %3%;";                    // [X]
            String sql = "select * from board b inner join member m on b.mno = m.mno where btitle like CONCAT('%', ?, '%') order by bdate desc";       // [O] SQL 제공하는 CONCAT('문자열', '문자열', '문자열') 문자열 연결 함수
            //String sql = "select * from board where btitle like '%\\?%';";        // '' 작은따옴표 포함해서 써줘야 함. 그렇지 않으면 오류
            // ?가 문자 처리 돼서 Parameter index out of range 오류 발생. 그래서 ? 앞에 \\를 붙여줌. 아니 이거 아닌 것 같아.
            ps = conn.prepareStatement(sql);

            // ps.setString(1, "%"+searchTitle+"%");       // 위에서 안 하고 여기서 "%"+searchTitle+"%"도 가능하긴 함.
            // ps.setString(1, searchTitle);
            // ps.setInt(1, 3);
            ps.setString(1, searchTitle);
            rs = ps.executeQuery();

            while (rs.next()) {
//                String btitle = rs.getString("btitle");
//                String bcontent = rs.getString("bcontent");
//                String bdate = rs.getString("bdate");
//                int bview = rs.getInt("bview");
//                int mno = rs.getInt("mno");
//                int bno = rs.getInt("bno");
//
//                // Dto 만들기
//                BoardDto boardDto = new BoardDto(btitle, bcontent, bdate, bview, mno, bno);     // Dto 1개 만들기

                BoardDto boardDto = new BoardDto(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getInt(6));
                boardDto.setMid(rs.getString("mid"));

                list.add(boardDto);     // 리스트에 dto 담기
            }
            return list;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

}   // class end

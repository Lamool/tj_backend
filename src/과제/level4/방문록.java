package 과제.level4;

public class 방문록 {
    // 멤버변수/필드
    int 방문록번호;
    String 내용;
    String 작성일;
    String 작성자;

    // 생성자
    public 방문록(int 방문록번호, String 내용, String 작성일, String 작성자) {
        this.방문록번호 = 방문록번호;
        this.내용 = 내용;
        this.작성일 = 작성일;
        this.작성자 = 작성자;
    }

    @Override
    public String toString() {
        return "방문록{" +
                "방문록번호=" + 방문록번호 +
                ", 내용='" + 내용 + '\'' +
                ", 작성일='" + 작성일 + '\'' +
                ", 작성자='" + 작성자 + '\'' +
                '}';
    }
}

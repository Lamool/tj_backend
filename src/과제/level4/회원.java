package 과제.level4;

public class 회원 {
    // 멤버변수/필드
    private int 회원번호;
    private String 아이디;
    private String 비밀번호;
    private String 이름;

    public int get회원번호() {
        return 회원번호;
    }

    public void set회원번호(int 회원번호) {
        this.회원번호 = 회원번호;
    }

    public String get아이디() {
        return 아이디;
    }

    public void set아이디(String 아이디) {
        this.아이디 = 아이디;
    }

    public String get비밀번호() {
        return 비밀번호;
    }

    public void set비밀번호(String 비밀번호) {
        this.비밀번호 = 비밀번호;
    }

    public String get이름() {
        return 이름;
    }

    public void set이름(String 이름) {
        this.이름 = 이름;
    }
}

package 과제.level4;

public class Level4_3 {
    public static void main(String[] args) {
        회원 회원1 = new 회원();
        회원 회원2 = new 회원();

        회원1.set회원번호(1);
        회원1.set아이디("abc");
        회원1.set비밀번호("def123");
        회원1.set이름("홍길동");

        회원2.set회원번호(2);
        회원2.set아이디("qqq");
        회원2.set비밀번호("ppp999");
        회원2.set이름("김말자");

        System.out.println("회원1 : " + 회원1.get회원번호() + ", " + 회원1.get아이디() + ", " + 회원1.get비밀번호() + ", " + 회원1.get이름());
        System.out.println("회원2 : " + 회원2.get회원번호() + ", " + 회원2.get아이디() + ", " + 회원2.get비밀번호() + ", " + 회원2.get이름());

    }

}

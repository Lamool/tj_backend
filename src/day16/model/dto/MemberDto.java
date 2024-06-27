package day16.model.dto;

public class MemberDto {    // 이동객체     // ((매개변수 많을 때(?) 일일이 다 쓸 수 없잖아. 이렇게 묶어서 줄 수 있음))
    // 1. 멤버변수 <---> DB 테이블 필드와 동일, private 권장
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
    private String mdate;
    private int mno;

    // 2. 생성자 : 기본생성자, 풀생성자
    public MemberDto() {}
    public MemberDto(String mid, String mpwd, String mname, String mphone, String mdate, int mno) {
        this.mid = mid;
        this.mpwd = mpwd;
        this.mname = mname;
        this.mphone = mphone;
        this.mdate = mdate;
        this.mno = mno;
    }
    // --- 회원가입용 생성자    ((회원가입할 때는 매개변수 이렇게 네 개 필요하니까 이걸 만들어 준 것))
    public MemberDto(String mid, String mpwd, String mname, String mphone) {
        this.mid = mid;
        this.mpwd = mpwd;
        this.mname = mname;
        this.mphone = mphone;
    }

    // 3. 메소드 : 1. getter/setter 2. toString()
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    @Override
    public String toString() {      // ((멤버변수의 값을 확인하기 위해 사용. 이걸 쓰지 않으면 객체의 주소값이 찍힘))
        return "MemberDto{" +
                "mid='" + mid + '\'' +
                ", mpwd='" + mpwd + '\'' +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                ", mdate='" + mdate + '\'' +
                ", mno=" + mno +
                '}';
    }
}

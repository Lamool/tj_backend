package day16.model.dto;            // 현재 클래스 파일이 위치한 폴더/패키지명 // 클래스 생성시 자동으로 할당된다

// 이동객체     // ((매개변수 많을 때 일일이 다 쓸 수 없잖아. 이렇게 묶어서 줄 수 있음))
public class MemberDto {           // MemberDto 클래스 선언

    // DB테이블의 회원마다 레코드/행 1개이고 레코드/행 1개당 DTO 1개
    // -> 회원이 여러 개이면 DTO 여러 개 -> ArrayList<MemberDto>
    // Dto는 데이터 여러 개를 운반하고 그러는 애이기 때문에(?) 싱글톤을 쓰면 안 된다
    // Controller 같은 경우 기능을 담당하는 애니까

    // 1. 멤버변수 <---> DB 테이블 필드와 동일, private 권장
    private String mid;         // 아이디      // 접근제한자가 private이고 String으로 선언된 멤버변수
    private String mpwd;        // 비밀번호    // 접근제한자가 private이고 String으로 선언된 멤버변수
    private String mname;       // 이름       // 접근제한자가 private이고 String으로 선언된 멤버변수
    private String mphone;      // 전화번호    // 접근제한자가 private이고 String으로 선언된 멤버변수
    private String mdate;       // 가입일      // 접근제한자가 private이고 String으로 선언된 멤버변수
    private int mno;            // 회원번호    // 접근제한자가 private이고 int형으로 선언된 멤버변수

    // 2. 생성자 : 기본생성자, 풀생성자
    public MemberDto() {}           // 매개변수와 실행문이 없는 기본생성자이다

    // 매개변수(String mid, String mpwd, String mname, String mphone, String mdate, int mno)로 값을 받아 각 객체의 멤버변수 초기값을 지정해주는 생성자이다
    public MemberDto(String mid, String mpwd, String mname, String mphone, String mdate, int mno) {     // 풀생성자 start
        this.mid = mid;         // this : 매개변수와 멤버변수간의 이름이 동일할 때 식별하기 위해 사용한다
        this.mpwd = mpwd;
        this.mname = mname;
        this.mphone = mphone;
        this.mdate = mdate;
        this.mno = mno;
    }       // 풀생성자 end

    // --- 회원가입용 생성자    ((회원가입할 때는 매개변수 이렇게 네 개(아이디, 비밀번호, 이름, 전화번호)가 필요해서 이걸 따로 만들어 주었다))
    public MemberDto(String mid, String mpwd, String mname, String mphone) {        // 회원가입용 생성자 start
        this.mid = mid;
        this.mpwd = mpwd;
        this.mname = mname;
        this.mphone = mphone;
    }       // 회원가입용 생성자 end

    // 3. 메소드 : 1. getter/setter 2. toString()
    // getter and setter : 클래스의 멤버변수(특히 멤버변수가 private일 때)에 접근하고 값을 설정하는 메소드를 의미한다
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
    public String toString() {      // toString : ((멤버변수의 값을 확인하기 위해 사용한다. toString을 쓰지 않으면 객체의 주소값을 담은 변수만을 이용해 객체를 출력했을 때 주소값이 출력된다))
        return "MemberDto{" +
                "mid='" + mid + '\'' +
                ", mpwd='" + mpwd + '\'' +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                ", mdate='" + mdate + '\'' +
                ", mno=" + mno +
                '}';
    }   // toString() end
}   // class end

package day16.controller;

import day16.model.dao.MemberDao;
import day16.model.dto.MemberDto;

public class MemberController {
    // 0.
    public static MemberController mcontrol = new MemberController();


    // 1. 회원가입 화면 함수, 매개변수 : MemberDto(아이디 String, 비번 String, 이름 String, 전화번호 String), 반환값 : 회원가입 성공 여부 boolean
    public boolean signup(MemberDto memberDto) {
        boolean result = MemberDao.mdao.signup(memberDto);
        return result;
    }

    // 2. 로그인 화면 함수 ㅡ 매개변수 : MemberDto(아이디, 비밀번호), 리턴값 : boolean (성공 / 실패)
    public boolean login(MemberDto memberDto) {
        return MemberDao.mdao.login(memberDto);
    }

    // 3.

    // 3. 아이디찾기 화면 함수, 매개변수 : MemberDto(이름, 전화번호), 리턴값 : String (찾은 아이디 / null) - 찾았으면 문자열이 들어있고 못찾았으면 null 대입
    public String findId(MemberDto memberDto) {
        return MemberDao.mdao.findId(memberDto);
    }

    // 4. 비밀번호찾기 화면 함수, 매개변수 : MemberDto(아이디, 전화번호), 리턴값 : String (찾은 비밀번호 / null) - 찾았으면 문자열이 들어있고 못찾았으면 null 대입
    public String findPwd(MemberDto memberDto) {
        return MemberDao.mdao.findPwd(memberDto);
    }

}

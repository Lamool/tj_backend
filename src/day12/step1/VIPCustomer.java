package day12.step1;

public class VIPCustomer extends Customer {
                    // extends : 상속
    private int agentID;
    double saleRatio;

    public VIPCustomer() {
        // customerGrade, bonusRatio 오류 나는 이유 : 현재 클래스내 customerGrade 변수가 없으니까.
        // 상속을 받아도 상위 클래스 멤버변수가 private면 사용 불가능
        customerGrade = "VIP";
        bonusRatio = 0.05;
        saleRatio = 0.1;
    }
    public int getAgentID(){
        return agentID;
    }

}

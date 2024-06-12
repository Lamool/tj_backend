package day05;

public class Step1 {
    public static void main(String[] args) {
        // p.94
        int age = 7;
        if (age >= 8) {
            System.out.println("학교에 다닙니다.");
        } else {
            System.out.println("학교에 다니지 않습니다.");
        }

        // p.97
        int age2 = 9;
        int charge;
        if (age2 < 8) {
            charge = 1000;
            System.out.println("취학 전 아동입니다.");
        } else if (age < 14) {
            charge = 2000;
            System.out.println("초등학생입니다.");
        } else if (age < 19) {
            charge = 2500;
            System.out.println("중, 고등학생입니다.");
        } else {
            charge = 3000;
            System.out.println("일반인입니다.");
        }

        System.out.println("입장료는 " + charge + "원 입니다.");

        // p.1o2;
            // switch : 하나의 값을 비교할 때 주로, 논리(
            // break
        int ranking = 1;
        char medalColor;

        switch (ranking) {           // switch(검사대상){}
            case 1 : medalColor = 'G';
                System.out.println("TV");   // case 검사결과 : 실행문;
                break;
            case 2 : medalColor = 'S';
                System.out.println("냉장고");
                break;
            case 3 : medalColor = 'B';
                System.out.println("에어컨");
                break;
            default : medalColor = 'A';

                break;
        }
        System.out.println(ranking + "등 메달의 색깔은" + medalColor);





        // p.105
        String medal = "Gold";

        // switch (누구를) {}
        switch (medal) {
            case "Gold" :       // case 결과비교
                System.out.println("금메달");
                break;
            case "Silver" :
                System.out.println("은메달");
                break;
            case "Bronze" :
                System.out.println("동메달");
                break;
            default :
                System.out.println("메달이 없습니다.");
                break;

        }

    }

}

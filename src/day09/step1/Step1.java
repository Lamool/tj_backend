package day09.step1;

public class Step1 {
    public static void main(String[] args) {

        // [1] 학생(객체) 2명 생성
        Student studentJames = new Student("James", 5000);
            // Student 클래스내 기본/디폴트 생성자가 없으므로 오류
            // Student studentJames2 = new Student();
        Student studentTomas = new Student("Tomas", 10000);

        // [2] 버스 1대 생성
        Bus bus100 = new Bus(100);
            // 제임스가 100번 노선의 버스 탑니다
        studentJames.takeBus(bus100);
        System.out.println(studentJames);
        System.out.println(bus100);

        // [3] 지하철 1대 생성
        Subway subwayGreen = new Subway("2호선");
        studentTomas.takeSubway(subwayGreen);
        System.out.println(studentTomas);
        System.out.println(subwayGreen);
    }

    // [4] 188p. Edward 학생이 늦잠 자서 택시 타고 학교에
    Student studentEdward = new Student("Edward", 15000);
    Taxi taxiKakao = new Taxi("카카오");
    //studentEdward.takeTaxi(taxiKakao);


}

package day14.step3;

public class CustomerTest {
    public static void main(String[] args) {
        //Buy buyer;
        //buyer.buy();    // 구현을 안 했기 때문에 안 됨

        // 객체 생성
        Customer customer = new Customer();

        // customer 타입이 Buy 타입 변환 (자동 타입 변환)
        Buy buyer = customer;
        buyer.buy();
        buyer.order();

        // customer 타입이 Sell 타입 변환 (자동 타입 변환)
        Sell seller = customer;
        seller.sell();
        seller.order();

        if (seller instanceof Customer) {       // seller 타입이 Customer 타입에 포함되었는가 -> 포함되어 있다. Customer가 Buy랑 Sell을 구현했기 때문에.
            Customer customer2 = (Customer)seller;
            customer2.buy();
            customer2.sell();
        }

        customer.order();


        Buy.pay();
        Sell.pay();


    }

}

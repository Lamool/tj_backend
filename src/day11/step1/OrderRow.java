package day11;

public class OrderRow {

    private  int orderCode;                            //멤버변수: 데이터이름 선언
    private String orderDate;


    public OrderRow(int orderCode, String orderDate) {
        this.orderCode = orderCode;
        this.orderDate = orderDate;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderRow{" +
                "orderCode=" + orderCode +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}

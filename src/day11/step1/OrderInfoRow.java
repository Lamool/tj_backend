package day11;

public class OrderInfoRow {

    private int orderInfoCode;
    private int orderAmount;
    private int menuCode;
    private int orderCode;

    public OrderInfoRow(int orderInfoCode, int orderAmount, int menuCode, int orderCode) {
        this.orderInfoCode = orderInfoCode;
        this.orderAmount = orderAmount;
        this.menuCode = menuCode;
        this.orderCode = orderCode;
    }

    public int getOrderInfoCode() {
        return orderInfoCode;
    }

    public void setOrderInfoCode(int orderInfoCode) {
        this.orderInfoCode = orderInfoCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "OrderInfoRow{" +
                "orderInfoCode=" + orderInfoCode +
                ", orderAmount=" + orderAmount +
                ", menuCode=" + menuCode +
                ", orderCode=" + orderCode +
                '}';
    }
}

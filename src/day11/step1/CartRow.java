package day11;

public class CartRow {
    private int cartCode;
    private int menuCode;
    private int orderAmount;

    public CartRow(int cartCode, int menuCode, int orderAmount) {
        this.cartCode = cartCode;
        this.menuCode = menuCode;
        this.orderAmount = orderAmount;
    }

    public int getCartCode() {
        return cartCode;
    }

    public void setCartCode(int cartCode) {
        this.cartCode = cartCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "CartRow{" +
                "cartCode=" + cartCode +
                ", menuCode=" + menuCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}

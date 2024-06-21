package day11;

public class MenuRow {

    private  int menuCode;
    private int categoryCode;
    private int menuPrice;
    private String menuName;

    public MenuRow(int menuCode, int categoryCode, int menuPrice, String menuName) {
        this.menuCode = menuCode;
        this.categoryCode = categoryCode;
        this.menuPrice = menuPrice;
        this.menuName = menuName;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "MenuRow{" +
                "menuCode=" + menuCode +
                ", categoryCode=" + categoryCode +
                ", menuPrice=" + menuPrice +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}

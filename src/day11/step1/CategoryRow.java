package day11;

public class CategoryRow {
    private int categoryCode;
    private String categoryName;

    public CategoryRow() {}
    public CategoryRow(int categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryRow{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

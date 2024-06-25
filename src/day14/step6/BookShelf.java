package day14.step6;

public class BookShelf extends Shelf implements Queue {
    @Override
    public void enQueue(String title) {
        super.shelf.add(title);
        // super
    }

    @Override
    public String deQueue() {
        return "";
    }

    @Override
    public int getSize() {
        return 0;
    }
}

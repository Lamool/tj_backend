package day14.step6;

public class BookShelf extends Shelf implements Queue {
    @Override
    public void enQueue(String title) {
        super.shelf.add(title);
        // super
    }

    @Override
    public String deQueue() {
        return super.shelf.remove( 0 );
    }

    @Override
    public int getSize() {
        return super.getCount();
    }
}

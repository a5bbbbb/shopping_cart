package patterns.creational;

public class Book extends Item {
    public Book(int id) {
        super(id);
    }

    @Override
    public double getPrice() {
        return 20.0;
    }
}
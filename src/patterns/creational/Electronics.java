package patterns.creational;

public class Electronics extends Item {
    public Electronics(int id) {
        super(id);
    }

    @Override
    public double getPrice() {
        return 100.0;
    }
}
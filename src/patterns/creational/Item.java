package patterns.creational;

public abstract class Item {
    private int id;

    public Item(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public abstract double getPrice();
}

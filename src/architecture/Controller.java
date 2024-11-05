package architecture;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void updateTotalPrice(double price) {
        model.setTotalPrice(price);
        view.displayTotalPrice(price);
    }
}
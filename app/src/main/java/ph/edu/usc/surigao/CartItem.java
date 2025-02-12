package ph.edu.usc.surigao;

public class CartItem {
    private String name;
    private int quantity;

    public CartItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }
}

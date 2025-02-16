package ph.edu.usc.surigao;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class AdoptCheckoutActivity extends AppCompatActivity {

    private LinearLayout cartLayout;
    private static ArrayList<CartItem> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_checkout);

        cartLayout = findViewById(R.id.cartContainer);
        Button checkoutButton = findViewById(R.id.button4);

        displayCartItems();

        checkoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdoptCheckoutActivity.this, AdoptOptionsActivity.class);
            startActivity(intent);
        });
    }

    private void displayCartItems() {
        cartLayout.removeAllViews();

        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getQuantity() > 0) {
                addItemToCheckout(item);
            } else {
                iterator.remove();
            }
        }
    }

    private void addItemToCheckout(CartItem item) {
        View itemView = LayoutInflater.from(this).inflate(R.layout.cart_item, cartLayout, false);

        ImageView itemImage = itemView.findViewById(R.id.cartItemImage);
        TextView itemName = itemView.findViewById(R.id.cartItemName);
        TextView itemQuantity = itemView.findViewById(R.id.cartItemQuantity);
        Button removeButton = itemView.findViewById(R.id.cartItemRemove);

        itemName.setText(item.getName());
        itemQuantity.setText("Quantity: " + item.getQuantity());
        itemImage.setImageResource(item.getImageResId());

        removeButton.setOnClickListener(v -> {
            item.decreaseQuantity();
            displayCartItems();
        });

        cartLayout.addView(itemView);
    }

    public static void addToCart(String name, String price, int imageResId, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getName().equals(name)) {
                item.increaseQuantity(quantity);
                return;
            }
        }
        cartItems.add(new CartItem(name, price, imageResId, quantity));
    }

    public static class CartItem {
        private String name;
        private String price;
        private int imageResId;
        private int quantity;

        public CartItem(String name, String price, int imageResId, int quantity) {
            this.name = name;
            this.price = price;
            this.imageResId = imageResId;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public int getImageResId() {
            return imageResId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void increaseQuantity(int amount) {
            quantity += amount;
        }

        public void decreaseQuantity() {
            if (quantity > 0) {
                quantity--;
            }
        }
    }
}
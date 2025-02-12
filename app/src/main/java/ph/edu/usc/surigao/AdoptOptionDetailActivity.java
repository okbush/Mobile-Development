package ph.edu.usc.surigao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdoptOptionDetailActivity extends AppCompatActivity {

    private TextView productName, quantityText;
    private int quantity = 1;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_option_detail);

        productName = findViewById(R.id.textView);
        quantityText = findViewById(R.id.num);
        Button increaseButton = findViewById(R.id.increase);
        Button decreaseButton = findViewById(R.id.decrease);
        Button addToCartButton = findViewById(R.id.button);
        Button backButton = findViewById(R.id.button_keep_browsing);

        name = getIntent().getStringExtra("productName");
        productName.setText(name);
        quantityText.setText(String.valueOf(quantity));

        increaseButton.setOnClickListener(v -> {
            quantity++;
            quantityText.setText(String.valueOf(quantity));
        });

        decreaseButton.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                quantityText.setText(String.valueOf(quantity));
            }
        });

        addToCartButton.setOnClickListener(v -> {
            AdoptCheckoutActivity.addToCart(name, quantity);
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdoptOptionDetailActivity.this, AdoptOptionsActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

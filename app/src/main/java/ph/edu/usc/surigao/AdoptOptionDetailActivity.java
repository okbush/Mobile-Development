package ph.edu.usc.surigao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdoptOptionDetailActivity extends AppCompatActivity {

    private TextView productName, quantityText, priceText;
    private int quantity = 1;
    private String name, price;
    private ImageView productImageView;
    private int imageResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_option_detail);

        productName = findViewById(R.id.textView);
        priceText = findViewById(R.id.textView2);
        quantityText = findViewById(R.id.num);
        productImageView = findViewById(R.id.imageView3);
        Button increaseButton = findViewById(R.id.increase);
        Button decreaseButton = findViewById(R.id.decrease);
        Button addToCartButton = findViewById(R.id.button);
        Button backButton = findViewById(R.id.button_keep_browsing);

        Intent intent = getIntent();
        name = intent.getStringExtra("productName");
        price = intent.getStringExtra("productPrice");
        imageResId = intent.getIntExtra("productImage", R.drawable.option1);

        productName.setText(name);
        priceText.setText(price);
        productImageView.setImageResource(imageResId);
        quantityText.setText(String.valueOf(quantity));

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantityText.setText(String.valueOf(quantity));
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) {
                    quantity--;
                    quantityText.setText(String.valueOf(quantity));
                }
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdoptCheckoutActivity.addToCart(name, price, imageResId, quantity);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(AdoptOptionDetailActivity.this, AdoptOptionsActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
    }
}

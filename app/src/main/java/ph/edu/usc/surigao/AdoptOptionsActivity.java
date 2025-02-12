package ph.edu.usc.surigao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdoptOptionsActivity extends AppCompatActivity {

    Button btnLogout, btnCheckCart, btnProduct1, btnProduct2, btnProduct3, btnProduct4, btnProduct5, btnProduct6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_options);

        btnLogout = findViewById(R.id.logout);
        btnCheckCart = findViewById(R.id.checkcart);
        btnProduct1 = findViewById(R.id.product1_price);
        btnProduct2 = findViewById(R.id.product2_price);
        btnProduct3 = findViewById(R.id.product3_price);
        btnProduct4 = findViewById(R.id.product4_price);
        btnProduct5 = findViewById(R.id.product5_price);
        btnProduct6 = findViewById(R.id.product6_price);


        setupUI();
    }

    public void setupUI() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent optionsIntent = new Intent(AdoptOptionsActivity.this, AdoptLoginActivity.class);
                startActivity(optionsIntent);
                finish();
            }
        });

        btnCheckCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent optionsIntent = new Intent(AdoptOptionsActivity.this, AdoptCheckoutActivity.class);
                startActivity(optionsIntent);
            }
        });

        btnProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(AdoptOptionsActivity.this, AdoptOptionDetailActivity.class);
                detailIntent.putExtra("productName", "Pusheen Coookie");
                detailIntent.putExtra("productPrice", "$100");
                startActivity(detailIntent);
            }
        });

        btnProduct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(AdoptOptionsActivity.this, AdoptOptionDetailActivity.class);
                detailIntent.putExtra("productName", "Pusheen Plushie");
                detailIntent.putExtra("productPrice", "$1000");
                startActivity(detailIntent);
            }
        });

        btnProduct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(AdoptOptionsActivity.this, AdoptOptionDetailActivity.class);
                detailIntent.putExtra("productName", "Giant Pusheen");
                detailIntent.putExtra("productPrice", "$50");
                startActivity(detailIntent);
            }
        });

        btnProduct4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(AdoptOptionsActivity.this, AdoptOptionDetailActivity.class);
                detailIntent.putExtra("productName", "Pusheen Plushie");
                detailIntent.putExtra("productPrice", "$99");
                startActivity(detailIntent);
            }
        });

        btnProduct5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(AdoptOptionsActivity.this, AdoptOptionDetailActivity.class);
                detailIntent.putExtra("productName", "Pusheen Pouch");
                detailIntent.putExtra("productPrice", "$40");
                startActivity(detailIntent);
            }
        });

        btnProduct6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(AdoptOptionsActivity.this, AdoptOptionDetailActivity.class);
                detailIntent.putExtra("productName", "Pusheen Hoodie");
                detailIntent.putExtra("productPrice", "$70");
                startActivity(detailIntent);
            }
        });
    }
}

package ph.edu.usc.surigao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdoptOptionsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button btnLogout, btnCheckCart, btnAddtoCart;

    Spinner spinProduct;
    ListView list;

    private String[] products = { "Pusheen Cookie", "Pusheen Toes", "Pusheen Keychain", "Giant Pusheen", "Pusheen Pouch", "Pusheen Hooodie",};

    private String[] prices = {"$100", "$150", "30", "$9999", "$15", "$75"};

    Integer[] imgid = {
            R.drawable.option1,
            R.drawable.option2,
            R.drawable.option3,
            R.drawable.option4,
            R.drawable.option5,
            R.drawable.option6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_options);

        btnLogout = findViewById(R.id.logout);
        btnCheckCart = findViewById(R.id.checkcart);

        spinProduct = findViewById(R.id.spinproduct);
        spinProduct.setOnItemSelectedListener(this);

        list = findViewById(R.id.list);

        ArrayAdapter<String> arrProducts = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,
                products
        );

        spinProduct.setAdapter(arrProducts);

        ArrayAdapter<String> arrPrices = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                prices
        );

        list.setAdapter(arrPrices);

        MyProductAdapter adapter = new MyProductAdapter( this, products, prices, imgid);
        list.setAdapter(adapter);

        setupUI();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), products[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

    }
}

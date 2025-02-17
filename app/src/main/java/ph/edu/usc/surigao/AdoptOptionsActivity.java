package ph.edu.usc.surigao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdoptOptionsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnLogout, btnCheckCart;
    Spinner spinProduct;
    ListView list;

    private String[] products = {"Display All", "Pusheen Cookie", "Pusheen Toes", "Pusheen Keychain", "Giant Pusheen", "Pusheen Pouch", "Pusheen Hoodie"};
    private String[] prices = {"$0", "$100", "$150", "$30", "$9999", "$15", "$75"};

    Integer[] imgid = {
            R.drawable.default_image,
            R.drawable.option1,
            R.drawable.option2,
            R.drawable.option3,
            R.drawable.option4,
            R.drawable.option5,
            R.drawable.option6
    };

    private List<String> filteredProducts;
    private List<String> filteredPrices;
    private List<Integer> filteredImages;
    private MyProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_options);

        btnLogout = findViewById(R.id.logout);
        btnCheckCart = findViewById(R.id.checkcart);

        spinProduct = findViewById(R.id.spinproduct);
        spinProduct.setOnItemSelectedListener(this);

        list = findViewById(R.id.list);

        ArrayAdapter<String> arrProducts = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, products);
        arrProducts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinProduct.setAdapter(arrProducts);

        filteredProducts = new ArrayList<>(Arrays.asList(products).subList(1, products.length));
        filteredPrices = new ArrayList<>(Arrays.asList(prices).subList(1, prices.length));
        filteredImages = new ArrayList<>(Arrays.asList(imgid).subList(1, imgid.length));

        adapter = new MyProductAdapter(this, filteredProducts, filteredPrices, filteredImages);
        list.setAdapter(adapter);

        setupUI();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        filterProducts(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    private void filterProducts(int position) {
        filteredProducts.clear();
        filteredPrices.clear();
        filteredImages.clear();

        if (position == 0) {
            filteredProducts.addAll(Arrays.asList(products).subList(1, products.length));
            filteredPrices.addAll(Arrays.asList(prices).subList(1, prices.length));
            filteredImages.addAll(Arrays.asList(imgid).subList(1, imgid.length));
        } else {
            filteredProducts.add(products[position]);
            filteredPrices.add(prices[position]);
            filteredImages.add(imgid[position]);
        }

        adapter.notifyDataSetChanged();
    }

    public void setupUI() {
        btnLogout.setOnClickListener(v -> {
            Intent optionsIntent = new Intent(AdoptOptionsActivity.this, AdoptLoginActivity.class);
            startActivity(optionsIntent);
            finish();
        });

        btnCheckCart.setOnClickListener(v -> {
            Intent optionsIntent = new Intent(AdoptOptionsActivity.this, AdoptCheckoutActivity.class);
            startActivity(optionsIntent);
        });
    }
}
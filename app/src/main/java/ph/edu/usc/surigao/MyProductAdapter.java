package ph.edu.usc.surigao;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyProductAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> products;
    private final List<String> prices;
    private final List<Integer> imgid;

    public MyProductAdapter(Activity context, List<String> products, List<String> prices, List<Integer> imgid) {
        super(context, R.layout.product_item, products);
        this.context = context;
        this.products = products;
        this.prices = prices;
        this.imgid = imgid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.product_item, null, true);

        ImageView img = rowView.findViewById(R.id.imgid);
        TextView textheader = rowView.findViewById(R.id.productname);
        TextView textsub = rowView.findViewById(R.id.productprice);
        Button addButton = rowView.findViewById(R.id.addtocart);

        img.setImageResource(imgid.get(position));
        textheader.setText(products.get(position));
        textsub.setText(prices.get(position));

        addButton.setOnClickListener(v -> {
            Intent detailIntent = new Intent(context, AdoptOptionDetailActivity.class);
            detailIntent.putExtra("productName", products.get(position));
            detailIntent.putExtra("productPrice", prices.get(position));
            detailIntent.putExtra("productImage", imgid.get(position));
            context.startActivity(detailIntent);
        });

        return rowView;
    }
}
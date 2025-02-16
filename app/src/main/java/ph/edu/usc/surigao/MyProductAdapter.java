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

public class MyProductAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] products;
    private final String[] prices;
    private final Integer[] imgid;

    public MyProductAdapter(Activity context, String[] products, String[] prices, Integer[] imgid) {
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

        img.setImageResource(imgid[position]);
        textheader.setText(products[position]);
        textsub.setText(prices[position]);

        addButton.setOnClickListener(v -> {
            Intent detailIntent = new Intent(context, AdoptOptionDetailActivity.class);
            detailIntent.putExtra("productName", products[position]);
            detailIntent.putExtra("productPrice", prices[position]);
            detailIntent.putExtra("productImage", imgid[position]);
            context.startActivity(detailIntent);
        });

        return rowView;
    }
}

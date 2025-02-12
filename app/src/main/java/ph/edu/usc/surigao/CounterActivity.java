package ph.edu.usc.surigao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CounterActivity extends AppCompatActivity {
    Button decrease, increase, btnNext;
    TextView num, txtname, txtcourse, txtyear, txtwham;
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        txtname = findViewById(R.id.txtName);
        txtname.setText(getIntent().getStringExtra("etname"));

        txtcourse = findViewById(R.id.txtCourse);
        txtcourse.setText(getIntent().getStringExtra("etcourse"));

        txtyear = findViewById(R.id.txtYear);
        txtyear.setText(getIntent().getStringExtra("etyear"));

        txtwham = findViewById(R.id.txtWHAM);
        txtwham.setText(getIntent().getStringExtra("etwham"));

        btnNext = findViewById(R.id.bNext);
        imgProfile = findViewById(R.id.simg);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        if (byteArray != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imgProfile.setImageBitmap(bitmap);
        }

        decrease = findViewById(R.id.decrease);
        increase = findViewById(R.id.increase);
        num = findViewById(R.id.num);

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(num.getText().toString());
                if (x != 0) {
                    num.setText(String.valueOf(x - 1));
                }
            }
        });

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(String.valueOf(Integer.parseInt(num.getText().toString()) + 1));
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent counterIntent = new Intent(CounterActivity.this, MainActivity.class);
                startActivity(counterIntent);
            }
        });
    }
}

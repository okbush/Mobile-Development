package ph.edu.usc.surigao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    TextView sName, sCourse, sYear, sWHAM;
    ImageView imgProfile;
    Button btnAction, btnNext;
    EditText edName, edCourse, edYear, edWHAM;
    String txtname, txtcourse, txtyear, txtwham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sName = findViewById(R.id.sname);
        sCourse = findViewById(R.id.scourse);
        sYear = findViewById(R.id.syear);
        sWHAM = findViewById(R.id.swham);
        imgProfile = findViewById(R.id.simg);
        btnAction = findViewById(R.id.button2);
        edName = findViewById(R.id.edName);
        edCourse = findViewById(R.id.edCourse);
        edYear = findViewById(R.id.edYear);
        edWHAM = findViewById(R.id.edWHAM);
        btnNext = findViewById(R.id.bNext);

        setupUI();
    }

    public void setupUI() {
        sName.setVisibility(View.GONE);
        sCourse.setVisibility(View.GONE);
        sYear.setVisibility(View.GONE);
        sWHAM.setVisibility(View.GONE);
        imgProfile.setVisibility(View.GONE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtname = sName.getText().toString();
                txtcourse = sCourse.getText().toString();
                txtyear = sYear.getText().toString();
                txtwham = sWHAM.getText().toString();

                Intent counterIntent = new Intent(MainActivity.this, CounterActivity.class);
                counterIntent.putExtra("etname", txtname);
                counterIntent.putExtra("etcourse", txtcourse);
                counterIntent.putExtra("etyear", txtyear);
                counterIntent.putExtra("etwham", txtwham);

                BitmapDrawable drawable = (BitmapDrawable) imgProfile.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                counterIntent.putExtra("image", byteArray);

                startActivity(counterIntent);
            }
        });

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edName.getText().toString();
                sName.setText("Name: " + name);
                String course = edCourse.getText().toString();
                sCourse.setText("Course: " + course);
                String year = edYear.getText().toString();
                sYear.setText("Year: " + year);
                String wham = edWHAM.getText().toString();
                sWHAM.setText("WHAM: " + wham);

                sName.setVisibility(View.VISIBLE);
                sCourse.setVisibility(View.VISIBLE);
                sYear.setVisibility(View.VISIBLE);
                sWHAM.setVisibility(View.VISIBLE);
                imgProfile.setVisibility(View.VISIBLE);

                btnAction.setText("Save");
            }
        });
    }
}

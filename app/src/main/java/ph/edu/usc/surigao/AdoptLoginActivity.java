package ph.edu.usc.surigao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdoptLoginActivity extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_login);

        btnLogin = findViewById(R.id.bLogin);

        setupUI();
    }

    public void setupUI() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent optionsIntent = new Intent(AdoptLoginActivity.this, AdoptOptionsActivity.class);
                startActivity(optionsIntent);
                finish();
            }
        });
    }
}

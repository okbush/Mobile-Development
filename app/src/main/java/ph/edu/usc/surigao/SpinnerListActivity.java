package ph.edu.usc.surigao;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpinnerListActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinCourse;
    ListView list;

    private String[] courses = {
            "Android", "C Programming", "Java", "Python"
    };

    private String[] topics = {"Basic android", "Advance Android", "Google Maps", "Android Sensors"};

    Integer[] imgid = {
            R.drawable.miffy,
            R.drawable.option1,
            R.drawable.option2,
            R.drawable.option3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_list);

        spinCourse = findViewById(R.id.spincourse);
        spinCourse.setOnItemSelectedListener(this);

        list = findViewById(R.id.list);

        ArrayAdapter<String> arrCourses = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,
                courses
        );

        spinCourse.setAdapter(arrCourses);

        ArrayAdapter<String> arrTopics = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                topics
        );

        list.setAdapter(arrTopics);


        MyListAdapter adapter = new MyListAdapter(this, courses, topics, imgid);
        list.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), courses[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
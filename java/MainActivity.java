package com.example.jalgibook;

import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Jalgi> jalgiii;
    private int selectedIndex = -1;
    private JalgiAdapter adapter;
    private ListView listView;
    private TextView weight, description, aura, girth, title;
    private ImageView imageView;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);
        title = findViewById(R.id.title);
        weight = findViewById(R.id.textView);
        description = findViewById(R.id.textView1);
        aura = findViewById(R.id.textView2);
        girth = findViewById(R.id.textView3);
        imageView = findViewById(R.id.imageView);
        back = findViewById(R.id.back);

        if (back != null) {
            back.setOnClickListener(v -> setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT));
        }

        if (savedInstanceState != null) {
            jalgiii = (ArrayList<Jalgi>) savedInstanceState.getSerializable("jalgotes");
            selectedIndex = savedInstanceState.getInt("selectedIndex", -1);
        } else {
            jalgiii = new ArrayList<>();
            jalgiii.add(new Jalgi("Gloomy Jalgi", 660, "He walks around grieving about his life choices and how he has messed up.", 21, 51, R.drawable.ic_launcher_background));
            jalgiii.add(new Jalgi("Cheerful Jalgi", 240, "He is excited for anything and is cheerful for whatever comes his way, and is never negative.", 56, 42, R.drawable.ic_launcher_background));
            jalgiii.add(new Jalgi("Moody Jalgi", 520, "Moody Jalgi is always like a switch, sometimes happy, sometimes sad. It fluctuates with his surroundings.", 11, 12, R.drawable.ic_launcher_background));
            jalgiii.add(new Jalgi("Chill Jalgi", 670, "Chill Jalgi is the group leader, always leading everyone into success and helping the young through hardships.", 65, 63, R.drawable.ic_launcher_background));
            jalgiii.add(new Jalgi("Joyful Jalgi", 170, "Joyful Jalgi is always affecting the people around him with positive vibes. Too MUCH AURA!", 76, 36, R.drawable.ic_launcher_background));
            jalgiii.add(new Jalgi("Lonely Jalgi", 870, "Lonely Jalgi sits on a couch all day pondering what he could have done to turn his life around and not be such a failure in the garage.", 1, 78, R.drawable.ic_launcher_background));
            jalgiii.add(new Jalgi("Ecstatic Jalgi", 240, "Ecstatic Jalgi learns new skills, such as baking, and he loves baking brownies and cookies for everyone.", 42, 34, R.drawable.ic_launcher_background));
            jalgiii.add(new Jalgi("Jalgi Dar", 1111, "Jalgi Dar first started as an animated dog character now to a gigantic consuming machine destroying everything in its path.", 67, 111, R.drawable.ic_launcher_background));
            jalgiii.add(new Jalgi("Jalgi Kirk", 677, "Jalgi Kirk started as a trend that started off strong in 2025 and died in 2026, but people still remember his aura and his presence.", 677, 890, R.drawable.ic_launcher_background));
        }

        adapter = new JalgiAdapter(this, jalgiii);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        });

        if (selectedIndex != -1 && selectedIndex < jalgiii.size() && weight != null) {
            Jalgi j = jalgiii.get(selectedIndex);
            weight.setText("Weight: " + j.getWeight());
            description.setText("Description: " + j.getDescription());
            aura.setText("Aura: " + j.getAura());
            girth.setText("Girth: " + j.getGirth());
            imageView.setImageResource(j.getImageResId());
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("jalgotes", jalgiii);
        outState.putInt("selectedIndex", selectedIndex);
    }
}

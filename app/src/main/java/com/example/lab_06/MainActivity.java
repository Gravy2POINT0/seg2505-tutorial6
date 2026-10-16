package com.example.lab_06;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = (Button) findViewById(R.id.button);

        String[] months = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        CustomAdapter customAdapter = new CustomAdapter(months);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(
                this.findViewById(R.id.my_recycler_view),
                (v, insets) -> {
                    Insets innerPadding = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars() |
                                    WindowInsetsCompat.Type.displayCutout()
                            // If using EditText, also add
                            // "| WindowInsetsCompat.Type.ime()" to
                            // maintain focus when opening the IME
                    );
                    v.setPadding(
                            innerPadding.left,
                            innerPadding.top,
                            innerPadding.right,
                            innerPadding.bottom
                    );
                    return insets;
                }
        );

    }
}
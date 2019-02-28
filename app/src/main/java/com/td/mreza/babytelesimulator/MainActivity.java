package com.td.mreza.babytelesimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearBtn = findViewById(R.id.clear_btn);
        Button refreshBtn = findViewById(R.id.refresh_btn);
        Button getBtn = findViewById(R.id.get_btn);
        LinearLayout linearLayout = findViewById(R.id.linear_layout);

    }
}

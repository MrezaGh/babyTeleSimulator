package com.td.mreza.babytelesimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

//todo : classes should be singleton

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MessageController messageController = new MessageController();

        messageController.fetch(false);

        Button clearBtn = findViewById(R.id.clear_btn);//done!
        Button refreshBtn = findViewById(R.id.refresh_btn);//todo:
        Button getBtn = findViewById(R.id.get_btn);//todo
        final LinearLayout linearLayout = findViewById(R.id.linear_layout);


        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeAllViews();
            }
        });

    }
}

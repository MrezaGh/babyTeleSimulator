package com.td.mreza.babytelesimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

//todo : classes should be singleton

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MessageController messageController = new MessageController(getBaseContext());


//        messageController.fetch(false, 0);
//        messageController.fetch(false, 10);
//        messageController.fetch(false, 20);

//        messageController.fetch(true, 0);

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

package com.td.mreza.babytelesimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//todo : classes should be singleton

public class MainActivity extends AppCompatActivity implements Observer  {


    LinearLayout linearLayout;
    MessageController messageController;
    NotificationCenter notificationCenter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.mehrdad);
        notificationCenter = new NotificationCenter();
        messageController = new MessageController(getBaseContext(), notificationCenter);
        linearLayout = findViewById(R.id.linear_layout);
        notificationCenter.register(this);

        messageController.fetch(false, 0);
        

//        messageController.fetch(false, 10);
//        messageController.fetch(false, 20);

//        messageController.fetch(true, 0);

        Button clearBtn = findViewById(R.id.clear_btn);//done!
        Button refreshBtn = findViewById(R.id.refresh_btn);//todo:
        Button getBtn = findViewById(R.id.get_btn);//todo




        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeAllViews();
            }
        });


    }
    private String name;
    private Subject topic;


    @Override
    public void update() {

        List<Integer> list =messageController.cache;
        if(list != null) {

        }
        ArrayList<TextView> tvs = new ArrayList<>();
        for (Integer s:list) {
            TextView tv=new TextView(getApplicationContext());
            tv.setText(s.toString());
            tvs.add(tv);

        }
        for (TextView t: tvs) {
            linearLayout.addView(t);
        }


    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }
}

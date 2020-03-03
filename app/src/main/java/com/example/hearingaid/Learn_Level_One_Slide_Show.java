package com.example.hearingaid;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Learn_Level_One_Slide_Show extends AppCompatActivity {

    ImageView color;
    TextView color_name;
    int DELAY = 5000;
    String [] names = {"Red", "Green", "White", "Black"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__level__one__slide__show);

        color = findViewById(R.id.color);
        color_name = findViewById(R.id.color_name);


        color_name.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                color_name.setText(names[i]);
                i++;
                if(i==4)
                    i=0;
                color_name.postDelayed(this, DELAY);
            }
        });

    }


}

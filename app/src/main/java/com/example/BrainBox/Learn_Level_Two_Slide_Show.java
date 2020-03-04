package com.example.BrainBox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Learn_Level_Two_Slide_Show extends AppCompatActivity {

    TextView object_name;
    ImageView object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__level__two__slide__show);

        object_name = findViewById(R.id.object_name);
        object = findViewById(R.id.object);
    }
}

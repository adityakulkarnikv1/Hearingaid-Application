package com.example.BrainBox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Welcome_Screen extends AppCompatActivity {

    private TextView textView;
    Animation animation_text, animation_button_about, animation_button_start, animation_line;
    Button button_about, button_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__screen);
        textView = findViewById(R.id.welcome_text);
        button_about = findViewById(R.id.button_about);
        button_start = findViewById(R.id.button_start);
        //line = findViewById(R.id.line);

        //Animations
        animation_text = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        textView.setAnimation(animation_text);

        animation_button_about = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        button_about.setAnimation(animation_button_about);

        animation_button_start = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        button_start.setAnimation(animation_button_start);

        //animation_line = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top);
        //line.setAnimation(animation_line);

        //Onclick listeners
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_start = new Intent(getApplicationContext(), Get_Started.class);
                startActivity(get_start);
            }
        });

        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(getApplicationContext(), About_App.class);
                startActivity(about);
            }
        });

    }
}

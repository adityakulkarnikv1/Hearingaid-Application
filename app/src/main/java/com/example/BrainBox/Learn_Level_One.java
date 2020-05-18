package com.example.BrainBox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Learn_Level_One extends AppCompatActivity {

    TextView text_learn, text_quiz;
    Animation text_top_anim, text_bottom_anim, slideShow_anim, quiz_anim, shapes_anim;
    Button slide_show_start, quiz_start, button_slide_show_shapes;
    //ImageView back_to_learn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__level__one);
        // view by id's
        text_learn = findViewById(R.id.text_learn);
        text_quiz = findViewById(R.id.text_quiz);
        slide_show_start = findViewById(R.id.button_slide_show);
        quiz_start = findViewById(R.id.button_quiz);
        button_slide_show_shapes = findViewById(R.id.button_shapes_slide_show);
        //back_to_learn = findViewById(R.id.back_learn);

        //animations
        text_top_anim = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        text_learn.setAnimation(text_top_anim);

        text_bottom_anim = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        text_quiz.setAnimation(text_bottom_anim);

        slideShow_anim = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        slide_show_start.setAnimation(slideShow_anim);

        shapes_anim = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        button_slide_show_shapes.setAnimation(shapes_anim);

        quiz_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top);
        quiz_start.setAnimation(quiz_anim);


        //onclick listeners
        slide_show_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Learn_Level_One_Slide_Show_Colors.class));
            }
        });

        button_slide_show_shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Learn_Level_One_Slide_Show_Shapes.class));
            }
        });

        quiz_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Question_one.class));
            }
        });


    }
}

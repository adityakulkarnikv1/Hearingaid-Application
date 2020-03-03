package com.example.hearingaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Learn_Level_Two extends AppCompatActivity {

    TextView text_lvl_display, text_learn, text_quiz;
    Animation text_lvl_anim, text_learn_anim, text_quiz_anim, button_slide_show, button_quiz;
    Button slide_show, quiz;
    //ImageView back_to_learn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__level__two);
        //view by id's
        text_lvl_display = findViewById(R.id.text_lvl_display);
        text_learn = findViewById(R.id.text_learn);
        text_quiz = findViewById(R.id.text_quiz);
        slide_show = findViewById(R.id.button_slide_show);
        quiz = findViewById(R.id.button_quiz);
        //back_to_learn = findViewById(R.id.back_learn);

        //animations
        //text_lvl_anim = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        //text_lvl_display.setAnimation(text_lvl_anim);

        text_learn_anim = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        text_learn.setAnimation(text_learn_anim);

        text_quiz_anim = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        text_quiz.setAnimation(text_quiz_anim);

        button_slide_show = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        slide_show.setAnimation(button_slide_show);

        button_quiz = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        quiz.setAnimation(button_quiz);


        //onclick listeners

    }
}

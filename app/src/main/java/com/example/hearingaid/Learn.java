package com.example.hearingaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Learn extends AppCompatActivity {

    CardView card_one, card_two, card_three;
    TextView textView;
    ImageView back;
    Animation anim_text, anim_card_one, anim_card_two, anim_card_three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        card_one = findViewById(R.id.card_one);
        card_two = findViewById(R.id.card_two);
        card_three = findViewById(R.id.card_three);
        textView = findViewById(R.id.textView2);
        back = findViewById(R.id.back);

        anim_text = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        textView.setAnimation(anim_text);

        anim_card_one = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        card_one.setAnimation(anim_card_one);

        anim_card_two = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        card_two.setAnimation(anim_card_two);

        anim_card_three = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        card_three.setAnimation(anim_card_three);




        //onclick
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Get_Started.class);
                startActivity(intent);
            }
        });

        card_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Learn_Level_One.class));
            }
        });

        card_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Learn_Level_Two.class));
            }
        });


    }
}

package com.example.BrainBox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Get_Started extends AppCompatActivity {

    CardView card_learn, card_communicate;
    TextView textView;
    //ImageView back;
    Animation text_view, comm, lear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get__started);
        textView = findViewById(R.id.text_view);
        card_learn = findViewById(R.id.card_learn);
        card_communicate = findViewById(R.id.card_communicate);
        //back = findViewById(R.id.back);

        //animations
        text_view = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        textView.setAnimation(text_view);

        comm = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        card_communicate.setAnimation(comm);

        lear = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        card_learn.setAnimation(lear);


        //onclick listeners
        card_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Learn.class));
            }
        });

        card_communicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Communicate.class));
            }
        });

        /*back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Welcome_Screen.class));
            }
        });*/

    }
}

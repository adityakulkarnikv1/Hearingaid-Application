package com.example.BrainBox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Get_Started extends AppCompatActivity {

    CardView card_learn, card_communicate;
    TextView textView;
    Button submit;
    EditText name, age, address;
    Animation text_view, comm, lear;
    public String personName, personAge, personAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get__started);
        textView = findViewById(R.id.text_view);
        card_learn = findViewById(R.id.card_learn);
        card_communicate = findViewById(R.id.card_communicate);
        name = findViewById(R.id.editText_name);
        age = findViewById(R.id.editText_age);
        submit = findViewById(R.id.submit);
        address = findViewById(R.id.address);

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
        //hello world test comment
        card_communicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(personName != null && personAge != null && personAddress != null){
                    Intent intent = new Intent(getApplicationContext(), Communicate.class);
                    intent.putExtra("NameOfPerson", personName);
                    intent.putExtra("AgeOfPerson", personAge);
                    intent.putExtra("AddressOfPerson", personAddress);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "Please Enter the above fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(name.getText().toString()) && !TextUtils.isEmpty(age.getText().toString()) &&
                        !TextUtils.isEmpty(address.getText().toString()) ){
                    personName = name.getText().toString();
                    personAge = age.getText().toString();
                    personAddress = address.getText().toString();
                    Toast.makeText(getApplicationContext(), "Done!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please enter name and age", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}

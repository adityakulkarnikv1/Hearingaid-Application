package com.example.BrainBox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Learn_Communication extends AppCompatActivity {

    private static final String TAG = "Learn_Communication";

    public ArrayList<String> rcd_questions = new ArrayList<String>();
    public TextView ques;
    public int i = 0;
    public int DELAY = 2500;
    public int last_element = rcd_questions.size();
    public String[] arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__communication);

        Bundle bundle = getIntent().getExtras();
        rcd_questions = bundle.getStringArrayList("questions");
        arr = (String[]) rcd_questions.toArray();

        ques = findViewById(R.id.ques);




    }
}

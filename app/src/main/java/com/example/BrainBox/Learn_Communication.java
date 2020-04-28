package com.example.BrainBox;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class Learn_Communication extends AppCompatActivity {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public ListView listView;
    public TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__communication);
        initTextToSpeech();

        listView = findViewById(R.id.listView);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> question_list = new ArrayList<>();
                ArrayList<String> answer_list = new ArrayList<>();
                for(DataSnapshot d: dataSnapshot.getChildren()){
                    String key = d.getKey();
                    String value = (String) d.getValue();
                    question_list.add(key);
                    answer_list.add(value);
                }

                function(question_list, answer_list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void function(ArrayList<String> question_list, final ArrayList<String> answer_list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, question_list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                answer(answer_list.get(position));
            }
        });
    }

    private void answer(String s) {
        speak(s);
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    private void initTextToSpeech() {
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (textToSpeech.getEngines().size() == 0){
                    Toast.makeText(getApplicationContext(), "No Text to speech engine installed on your device",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void speak(String message) {
        if(Build.VERSION.SDK_INT >= 21){
            textToSpeech.speak(message, textToSpeech.QUEUE_FLUSH, null, null);
        }else {
            textToSpeech.speak(message, textToSpeech.QUEUE_FLUSH, null);
        }
    }


}

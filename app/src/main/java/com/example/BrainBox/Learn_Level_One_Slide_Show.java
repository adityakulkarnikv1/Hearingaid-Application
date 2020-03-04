package com.example.BrainBox;


import android.os.Build;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Learn_Level_One_Slide_Show extends AppCompatActivity {

    ImageView color;
    TextView color_name;
    int DELAY = 2500;
    String [] names = {"Red", "Green", "Yellow", "Black", "Blue", "orange", "purple"};
    int[] array = {R.drawable.red, R.drawable.green, R.drawable.yellow, R.drawable.black, R.drawable.blue, R.drawable.orange, R.drawable.purple};
    private TextToSpeech textToSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__level__one__slide__show);

        color = findViewById(R.id.color);
        color_name = findViewById(R.id.color_name);
        initTextToSpeech();


        color_name.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                color_name.setText(names[i]);
                color.setImageResource(array[i]);
                speak(names[i]);
                i++;
                if(i==7)
                    i=0;

                color_name.postDelayed(this, DELAY);
            }
        });

    }

    private void initTextToSpeech() {
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (textToSpeech.getEngines().size() == 0){
                    Toast.makeText(getApplicationContext(), "No Text to speech engine installed on your device",
                            Toast.LENGTH_LONG).show();
                }else{
                    textToSpeech.setLanguage(Locale.CANADA);
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

    @Override
    protected void onPause() {
        super.onPause();
        textToSpeech.shutdown();
    }
}

package com.example.BrainBox;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;

public class Learn_Level_Two_Slide_Show extends AppCompatActivity {

    private TextToSpeech tts;
    TextView object_name;
    int DELAY = 2500;
    ImageView object;
    String [] object_names = {"basketball", "books", "chair", "computer", "football", "glass", "hammer", "key", "lock", "mobile"
    , "nail", "pen", "table", "telephone", "television", "water"};

    int[] array = {R.drawable.basketball, R.drawable.books, R.drawable.chair, R.drawable.computer, R.drawable.football, R.drawable.glass,
    R.drawable.hammer, R.drawable.key, R.drawable.lock, R.drawable.mobile, R.drawable.nail, R.drawable.pen, R.drawable.table,
    R.drawable.telephone, R.drawable.tv, R.drawable.water};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__level__two__slide__show);

        object_name = findViewById(R.id.object_name);
        object = findViewById(R.id.object);

        initTextToSpeech();


        object_name.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                object_name.setText(object_names[i]);
                object.setImageResource(array[i]);
                speak(object_names[i]);
                i++;
                if(i == 16)
                    i=0;

                object_name.postDelayed(this, DELAY);
            }
        });



    }

    private void initTextToSpeech() {

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (tts.getEngines().size() == 0){
                    Toast.makeText(getApplicationContext(), "No Text to speech engine installed on your device",
                            Toast.LENGTH_LONG).show();
                }else{
                    tts.setLanguage(Locale.CANADA);
                }
            }
        });

    }

    private void speak(String message) {
        if(Build.VERSION.SDK_INT >= 21){
            tts.speak(message, tts.QUEUE_FLUSH, null, null);
        }else {
            tts.speak(message, tts.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        tts.shutdown();
    }
}

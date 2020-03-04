package com.example.BrainBox;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Learn_Level_One_Slide_Show_Shapes extends AppCompatActivity {

    ImageView shape;
    TextView shape_name;
    int DELAY = 2500;
    String [] shapes = {"Rectangle", "Square", "Circle", "Triangle", "Parallelogram"};
    int[] array = {R.drawable.rectangle, R.drawable.square, R.drawable.circle, R.drawable.triangle, R.drawable.parallelogram};
    private TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__level__one__slide__show__shapes);

        shape = findViewById(R.id.shape);
        shape_name = findViewById(R.id.shape_name);

        initTextToSpeech();

        shape_name.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                shape_name.setText(shapes[i]);
                shape.setImageResource(array[i]);
                speak(shapes[i]);
                i++;
                if(i==5)
                    i=0;

                shape_name.postDelayed(this, DELAY);
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

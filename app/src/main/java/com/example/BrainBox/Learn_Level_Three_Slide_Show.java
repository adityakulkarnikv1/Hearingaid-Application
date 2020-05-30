package com.example.BrainBox;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Learn_Level_Three_Slide_Show extends AppCompatActivity {

    private TextToSpeech tts;
    int[] objects = {R.drawable.basket_ball_on_the_rack, R.drawable.books_on_the_shelf, R.drawable.computer_on_the_desk,
                        R.drawable.food_on_table, R.drawable.glass_of_water, R.drawable.locked_room, R.drawable.nail_in_the_wall,
                        R.drawable.room_full_of_flowers, R.drawable.table_in_the_room};

    String[] names = {"Basketballs are on the rack", "Books are on the shelf", "Computer is on the desk", "There is food on the table",
                        "A glass of water", "The room is locked", "There is a nail in the wall", "Room is filled with flowers",
                        "Table is in the room"};
    TextView display_text;
    ImageView display_image;
    int DELAY = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__level__three__slide__show);

        display_image = findViewById(R.id.image);
        display_text = findViewById(R.id.text);

        initTextToSpeech();

        display_text.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                display_text.setText(names[i]);
                display_image.setImageResource(objects[i]);
                speak(names[i]);
                i++;
                if(i == 9)
                    i=0;

                display_text.postDelayed(this, DELAY);
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

    @Override
    protected void onPause() {
        super.onPause();
        tts.shutdown();
    }

}

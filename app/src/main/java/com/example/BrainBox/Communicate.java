package com.example.BrainBox;

import android.content.Intent;
import android.os.Build;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Communicate extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    ImageView mic;
    private SpeechRecognizer speechRecognizer;
    String TextToSpeak, personName, personAge, personAddress;
    public TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);
        mic = findViewById(R.id.mic);
        res = findViewById(R.id.text_view);


        Bundle bundle = getIntent().getExtras();
        personName = bundle.getString("NameOfPerson");
        personAge = bundle.getString("AgeOfPerson");
        personAddress = bundle.getString("AddressOfPerson");


        initTextToSpeech();
        initSpeechRecognizer();



        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM );
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                speechRecognizer.startListening(intent);
            }
        });
    }

    private void initSpeechRecognizer() {
        if(SpeechRecognizer.isRecognitionAvailable(this)){
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            speechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float rmsdB) {

                }

                @Override
                public void onBufferReceived(byte[] buffer) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int error) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    List<String> results = bundle.getStringArrayList(
                            SpeechRecognizer.RESULTS_RECOGNITION
                    );
                    processResult(results.get(0));
                }

                @Override
                public void onPartialResults(Bundle partialResults) {

                }

                @Override
                public void onEvent(int eventType, Bundle params) {

                }
            });
        }
    }

    private void processResult(String command) {
        command = command.toLowerCase();

        if (command.contains("what")){
            if (command.contains("your")){
                if(command.contains("name")){
                    TextToSpeak = "My name is " + personName;
                    res.setText(TextToSpeak);
                    speak(TextToSpeak);
                }
                if(command.contains("age")){
                    TextToSpeak = "My age is " + personAge;
                    res.setText(TextToSpeak);
                    speak(TextToSpeak);
                }
            }
            if (command.contains("time")){
                Date now = new Date();
                String time = DateUtils.formatDateTime(this, now.getTime(), DateUtils.FORMAT_SHOW_TIME);
                TextToSpeak = "The time is " + time;
                res.setText(TextToSpeak);
                speak(TextToSpeak);
            }

        }
        if (command.contains("how")){
            if(command.contains("are you ")){
                TextToSpeak = "I'm good. How are you.....?";
                res.setText(TextToSpeak);
                speak(TextToSpeak);
            }
        }
        if(command.contains("thank you")){
            TextToSpeak = "Welcome";
            res.setText(TextToSpeak);
            speak(TextToSpeak);
        }
        if(command.contains("bye")){
            TextToSpeak = "Good bye. Have a nice day";
            res.setText(TextToSpeak);
            speak(TextToSpeak);
        }
        if(command.contains("where")){
            if(command.contains("live")){
                TextToSpeak = personAddress;
                res.setText(TextToSpeak);
                speak(TextToSpeak);
            }
        }

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
                    speak("Hello I'm ready");
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

package com.example.elias.sagetext;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {

        public TextToSpeech tts;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClick(View v){
        EditText editText= (EditText) findViewById(R.id.editText);
        tts.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    public void onInit(int status) {
        tts.setLanguage(Locale.GERMAN);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }
}
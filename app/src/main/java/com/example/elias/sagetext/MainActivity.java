package com.example.elias.sagetext;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

private TextToSpeech tts;
    private Spinner spinner;
    private static final String[]paths = {"Deutsch", "Englisch", "Französisch", "China!!!"};




    @Override
        protected void onCreate (Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts= new TextToSpeech(this,this);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }
    public void onClick(View v){
        EditText editText= (EditText) findViewById(R.id.editText);

       tts.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    public void onInit(int status) {



        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
            tts.setLanguage(Locale.GERMAN);
                break;
            case 1:
             tts.setLanguage(Locale.ENGLISH);
                break;
            case 2:
              tts.setLanguage(Locale.FRENCH);
                break;
            case 3:
                tts.setLanguage(Locale.CHINA);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
 TextToSpeech tts;
 Button b1;
 EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b1=findViewById(R.id.b1);
    et=findViewById(R.id.editt);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.speak(et.getText().toString(),
                        TextToSpeech.QUEUE_FLUSH,null);
            }
        });


       tts=new TextToSpeech(getApplicationContext(),
               new TextToSpeech.OnInitListener() {
           @Override
           public void onInit(int status) {

               if(status!=TextToSpeech.ERROR)
               {
                   tts.setLanguage(Locale.US);
               }
           }
       });
    }
}

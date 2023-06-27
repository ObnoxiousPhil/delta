package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button s1,s2;
TextView counter;
int count=0;
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        counter=findViewById(R.id.counter);
        handler=new Handler();

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handler.postDelayed(runnable,0);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handler.removeCallbacks(runnable);
            }
        });


    }
  public Runnable runnable=new Runnable() {
      @Override
      public void run() {
          count++;
          counter.setText(String.format("%d",count));
          handler.postDelayed(this,1000);
      }
  } ;


}
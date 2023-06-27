
package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv1=findViewById(R.id.tv1);
        String un4=getIntent().getStringExtra("un");
        String pw4=getIntent().getStringExtra("pw");
        tv1.setText("Welcome to "+ un4);
    }
}
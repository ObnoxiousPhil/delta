package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button b1;
EditText un1;
EditText pw1;
String u1,p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=findViewById(R.id.login);
        un1=findViewById(R.id.un1);
        pw1=findViewById(R.id.pw1);
        String msg="Invalid Password";
        String un3=getIntent().getStringExtra("un");
        String pw3=getIntent().getStringExtra("pw");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                u1=un1.getText().toString();
                p1=pw1.getText().toString();
                if(p1.equals(pw3) && u1.equals(un3)) {
                    Intent i2 = new Intent(MainActivity2.this, MainActivity3.class);
                    i2.putExtra("un", un3);
                    i2.putExtra("pw", pw3);
                    startActivity(i2);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
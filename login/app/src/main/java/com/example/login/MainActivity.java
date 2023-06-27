package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText un;
    EditText pw;
    String unn1,pww1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.signup);
        un=findViewById(R.id.un);
        pw=findViewById(R.id.pw);

        String msg="password invalid Format";
        b1.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {

                unn1=un.getText().toString();
                pww1=pw.getText().toString();
                String regex ="^(?" +
                        "" +
                        "=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
                if(pww1.matches(regex)) {

                    Intent i1 = new Intent(MainActivity.this, MainActivity2.class);
                    i1.putExtra("un", unn1);
                    i1.putExtra("pw", pww1);
                    startActivity(i1);
                }
               else
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

    }
}
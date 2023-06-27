package com.example.callandsaveapp;

import
        androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button one, two, three, four, five, six, seven, eight, nine, zero, star, hash, del, save, call;
    EditText etnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.btnn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn03);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        zero = findViewById(R.id.btn0);
        star = findViewById(R.id.btnstr);
        hash = findViewById(R.id.btnhash);
        save = findViewById(R.id.btnsave);
        call = findViewById(R.id.btncall);
        del = findViewById(R.id.btndel);
        etnum = findViewById(R.id.editText);

        one.setOnClickListener(this::createnum);
        two.setOnClickListener(this::createnum);
        three.setOnClickListener(this::createnum);
        four.setOnClickListener(this::createnum);
        five.setOnClickListener(this::createnum);
        six.setOnClickListener(this::createnum);
        seven.setOnClickListener(this::createnum);
        eight.setOnClickListener(this::createnum);
        nine.setOnClickListener(this::createnum);
        zero.setOnClickListener(this::createnum);
        hash.setOnClickListener(this::createnum);
        star.setOnClickListener(this::createnum);
        del.setOnClickListener(this::createnum);
        save.setOnClickListener(this::createnum);
        call.setOnClickListener(this::createnum);
    }

    private void createnum(View view) {
        Editable str;
        str = etnum.getText();
        switch (view.getId()){
            case R.id.btn0:
                str = str.append(zero.getText());
                etnum.setText(str);
                break;
            case R.id.btnn1:
                str = str.append(one.getText());
                etnum.setText(str);
                break;
            case R.id.btn2:
                str = str.append(two.getText());
                etnum.setText(str);
                break;
            case R.id.btn03:
                str = str.append(three.getText());
                etnum.setText(str);
                break;
            case R.id.btn4:
                str = str.append(four.getText());
                etnum.setText(str);
                break;
            case R.id.btn5:
                str = str.append(five.getText());
                etnum.setText(str);
                break;
            case R.id.btn6:
                str = str.append(six.getText());
                etnum.setText(str);
                break;
            case R.id.btn7:
                str = str.append(seven.getText());
                etnum.setText(str);
                break;
            case R.id.btn8:
                str = str.append(eight.getText());
                etnum.setText(str);
                break;
            case R.id.btn9:
                str = str.append(nine.getText());
                etnum.setText(str);
                break;
            case R.id.btnstr:
                str = str.append(star.getText());
                etnum.setText(str);
                break;
            case R.id.btnhash:
                str = str.append(hash.getText());
                etnum.setText(str);
                break;
            case R.id.btndel:
                str = (Editable) str.subSequence(0, str.length()-1);
                etnum.setText(str);
                break;
            case R.id.btncall:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                        checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else {
                    String phoneno = etnum.getText().toString();
                    Intent intentcall = new Intent(Intent.ACTION_CALL);
                    intentcall.setData(Uri.parse("tel:"+phoneno));
                    startActivity(intentcall);

                }
                break;

            case R.id.btnsave:
                String contact = etnum.getText().toString();
                Intent intentsave = new Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+contact));
                startActivity(intentsave);
                break;
        }
    }
}
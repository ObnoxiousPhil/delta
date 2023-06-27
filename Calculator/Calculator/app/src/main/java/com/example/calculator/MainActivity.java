package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button zero, one, two, three, four, five, six, seven, eight, nine, add, sub, mul, div, del, clear, equal;
    TextView expr;
    String opr1="", opr2="", operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsign);
        equal = (Button)findViewById(R.id.btnequal);
        mul = (Button)findViewById(R.id.btnmul);
        div = (Button)findViewById(R.id.btndiv);
        del = (Button)findViewById(R.id.btndel);
        clear=(Button)findViewById(R.id.btnclear);
        expr = (TextView) findViewById(R.id.textView3);

        one.setOnClickListener(this::setValue);
        zero.setOnClickListener(this::setValue);
        two.setOnClickListener(this::setValue);
        three.setOnClickListener(this::setValue);
        four.setOnClickListener(this::setValue);
        five.setOnClickListener(this::setValue);
        six.setOnClickListener(this::setValue);
        seven.setOnClickListener(this::setValue);
        eight.setOnClickListener(this::setValue);
        nine.setOnClickListener(this::setValue);
        add.setOnClickListener(this::setOpr);
        sub.setOnClickListener(this::setOpr);
        equal.setOnClickListener(this::getResult);
        mul.setOnClickListener(this::setOpr);
        div.setOnClickListener(this::setOpr);
        del.setOnClickListener(this::delChar);
        clear.setOnClickListener(this::ClearValue);

    }

    private void ClearValue(View view) {
        operator = "";
        opr1 = "";
        opr2 = "";
        expr.setText("");
    }

    private void getResult(View v) {
        double result = 0;
        boolean flag = true;
        if(!opr1.equals("") || !opr2.equals("")){
            switch(operator){
                case "+":
                    result = Double.parseDouble(opr1) + Double.parseDouble(opr2);
                    break;
                case "-":
                    result = Double.parseDouble(opr1) - Double.parseDouble(opr2);
                    break;
                case "*":
                    result = Double.parseDouble(opr1) * Double.parseDouble(opr2);
                    break;
                case "/":
                    if(Double.parseDouble(opr2)==0.0)
                        flag=false;
                    else
                        result = Double.parseDouble(opr1) / Double.parseDouble(opr2);
                    break;
            }
            opr1 = ((result %1 !=0)) ? String.valueOf(result) : String.valueOf(((int)result));
            expr.setText(opr1);
            operator = "";
            opr2="";
        }
    }

    private void setOpr(View v) {
        CharSequence text = ((Button) v).getText();
        opr1 = expr.getText().toString();
        operator = text.toString();
        CharSequence t = ((Button) v).getText();
        expr.setText(expr.getText()+""+t);
    }

    private void delChar(View view) {
        if(expr.getText().length() > 0){
            expr.setText(expr.getText().subSequence(0, expr.getText().length()-1));
        }
    }

    private void setValue(View v) {
        CharSequence text = ((Button) v).getText();
        if(operator.equals("")){
            opr1+=text;
        }
        else{
            opr2+=text;
        }
        expr.setText(expr.getText()+""+text);
    }
}
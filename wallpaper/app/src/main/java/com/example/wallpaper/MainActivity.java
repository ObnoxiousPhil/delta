package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b1;
View  screenview;
int[] back_images;
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back_images=new int[]{R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5};
    b1=findViewById(R.id.b1);
screenview=findViewById(R.id.cl);
handler=new Handler();

b1.setOnClickListener(new View.OnClickListener() {
    @Override

    public void onClick(View v) {

       handler.postDelayed(runnable,0) ;
       b1.setVisibility(View.GONE);

    }
});
}

public Runnable runnable=new Runnable() {
    @Override
    public void run() {
        Random r=new Random();

       int a_len=back_images.length;
        int rn=r.nextInt(a_len);
       screenview.setBackground(ContextCompat.
               getDrawable(getApplicationContext(),
                       back_images[rn]));
        handler.postDelayed(this,3000);

    }
};

}

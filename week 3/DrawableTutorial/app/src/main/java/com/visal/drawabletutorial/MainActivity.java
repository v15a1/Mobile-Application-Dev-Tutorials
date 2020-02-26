package com.visal.drawabletutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    String manImg = "man";
    String dogImg = "brittany";
    ImageView view1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //accessing the ui views
        view1 = (ImageView) findViewById(R.id.im_view);

        //using java to render an image into an ImageView
        int resId = getResources().getIdentifier(dogImg, "drawable", "com.visal.drawabletutorial");
        view1.setImageResource(resId);

    }
    
    public void btnPressed(View view) {
        int resId = getResources().getIdentifier(manImg, "drawable", "com.visal.drawabletutorial");
        view1.setImageResource(resId);
    }
}

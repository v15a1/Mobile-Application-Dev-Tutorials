package com.visal.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //setting instance variables
    private int count = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting the textvieq from context using the R file
        textView = (TextView) findViewById(R.id.count);
    }

    public void showToast(View view) {
        //Instanciating and displaying a toast on button press
        Toast toast = Toast.makeText(this, "Toast Message", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showCount(View view) {
        //increasing count, updating & isplaying it on the textviews
        count++;
        if (textView != null) {
            textView.setText(Integer.toString(count));
        }
    }
}

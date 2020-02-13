package com.visal.counterapp_tut2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Toast Message", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showCount(View view) {
        count++;
        if (textView != null) {
            textView.setText(Integer.toString(count));
        }
    }
}

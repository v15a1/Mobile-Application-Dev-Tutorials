package com.visal.activityintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = (EditText) findViewById(R.id.editText_second);

        //getting data passed down
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);

    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_REPLY, reply));
        Log.d(LOG_TAG, "End SecondActivity");
        finish();   //closing an activity
    }
}

package com.visal.firstdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    Database database;
    EditText employeeIdText;
    EditText nameText;
    EditText addressText;
    EditText ageText;
    Spinner postitionSpinner;
    Button submitEmployeeBtn;
    Button displayAllBtn;
    String positionString;
    ArrayList<String> namesInDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.name);
        employeeIdText = findViewById(R.id.employee_id);
        addressText = findViewById(R.id.address);
        ageText = findViewById(R.id.age);
        postitionSpinner = findViewById(R.id.position);
        submitEmployeeBtn = findViewById(R.id.submit_button);
        displayAllBtn = findViewById(R.id.display_all_button);
        postitionSpinner = findViewById(R.id.position);
        namesInDB = new ArrayList<String>();

        database = new Database(this);


        submitEmployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                int employeeId = Integer.parseInt(employeeIdText.getText().toString());
                String address = addressText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                boolean isInserted;
                namesInDB = database.getAllNames();
                //adding data into the database if it is not available in the database
                if (!namesInDB.contains(name.toUpperCase())){
                    isInserted = database.insertData(employeeId, name, address, age, positionString);       //inserting data into the database
                    if (isInserted){
                        Toast.makeText(MainActivity.this, "Data has been successfully inserted", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Data hasn't been inserted", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Name already in the DB. Enter another ID", Toast.LENGTH_SHORT).show();
                }
            }
        });

        postitionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                positionString = parent.getItemAtPosition(position).toString();
                Log.d(TAG, "onItemSelected: " + positionString);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        displayAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InitialActivity.class));
                finish();
            }
        });
    }
}

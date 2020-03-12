package com.visal.firstdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Database database;
    EditText employeeIdText;
    EditText nameText;
    EditText addressText;
    EditText ageText;
    Spinner postitionSpinner;
    Button submitEmployeeBtn;
    Button displayAllBtn;

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
        database = new Database(this);


        submitEmployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                int employeeId = Integer.parseInt(employeeIdText.getText().toString());
                String address = addressText.getText().toString();
                String position = "Manager";
                int age = Integer.parseInt(ageText.getText().toString());
                boolean isInserted = database.insertData(employeeId, name, address, age, position);
                if (isInserted){
                    Toast.makeText(MainActivity.this, "Data has been successfully inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data hasn't been inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

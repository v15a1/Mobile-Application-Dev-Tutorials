package com.visal.firstdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InitialActivity extends AppCompatActivity {

    ListView employeeListView;
    Button openAddEmpActivityBtn;
    Button updateEmployee;
    Button deleteEmployee;
    private ArrayList allEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        employeeListView = findViewById(R.id.empployee_listview);
        openAddEmpActivityBtn = findViewById(R.id.add_employee_btn);
        updateEmployee = findViewById(R.id.update_employee);
        deleteEmployee = findViewById(R.id.delete_employee);

        Database db = new Database(this);
        allEmployees = db.getAllNames();

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, allEmployees);
        employeeListView.setAdapter(arrayAdapter);

        openAddEmpActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InitialActivity.this, MainActivity.class));
            }
        });

        updateEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InitialActivity.this, UpdateActivity.class));
            }
        });

        deleteEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InitialActivity.this, DeleteActivity.class));
            }
        });
    }
}

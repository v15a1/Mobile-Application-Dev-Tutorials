package com.visal.firstdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText deleteID;
    Button deleteEmployee;
    Button goBack;
    Database db;
    int empIdToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        deleteID = findViewById(R.id.employee_id_to_delete);
        deleteEmployee = findViewById(R.id.delete_emp_id);
        goBack = findViewById(R.id.goback_delete);

        db = new Database(this);
        deleteEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empIdToDelete = Integer.parseInt(deleteID.getText().toString());
                int numberOfRowsDeleted = db.deleteData(empIdToDelete);     //deleting values off of the database
                if (numberOfRowsDeleted > 0){
                    Toast.makeText(DeleteActivity.this, "Employee successfully Deleted...", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DeleteActivity.this, "Employee NOT Deleted...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteActivity.this, InitialActivity.class));
            }
        });
    }
}

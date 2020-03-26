package com.visal.firstdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText updateId;
EditText updateName;
Button goBack;
Button updateData;
String name;
int id;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateData = findViewById(R.id.update_entries);
        goBack = findViewById(R.id.go_back_update);
        updateId = findViewById(R.id.id_to_update);
        updateName = findViewById(R.id.name_to_update);

        db = new Database(this);

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = updateName.getText().toString();
                id = Integer.parseInt(updateId.getText().toString());
                boolean updated = db.updateData(id, name);      //updating the database
                if (updated){
                    Toast.makeText(UpdateActivity.this, "Entry successfully updated...", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UpdateActivity.this, "Entry WAS NOT updated...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateActivity.this, InitialActivity.class));
            }
        });
    }

}

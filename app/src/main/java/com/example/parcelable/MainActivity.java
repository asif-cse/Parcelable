package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText student_name, student_id, student_grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_name = findViewById(R.id.edt_nameId);
        student_id = findViewById(R.id.edt_idId);
        student_grade = findViewById(R.id.edt_gradeId);

        findViewById(R.id.submitId).setOnClickListener((View view)->{

            String name = student_name.getText().toString();
            String temp_id = student_id.getText().toString();
            long id = Long.parseLong(temp_id);
            String grade = student_grade.getText().toString();


            Student student = new Student(name, id, grade);


                Intent intent = new Intent(getApplicationContext(),Details.class);
                intent.putExtra("details_key", student);
                startActivity(intent);

        });
    }
}

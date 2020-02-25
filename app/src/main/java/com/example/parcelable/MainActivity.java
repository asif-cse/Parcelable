package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
//            String temp_id = student_id.getText().toString();
            String id = student_id.getText().toString();
            String grade = student_grade.getText().toString();

            if (student_name.length()==0){
                student_name.setError("Insert value");
                Toast.makeText(getApplicationContext(),"Insert value",Toast.LENGTH_SHORT).show();
                return;
            }else if(student_id.length()==0){
                student_id.setError("Insert value");
                return;
            }else if(student_grade.length()==0){
                student_grade.setError("Insert value");
                return;
            }

            Student student = new Student(name, id, grade);

            Details.open(MainActivity.this,student);

        });
    }
}

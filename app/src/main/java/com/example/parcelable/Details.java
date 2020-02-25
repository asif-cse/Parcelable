package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    public static void open(AppCompatActivity activity, Student student){
        Intent intent = new Intent(activity, Details.class);
        intent.putExtra("details_key",student);
        activity.startActivity(intent);
    }

    private TextView student_name, student_id, student_grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        student_name = findViewById(R.id.name_tvId);
        student_id = findViewById(R.id.id_tvId);
        student_grade = findViewById(R.id.grade_tvId);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Student student = bundle.getParcelable("details_key");

        student_name.setText(student.getName());
        student_id.setText(student.getId());
        student_grade.setText(student.getGrade());

    }
}

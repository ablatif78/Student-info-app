package com.example.spring2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class InfoActivity extends AppCompatActivity {
    TextView textView;
    String studentName, studentID, phoneNumber;

    String admissionYear;
    char admissionSemester;
    String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        studentName = intent.getStringExtra("STUDENT_NAME");
        studentID = intent.getStringExtra("STUDENT_ID");
        phoneNumber = intent.getStringExtra("PHONE_NUMBER");

        textView = findViewById(R.id.textViewID);
    }

    public void view(View view) {

        admissionYear = studentID.substring(0, 2);
        admissionSemester = studentID.charAt(2);
        department = studentID.substring(4, 6);

        String semesterCheck, departmentCheck, result;
        int pn = Integer.parseInt(Character.toString(phoneNumber.charAt(phoneNumber.length() - 1)));

        int value = Integer.parseInt(Character.toString(admissionSemester)), value2;
        value2 = Integer.parseInt(department);


        if(pn % 2 == 0) {
            semesterCheck = (value == 1 ? "Spring" : (value == 2 ? "Summer" : "Fall"));
            result = studentName + " has admitted in " + semesterCheck + " 20" + admissionYear;
        } else {
            switch(value2) {
                case 15: departmentCheck = "CSE"; break;
                case 14: departmentCheck = "Software Engineering"; break;
                case 13: departmentCheck = "BBA"; break;
                case 12: departmentCheck = "English"; break;
                case 11: departmentCheck = "Pharmacy"; break;
                default: departmentCheck = "Others";
            }
            result = studentName + " has admitted in " +  departmentCheck + " Department";
        }

        textView.setText(result);

    }

}
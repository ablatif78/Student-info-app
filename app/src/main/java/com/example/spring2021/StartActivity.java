package com.example.spring2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {
    String name, ID, number;
    EditText editText1, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

    }

    public void show(View view) {

        name = editText1.getText().toString();
        ID = editText2.getText().toString();
        number = editText3.getText().toString();

        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("STUDENT_NAME", name);
        intent.putExtra("STUDENT_ID", ID);
        intent.putExtra("PHONE_NUMBER", number);

        startActivity(intent);
    }
}
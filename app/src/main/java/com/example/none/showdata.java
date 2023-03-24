package com.example.none;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class showdata extends AppCompatActivity {
TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;
Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);
        txt1 = findViewById(R.id.TextName);
        txt2 = findViewById(R.id.TextPass);
        txt3 = findViewById(R.id.TextEmail);
        txt4 = findViewById(R.id.TextNumber);
        txt5 = findViewById(R.id.TextDate);
        txt6 = findViewById(R.id.TextDesig);
        txt7 = findViewById(R.id.TextGender);
        button2 = findViewById(R.id.btnContinue);

        Intent intent1 = getIntent();

        String name1 = intent1.getStringExtra("Name:");
        String pass1 = intent1.getStringExtra("Pass:");
        String email1 = intent1.getStringExtra("Mail:");
        String phno1 = intent1.getStringExtra("Mno:");
        String date1 = intent1.getStringExtra("Date:");
        String des1 = intent1.getStringExtra("Desig:");
        String gen1 = intent1.getStringExtra("Gender:");

        txt1.setText(name1);
        txt2.setText(pass1);
        txt3.setText(email1);
        txt4.setText(phno1);
        txt5.setText(date1);
        txt6.setText(des1);
        txt7.setText(gen1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(),MainData.class);
                startActivity(intent3);
            }
        });
    }
}
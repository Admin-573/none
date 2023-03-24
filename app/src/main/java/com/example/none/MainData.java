package com.example.none;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainData extends AppCompatActivity {
ListView listView;
Button button4;
String[] maintitle={"Cloud Computing","Data Science","Flutter",
"Go","HTML","Java","Kotlin","PHP","Python","React","Ruby","Sql","Swift","Visual Basic"};

String[] subtitle={"Price ₹299","Price ₹199","Price ₹399",
"Price ₹499","Price ₹159","Price ₹99","Price ₹999","Price ₹899","Price ₹799",
"Price ₹699","Price ₹549","Price ₹599","Price ₹1299","Price ₹349"};

Integer[] imgid={R.drawable.cc,R.drawable.ds,R.drawable.flutter,
R.drawable.go,R.drawable.html,R.drawable.java,
R.drawable.kotlin,R.drawable.php,R.drawable.python,
R.drawable.react,R.drawable.ruby,R.drawable.sql,
R.drawable.swift,R.drawable.vb};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data);

        button4 = findViewById(R.id.btnbook);

        //Again Login
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goback = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(goback);
            }
        });

        //Custom ListView
        MyListAdapter adapter = new MyListAdapter(this,maintitle,subtitle,imgid);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    Toast.makeText(MainData.this, "Cloud Computing !", Toast.LENGTH_SHORT).show();
                }
                else if(i == 1) {
                    Toast.makeText(MainData.this, "Data Science !", Toast.LENGTH_SHORT).show();
                }
                else if(i == 2) {
                    Toast.makeText(MainData.this, "Flutter !", Toast.LENGTH_SHORT).show();
                }
                else if(i == 3) {
                    Toast.makeText(MainData.this, "Go Language !", Toast.LENGTH_SHORT).show();
                }
                else if(i == 4) {
                    Toast.makeText(MainData.this, "HTML !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 5){
                    Toast.makeText(MainData.this, "Java !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 6) {
                    Toast.makeText(MainData.this, "Kotlin !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 7) {
                    Toast.makeText(MainData.this, "PHP !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 8) {
                    Toast.makeText(MainData.this, "Python !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 9) {
                    Toast.makeText(MainData.this, "React !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 10) {
                    Toast.makeText(MainData.this, "Ruby !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 11) {
                    Toast.makeText(MainData.this, "SQL !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 12){
                    Toast.makeText(MainData.this, "Swift !", Toast.LENGTH_SHORT).show();
                }
                else if (i == 13) {
                    Toast.makeText(MainData.this, "Visual Basic !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
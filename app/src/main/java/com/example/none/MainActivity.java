package com.example.none;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener { 
    String[] items = {"Developer","Designer","Debugger","Engineer","Master"};
EditText edt1,edt2,edt3,edt4,edt5;
RadioGroup rdgrp1;
RadioButton rdbtn1,rdbtn2,rdbtn3;
Button button1;
CheckBox checkBox1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.EditName);
        edt2 = findViewById(R.id.EditPass);
        edt3 = findViewById(R.id.EditEmail);
        edt4 = findViewById(R.id.EditPhone);
        edt5 = findViewById(R.id.EditDate);

        Spinner spinner1 = findViewById(R.id.spinDes);

        rdgrp1 = findViewById(R.id.RdGrp1);

        rdbtn1 = findViewById(R.id.RDBMale);
        rdbtn2 = findViewById(R.id.RDBFemale);
        rdbtn3 = findViewById(R.id.RDBOther);

        button1 = findViewById(R.id.BtnSubmit);

        checkBox1 = findViewById(R.id.chkTerms);

        //DatePicker
        MaterialDatePicker<Long> materialDatePicker=MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Please Select Date")
                                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                                        .build();
        edt5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(),"Admin");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        edt5.setText(materialDatePicker.getHeaderText());
                    }
                });
                return true;
            }
        });

        //Spinner
        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(aa);

        //NextActivity (Button click)
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valid())
                {
                    String name = edt1.getText().toString();
                    String pass = edt2.getText().toString();
                    String mail = edt3.getText().toString();
                    String mno = edt4.getText().toString();
                    String dt = edt5.getText().toString();
                    String gender = ((RadioButton)findViewById(rdgrp1.getCheckedRadioButtonId())).getText().toString();
                    String desig = spinner1.getSelectedItem().toString();

                    Intent intent = new Intent(getApplicationContext(),showdata.class);

                    intent.putExtra("Name:",name);
                    intent.putExtra("Pass:",pass);
                    intent.putExtra("Mail:",mail);
                    intent.putExtra("Mno:",mno);
                    intent.putExtra("Date:",dt);
                    intent.putExtra("Desig:",desig);
                    intent.putExtra("Gender:",gender);

                    startActivity(intent);
                }
            }
        });
    }
    
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Hi "+items[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    private boolean valid()
    {
        if(!checkBox1.isChecked()){
            Toast.makeText(this, "Please Accept Terms & Conditions !", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(edt1.getText().toString().isEmpty()) {
            Toast.makeText(this, "Name Cannot Be Empty !", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edt2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Password Cannot Be Empty !", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edt3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Email Cannot Be Empty !", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edt4.getText().toString().isEmpty()) {
            Toast.makeText(this, "Phone Number Is Mandatory !", Toast.LENGTH_SHORT).show();
            return false;
        }else if (edt5.getText().toString().isEmpty()){
            Toast.makeText(this, "Date Is Mandatory !", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
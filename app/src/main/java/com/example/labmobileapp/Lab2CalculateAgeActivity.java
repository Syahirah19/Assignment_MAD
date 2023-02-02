package com.example.labmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Lab2CalculateAgeActivity extends AppCompatActivity {

    TextView txtvwAge;
    EditText edtName, edtYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_calculate_age);

        txtvwAge = (TextView) findViewById(R.id.txtvwAge);
        edtName = (EditText) findViewById(R.id.edtName);
        edtYear = (EditText) findViewById(R.id.edtYear); 
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Redirecting to " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.nav_age:
                Intent age = new Intent(getApplicationContext(), Lab2CalculateAgeActivity.class);
                startActivity(age);
                return true;
            case R.id.nav_main:
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                return true;
            case R.id.nav_registration:
                Intent registration = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(registration);
                return true;
            case R.id.nav_camera:
                Intent camera = new Intent(getApplicationContext(), Lab4TakePicActivity.class);
                startActivity(camera);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void fnGreet(View view) {
        Calendar c = new GregorianCalendar();

        int year = c.get(Calendar.YEAR);
        String name = edtName.getText().toString();
        String age = edtYear.getText().toString();
        int ageNow = year - Integer.valueOf(age);
        txtvwAge.setText("Hello and Welcome " +  name + "---- You are " + ageNow + " years old.");

    }
}
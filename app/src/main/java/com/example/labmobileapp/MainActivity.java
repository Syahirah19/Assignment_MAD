package com.example.labmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            case R.id.nav_registration:
                Intent registration = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(registration);
                return true;
            case R.id.nav_age:
                Intent age = new Intent(getApplicationContext(), Lab2CalculateAgeActivity.class);
                startActivity(age);
                return true;
            case R.id.nav_camera:
                Intent camera = new Intent(getApplicationContext(), Lab4TakePicActivity.class);
                startActivity(camera);
                return true;
            case R.id.nav_main:
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
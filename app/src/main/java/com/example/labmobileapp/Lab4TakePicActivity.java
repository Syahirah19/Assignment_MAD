package com.example.labmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Lab4TakePicActivity extends AppCompatActivity {

    ImageView imgVwPic;
    TextView tvGreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_pic);

        imgVwPic = findViewById(R.id.imgVwPic);
        Intent intent = getIntent();

        String strMsg = intent.getStringExtra("varStr1");
        tvGreet = findViewById(R.id.tvGreet);
        tvGreet.setText("Welcome to second Activity " + strMsg);

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
    public void fnTakePic(View view) {
        Runnable run = new Runnable(){
            public void run(){

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

                runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        tvGreet.setText(tvGreet.getText().toString() + ".. This is your Picture heheh..");
                    }
                });
            }
        };

        Thread thr = new Thread(run);
        thr.start();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imgVwPic.setImageBitmap(bp);
    }
}
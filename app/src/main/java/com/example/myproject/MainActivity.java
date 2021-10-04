package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void onClick(View v) {
        if(v.getId() == R.id.button1) {
            Log.d("confirm","good");
            Intent intent = new Intent(MainActivity.this, GradeActivity.class);
            startActivity(intent);
        }

        if(v.getId() == R.id.button2) {
            Intent intent = new Intent(MainActivity.this, ResActivity.class);
            startActivity(intent);
        }
    }
    void init() {
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
    }
}

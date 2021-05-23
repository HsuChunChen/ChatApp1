package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView logo1,logo2;
    private ImageView imageView;
    private Button signin,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start =findViewById(R.id.signin);
    }
    public void signin(View v){
        Intent intent =new Intent();
        intent.setClass(MainActivity.this , page2.class);
        startActivity(intent);
    }
    public void signup(View v){
        Intent intent =new Intent();
        intent.setClass(MainActivity.this , page3.class);
        startActivity(intent);
    }
}
package com.example.tictactoe.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tictactoe.R;

public class ThirdPage extends AppCompatActivity {

    String[] shayri_arr;
    TextView textView;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        shayri_arr=getIntent().getStringArrayExtra("shayriarr");
        pos=getIntent().getIntExtra("pos",0);
        textView=findViewById(R.id.text);

        textView.setText(shayri_arr[pos]);


    }
}
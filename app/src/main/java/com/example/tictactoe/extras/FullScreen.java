package com.example.tictactoe.extras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tictactoe.R;

public class FullScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        int position=getIntent().getIntExtra("pos",0);
        String name=getIntent().getStringExtra("name");
        int[] images=getIntent().getIntArrayExtra("imgarr");

        TextView textView=findViewById(R.id.text);
        ImageView imageView=findViewById(R.id.images);

        textView.setText(name);
        imageView.setImageResource(images[position]);

    }
}
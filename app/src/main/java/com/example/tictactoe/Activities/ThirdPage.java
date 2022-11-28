package com.example.tictactoe.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tictactoe.Config;
import com.example.tictactoe.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ThirdPage extends AppCompatActivity {

    String[] shayri_arr;
    TextView textView;
    Button b,t;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        shayri_arr=getIntent().getStringArrayExtra("shayriarr");
        pos=getIntent().getIntExtra("pos",0);
        textView=findViewById(R.id.text);
        textView.setText(shayri_arr[pos]);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"BRITANIC.TTF");
        textView.setTypeface(typeface);


        b=findViewById(R.id.b);
        b.setOnClickListener(view -> {
//            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
//            View view1= LayoutInflater.from(this).inflate(R.layout.background,null);
//
//            GridView gridView=view1.findViewById(R.id.grid);
//            textView.setBackgroundColor(getResources().getColor(Config.colors[0]));
//
//            bottomSheetDialog.setContentView(view1);
//            bottomSheetDialog.show();
        });
        t=findViewById(R.id.t);
        t.setOnClickListener(view -> {

            Bitmap icon = getBitmapFromView(textView);
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//            int num=new Random().nextInt(2000);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());
            File f = new File(Config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
            try {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
                Toast.makeText(this, "FIle downloaded", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            share.putExtra(Intent.EXTRA_STREAM, Uri.parse(f.getAbsolutePath()));
            startActivity(Intent.createChooser(share, "Share Image"));
//
//            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
//            View view1= LayoutInflater.from(this).inflate(R.layout.background,null);
//
//            GridView gridView=view1.findViewById(R.id.grid);
//            gridView.setNumColumns(Config.fonts.length);
//
//            bottomSheetDialog.setContentView(view1);
//            bottomSheetDialog.show();
        });
    }
    public static Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }
}
package com.example.tictactoe.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tictactoe.Adapters.CategoryAdapter;
import com.example.tictactoe.Config;
import com.example.tictactoe.R;
import com.example.tictactoe.extras.FullScreen;

import java.io.File;

public class CategoryList extends AppCompatActivity {

    ListView listView;
    int[] images={R.drawable.bearbar,R.drawable.bestwishesh,R.drawable.bewfa,R.drawable.birthday,R.drawable.boyfriendgirl,
            R.drawable.child};
    String[] arr={"Bear bar","Best wishes","bewafa","Birthday","Boy Friend","CHild"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdemo);

        listView=findViewById(R.id.list);
        CategoryAdapter myAdapter=new CategoryAdapter(this,arr,images);
        listView.setAdapter(myAdapter);

        ActivityCompat.requestPermissions(CategoryList.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(arr[i]);

                Intent intent=new Intent(CategoryList.this, ShayriList.class);
                intent.putExtra("pos",i);
                intent.putExtra("cate_arr",arr);
                intent.putExtra("imgarr",images);
                startActivity(intent);
            }
        });

//        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.list_item,R.id.text,arr);
//        listView.setAdapter(arrayAdapter);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                    Config.file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)+"/test");
                    if(Config.file.exists())
                    {
                        System.out.println("already created");
                    }
                    else
                    {
                        if(Config.file.mkdir())
                        {
                            System.out.println("folder created");
                        }
                        else {
                            System.out.println("folder not created");
                        }
                    }
                } else {
                    ActivityCompat.requestPermissions(CategoryList.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            1);
                    Toast.makeText(CategoryList.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
package com.example.tictactoe.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tictactoe.Adapters.CategoryAdapter;
import com.example.tictactoe.R;
import com.example.tictactoe.extras.FullScreen;

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
}
package com.example.tictactoe.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tictactoe.Adapters.CategoryAdapter;
import com.example.tictactoe.Adapters.ShayriAdapter;
import com.example.tictactoe.R;

public class ShayriList extends AppCompatActivity {
    ListView listView;
    int pos;
    String[] category_arr;
    int[] img_arr;
    String category_name;
    int category_img;
    ActionBar actionBar;
    String[] bear_arr={"Bear bar1","Bear bar12","Bear bar13","Bear bar14","Bear bar15"};
    String[] bestwishes_arr={"Best wishes1","Best wishes2","Best wishes3","Best wishes4"};
    String[] bewafa_arr={"bewafa","bewafa2","bewafa3","bewafa5","bewafa6"};
    String[] birth_arr={"Birthday1","Birthday22","Birthday3","Birthday44","Birthday55"};
    String[] child_arr={"CHild11","CHild22","CHild33","CHild44","CHild55","CHild66","CHild77"};
    String[] temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri_list);

        pos=getIntent().getIntExtra("pos",0);
        category_arr=getIntent().getStringArrayExtra("cate_arr");
        img_arr=getIntent().getIntArrayExtra("imgarr");

        category_name=category_arr[pos];
        actionBar=getSupportActionBar();
        actionBar.setTitle(category_name);
        category_img=img_arr[pos];

        if(pos==0)
        {
            temp=bear_arr;
        }
        if(pos==1)
        {
            temp=bestwishes_arr;
        }
        if(pos==2)
        {
            temp=bewafa_arr;
        }
        if(pos==3)
        {
            temp=birth_arr;
        }if(pos==4)
        {
            temp=child_arr;
        }

        listView=findViewById(R.id.list2);
        ShayriAdapter myAdapter=new ShayriAdapter(this,temp,category_img);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent  intent=new Intent(ShayriList.this,ThirdPage.class);
                intent.putExtra("shayriarr",temp);
                intent.putExtra("pos",i);
                startActivity(intent);
            }
        });




    }
}
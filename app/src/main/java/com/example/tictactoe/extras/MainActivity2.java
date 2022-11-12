package com.example.tictactoe.extras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tictactoe.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button[] b=new Button[9];
    int c=0;
    ArrayList arrayList=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for(int i=0;i<b.length;i++)
        {
            //r.id.b1
            int id=getResources().getIdentifier("b"+i,"id",getPackageName());
            b[i]=findViewById(id);
            b[i].setOnClickListener(this);
        }
//
//        for(int i=0;i<9;i++)
//        {
//            while (true)
//            {
//                int max=10;
//                int min=0;
//                int r=new Random().nextInt(max-min)+min;
//                System.out.println(r);
//                if(!arrayList.contains(r))
//                {
//                    System.out.println("final="+r);
//                    arrayList.add(r);
//                    if(r==0)
//                    {
//                        b[i].setText("");
//                    }
//                    else
//                    {
//                        b[i].setText(""+r);
//                    }
//                    break;
//                }
//            }
//
//        }
        System.out.println(arrayList);
    }

    @Override
    public void onClick(View view) {
        for(int i=0;i<b.length;i++)
        {
           if(view.getId()==b[i].getId())
           {
                b[i].setText("O");
                arrayList.add(i);
                c++;

                if(c<=4)
                {
                    while (true)
                    {
                        int max=9;
                        int min=0;
                        int r=new Random().nextInt(max-min)+min;
                        System.out.println(r);
                        if(!arrayList.contains(r))
                        {
                            System.out.println("final="+r);
                            b[r].setText("X");
                            arrayList.add(r);
                            break;
                        }
                    }
                }
           }
        }
    }
}
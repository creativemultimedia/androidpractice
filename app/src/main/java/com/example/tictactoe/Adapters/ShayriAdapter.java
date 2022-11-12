package com.example.tictactoe.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tictactoe.Activities.CategoryList;
import com.example.tictactoe.R;

public class ShayriAdapter extends BaseAdapter {

    String[] arr;
    int image;
    Context c;
    public ShayriAdapter(Context c, String[] arr, int image) {
        this.c=c;
        this.arr=arr;
        this.image=image;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(c).inflate(R.layout.list_item,viewGroup,false);

        TextView textView=view.findViewById(R.id.text);
        ImageView imageView=view.findViewById(R.id.img);

        textView.setText("Hello "+arr[i]);
        imageView.setImageResource(image);

        return view;
    }
}

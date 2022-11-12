package com.example.tictactoe.extras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tictactoe.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    Button one,two,three,four, five, six, seven, eight, nine,reset;
    TextView txt,txtO,txtX;
    int cnt=0,cntx=0,cnto=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        reset=findViewById(R.id.reset);
        txt=findViewById(R.id.textWin);
        txtX=findViewById(R.id.txtX);
        txtO=findViewById(R.id.txtO);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        reset.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.one)
        {
            if(cnt%2==0)
            {
                one.setText("O");
                cnto++;
            }
            else
            {
                one.setText("X");
                cntx++;
            }
            cnt++;
            one.setClickable(false);
            win();
        }
        if(view.getId()==R.id.two)
        {
            if(cnt%2==0)
            {
                two.setText("O");
                cnto++;
            }
            else
            {
                two.setText("X");
                cntx++;
            }
            cnt++;
            two.setClickable(false);
            win();
        }
        if(view.getId()==R.id.three)
        {
            if(cnt%2==0)
            {
                three.setText("O");
                cnto++;
            }
            else
            {
                three.setText("X");
                cntx++;
            }
            cnt++;
            three.setClickable(false);
            win();
        }

        if(view.getId()==R.id.four)
        {
            if(cnt%2==0)
            {
                four.setText("O");
                cnto++;
            }
            else
            {
                four.setText("X");
                cntx++;
            }
            cnt++;
            four.setClickable(false);
            win();
        }
        if(view.getId()==R.id.five)
        {
            if(cnt%2==0)
            {
                five.setText("O");
                cnto++;
            }
            else
            {
                five.setText("X");
                cntx++;
            }
            cnt++;
            five.setClickable(false);
            win();
        }
        if(view.getId()==R.id.six)
        {
            if(cnt%2==0)
            {
                six.setText("O");
                cnto++;
            }
            else
            {
                six.setText("X");
                cntx++;
            }
            cnt++;
            six.setClickable(false);
            win();
        }
        if(view.getId()==R.id.seven)
        {
            if(cnt%2==0)
            {
                seven.setText("O");
                cnto++;
            }
            else
            {
                seven.setText("X");
                cntx++;
            }
            cnt++;
            seven.setClickable(false);
            win();
        }
        if(view.getId()==R.id.eight)
        {
            if(cnt%2==0)
            {
                eight.setText("O");
                cnto++;
            }
            else
            {
                eight.setText("X");
                cntx++;
            }
            cnt++;
            eight.setClickable(false);
            win();
        }
        if(view.getId()==R.id.nine)
        {
            if(cnt%2==0)
            {
                nine.setText("O");
                cnto++;
            }
            else
            {
                nine.setText("X");
                cntx++;
            }
            cnt++;
            nine.setClickable(false);
            win();
        }
        txtO.setText("O= "+cnto);
        txtX.setText("X= "+cntx);
        if(view.getId()==R.id.reset)
        {
            cnt=0;
            cntx=0;
            cnto=0;
            one.setClickable(true);
            two.setClickable(true);
            three.setClickable(true);
            four.setClickable(true);
            five.setClickable(true);
            six.setClickable(true);
            seven.setClickable(true);
            eight.setClickable(true);
            nine.setClickable(true);
            one.setText("");
            two.setText("");
            three.setText("");
            four.setText("");
            five.setText("");
            six.setText("");
            seven.setText("");
            eight.setText("");
            nine.setText("");
            txt.setText("");
            txtO.setText("");
            txtX.setText("");
        }
    }
    public void win()
    {
        if(one.getText().toString().equalsIgnoreCase("o")&&two.getText().toString().equalsIgnoreCase("o") && three.getText().toString().equalsIgnoreCase("o"))
        {
            txt.setText("O is Winner..");
            disable();
        }
        else if(one.getText().toString().equalsIgnoreCase("x")&&two.getText().toString().equalsIgnoreCase("x") && three.getText().toString().equalsIgnoreCase("x"))
        {
            txt.setText("X is winner..");
            disable();
        }
        else if(one.getText().toString().equalsIgnoreCase("o")&&four.getText().toString().equalsIgnoreCase("o") && seven.getText().toString().equalsIgnoreCase("o"))
        {
            txt.setText("O is Winner..");
            disable();
        }
        else if(one.getText().toString().equalsIgnoreCase("x")&&four.getText().toString().equalsIgnoreCase("x") && seven.getText().toString().equalsIgnoreCase("x"))
        {
            txt.setText("X is winner..");
            disable();
        }
        else if(two.getText().toString().equalsIgnoreCase("o")&&five.getText().toString().equalsIgnoreCase("o") && eight.getText().toString().equalsIgnoreCase("o"))
        {
            txt.setText("O is Winner..");
            disable();
        }
        else if(two.getText().toString().equalsIgnoreCase("x")&&five.getText().toString().equalsIgnoreCase("x") && eight.getText().toString().equalsIgnoreCase("x"))
        {
            txt.setText("X is winner..");
            disable();
        }
        else if(three.getText().toString().equalsIgnoreCase("o")&&six.getText().toString().equalsIgnoreCase("o") && nine.getText().toString().equalsIgnoreCase("o"))
        {
            txt.setText("O is Winner..");
            disable();
        }
        else if(three.getText().toString().equalsIgnoreCase("x")&&six.getText().toString().equalsIgnoreCase("x") && nine.getText().toString().equalsIgnoreCase("x"))
        {
            txt.setText("X is winner..");
            disable();
        }
        else if(one.getText().toString().equalsIgnoreCase("o")&&five.getText().toString().equalsIgnoreCase("o") && nine.getText().toString().equalsIgnoreCase("o"))
        {
            txt.setText("O is Winner..");
            disable();
        }
        else if(one.getText().toString().equalsIgnoreCase("x")&&five.getText().toString().equalsIgnoreCase("x") && nine.getText().toString().equalsIgnoreCase("x"))
        {
            txt.setText("X is winner..");
            disable();
        }
        else if(seven.getText().toString().equalsIgnoreCase("o")&&eight.getText().toString().equalsIgnoreCase("o") && nine.getText().toString().equalsIgnoreCase("o"))
        {
            txt.setText("O is Winner..");
            disable();
        }
        else if(seven.getText().toString().equalsIgnoreCase("x")&&eight.getText().toString().equalsIgnoreCase("x") && nine.getText().toString().equalsIgnoreCase("x"))
        {
            txt.setText("X is winner..");
            disable();
        }
        else if (cnt==9)
        {
            txt.setText("Drawn...");
            disable();
        }
    }
    public void disable()
    {
        one.setClickable(false);
        two.setClickable(false);
        three.setClickable(false);
        four.setClickable(false);
        five.setClickable(false);
        six.setClickable(false);
        seven.setClickable(false);
        eight.setClickable(false);
        nine.setClickable(false);
    }
}
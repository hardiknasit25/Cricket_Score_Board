package com.example.cricket_score_board;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button zero,one,two,three,four,six,wide,out,noball,reset,minus,undo;

    EditText target,need;

    Switch noBall,Wide;
    int count = 0;
    int dandi = 0;

    int ball = 0;

    int currentover = 0;
    int ewideruns = 0;
    int enoballruns = 0;

    int total ;

//    int Truns;

//    EditText Truns;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        runs = findViewById(R.id.runs);
//        wicket = findViewById(R.id.wicket);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        six = findViewById(R.id.six);
        out = findViewById(R.id.out);
        reset = findViewById(R.id.reset);
        minus = findViewById(R.id.minus);
        wide = findViewById(R.id.wide);
        Wide = findViewById(R.id.Wide);
        noBall = findViewById(R.id.noBall);
        noball = findViewById(R.id.noball);
        target = findViewById(R.id.target);
        need = findViewById(R.id.need);
        undo = findViewById(R.id.undo);

    }

    public void setCount0(View view){
        ball++;
        displayOver(ball);
    }
    public void setCount1(View view){
        count = count + 1;
        ball++;
        display(count);
        displayOver(ball);
        displayNeed(count);
    }

    public void setCount2(View view){
        count = count + 2;
        ball++;
        display(count);
        displayOver(ball);
        displayNeed(count);
    }

    public void setCount3(View view){
        count = count + 3;
        display(count);
        ball++;
        displayOver(ball);
        displayNeed(count);
    }

    public void setCount4(View view){
        count = count + 4;
        display(count);
        ball++;
        displayOver(ball);
        displayNeed(count);
    }

    public void setCount6(View view){
        count = count + 6;
        display(count);
        ball++;
        displayOver(ball);
        displayNeed(count);
    }

    public void setdandi(View view){
        dandi = dandi + 1;
        displaywicket(dandi);
        ball++;
        displayOver(ball);
    }

    public void setReset(View view){
        count = 0;
        dandi = 0;
        display(count);
        displaywicket(dandi);
        ball = 0;
        currentover = 0;
        displayOver(ball);
        ewideruns = 0;
        displayExtraWide(ewideruns);
        enoballruns = 0;
        displayExtraNoBall(enoballruns);
        displayNeed(count);
    }

    public void setMinus(View view){
        count--;
        display(count);
        displayNeed(count);
    }

    public void setUndo(View view){
        ball--;
        displayOver(ball);
    }

    public void setWide(View view){
        if(Wide.isChecked()){
            count++;
            ewideruns++;
            display(count);
            displayExtraWide(ewideruns);
            displayNeed(count);
        }else{
            Toast.makeText(this, "Wide Is Not Counted For This Match", Toast.LENGTH_SHORT).show();
        }
    }
    public void setNoball(View view){
        if(noBall.isChecked()){
            count++;
            enoballruns++;
            display(count);
            displayExtraNoBall(enoballruns);
            displayNeed(count);
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.noball_runs);
            Button btnzero = dialog.findViewById(R.id.btnzero);
            Button btnone = dialog.findViewById(R.id.btnone);
            Button two1 = dialog.findViewById(R.id.two1);
            Button three1 = dialog.findViewById(R.id.three1);
            Button four1 = dialog.findViewById(R.id.four1);
            Button six1 = dialog.findViewById(R.id.six1);

            btnzero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            btnone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setbtnone();
                    dialog.dismiss();
                }
            });
            two1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setbtntwo();
                    dialog.dismiss();
                }
            });
            three1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setbtnthree();
                    dialog.dismiss();
                }
            });
            four1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setbtnfour();
                    dialog.dismiss();
                }
            });
            six1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setbtnsix();
                    dialog.dismiss();
                }
            });

            dialog.show();
        }else{
            Toast.makeText(this, "NoBall Is Not Counted For This Match", Toast.LENGTH_SHORT).show();
        }
    }
    public void display(int number) {
        TextView runs = findViewById(R.id.runs);
        runs.setText(Integer.toString(number));
    }
    public void displaywicket(int number) {
        TextView wicket = findViewById(R.id.wicket);
        wicket.setText(Integer.toString(number));
    }
    public void displayOver(int number) {
        TextView over = findViewById(R.id.over);
        if (ball == 6) {
            currentover++;
            ball = 0;
        }
        over.setText(String.format("%d.%d", currentover, ball));
    }
    public void displayExtraWide(int number) {
        TextView wideruns = findViewById(R.id.wideruns);
        wideruns.setText(String.format("%d WD",number));
    }
    public void displayExtraNoBall(int number) {
        TextView noballruns = findViewById(R.id.noballruns);
        noballruns.setText(String.format("%d NB",number));
    }
    public void displayNeed(int number) {
        EditText need = findViewById(R.id.need);
        EditText target = findViewById(R.id.target);
        String Truns = target.getText().toString();
        if (Truns == null) {
            int truns = 0;
            int Final = truns + number;
            need.setText(String.format("%d",Final));
//            need.setText(String.format("%d",number));
        } else {
            int truns = Integer.parseInt(Truns);
            int Final = truns - number;
            need.setText(String.format("%d",Final));
        }

    }
    public void setbtnone(){
        count = count + 1;
        display(count);
    }
    public void setbtntwo(){
        count = count + 2;
        display(count);
    }
    public void setbtnthree(){
        count = count + 3;
        display(count);
    }
    public void setbtnfour(){
        count = count + 4;
        display(count);
    }
    public void setbtnsix(){
        count = count + 6;
        display(count);
    }
}
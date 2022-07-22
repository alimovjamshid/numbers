package com.example.numbers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random x=new Random();
    int numb=x.nextInt(100);
    int s=3;
    String bir[]={"zero","one","two","three","four","five","six",
            "seven","eight","nine"};
    String ikki[]={"ten","eleven","twelve","thirteen","fourteen","fifteen",
        "sixteen","seventeen","eighteen","nineteen","twenty","thirty","forty",
            "fifty","sixty","seventy","eighty","ninety"};
    String uch="hundred";
    String tort="thousand";
    int aka=0,uka=0;
    public static String toString(int i){
        return "i";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text=findViewById(R.id.textView);
        TextView plus=findViewById(R.id.textView3);
        TextView minus=findViewById(R.id.textView4);
        String mm=Integer.toString(numb);
        text.setText(mm);
        plus.setText(plus.getText().toString()+aka);
        minus.setText(minus.getText().toString()+uka);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView textView=findViewById(R.id.textView);
        switch (item.getItemId()){
            case R.id.easy:
                s=2;
                numb=x.nextInt(100);
                textView.setText(Integer.toString(numb));
                return true;
            case R.id.medium:
                s=3;
                numb=x.nextInt(1000);
                textView.setText(Integer.toString(numb));
                return true;
            case R.id.hard:
                s=4;
                numb=x.nextInt(10000);
                textView.setText(Integer.toString(numb));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){

        TextView textView=findViewById(R.id.textView);
        EditText editText=findViewById(R.id.editText);
        TextView plus=findViewById(R.id.textView3);
        TextView minus=findViewById(R.id.textView4);
        String label="";
        String text=textView.getText().toString();

        int q;
        if(text.length()==1){
            label+=bir[numb];
        }
        if(text.length()==2) {
            if (text.charAt(0) == '1') {
                q = numb % 10;
                label += ikki[q];
            } else {
                q = numb / 10;
                if(q!=0) {
                    label += ikki[q + 8] + " ";
                }
                numb = numb % 10;
                if (numb != 0) {
                    label += bir[numb];
                }
            }
        }
        if(text.length()==3) {
            int qq = numb / 100;
            label += bir[qq] + " " + uch + " ";
            numb = numb % 100;
            if (text.charAt(1) == '1') {
                qq = numb % 10;
                label += ikki[qq];
            } else {
                    qq = numb / 10;
                    if(qq!=0) {
                        label += ikki[qq + 8] + " ";
                    }
                    numb = numb % 10;
                    label += bir[numb];
            }
        }
        if(text.length()==4){
            int qqq=numb/1000;
            label+=bir[qqq]+" "+tort+" ";
            numb=numb%1000;
            qqq=numb/100;
            if(qqq!=0) {
                label += bir[qqq] + " " + uch + " ";
            }
            numb=numb%100;
            textView.setText(label);
            if (text.charAt(0) == '1') {
                qqq = numb % 10;
                label += ikki[qqq];
            }
            else {
                qqq = numb / 10;
                if (qqq != 0) {
                    label += ikki[qqq + 8] + " ";
                }
                numb = numb % 10;
                if (numb != 0) {
                    label += bir[numb];
                }
            }
        }

        String a=editText.getText().toString();
        a=a.trim();
        if(a.equalsIgnoreCase(label)){
            aka++;
            plus.setText("True  :  "+aka);
        }
        else {
            uka++;
            minus.setText("False  :  "+uka);
        }

        if(s==2) {
            numb = x.nextInt(100);
            textView.setText(Integer.toString(numb));
        }
        if (s == 3) {
            numb = x.nextInt(1000);
            textView.setText(Integer.toString(numb));
        }
        if (s == 4) {
            numb = x.nextInt(10000);
            textView.setText(Integer.toString(numb));
        }
    }
}
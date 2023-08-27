package com.example.squarechecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
TextView tv1,tv2,tv3,tv4;
Button b1;
EditText et1;
int count=0;
int sec=0;
int solv=0;


int a;
Timer T;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) findViewById(R.id.textView3);
        tv2=(TextView)findViewById(R.id.time);
        tv3=(TextView) findViewById(R.id.textView4) ;
        tv4=(TextView) findViewById(R.id.textView5);
        et1=(EditText) findViewById(R.id.editTextNumber);
        b1=(Button) findViewById(R.id.button3);
        //b2=(Button)findViewById(R.id.button);

        try {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;





                    if (count == 1) {
                        Random random = new Random();
                        a = random.nextInt(125);
                        String as = String.valueOf(a + "²");
                        tv1.setText(as);
                        Timer T = new Timer();
                        T.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                tv2.setText("" + sec);
                                sec++;
                            }
                        }, 1000, 1000);


                    } else if (count == 2) {
                        String ans = et1.getText().toString();
                        Integer ans1 = Integer.parseInt(ans);



                        int sq = a * a;





                        if (sq == ans1) {

                            solv++;
                            Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                            Random random = new Random();
                            a = random.nextInt(125);
                            String as = String.valueOf(a + "²");
                            tv1.setText(as);
                            et1.setText("");
                            tv3.setText("Solved Questions: " + String.valueOf(solv));
                            count = 1;

                            sec = 0;


                        } else if (sq != ans1) {
                            Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                            count = 1;
                            tv4.setText(String.valueOf(sq));
                        }

                    }

                }


            });









        }
        catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

        }





    }







}
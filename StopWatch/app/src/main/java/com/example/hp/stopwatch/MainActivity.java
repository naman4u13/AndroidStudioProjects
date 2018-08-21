package com.example.hp.stopwatch;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    boolean val;
    Button time;
    Button reset;


    int mls, sec, min, day, hr;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = (Button) findViewById(R.id.time);
        reset = (Button) findViewById(R.id.reset);

        val = false;
        mls = 0;
        sec = 0;
        min  = 0;
        day= 0;
        hr = 0;

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Push(v);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset(v);
            }
        });
    }

     public void Reset(View view)
    {
        time.setText("00:00:00");
        mls = 0;
        sec = 0;
        min  = 0;
        day= 0;
        hr = 0;


    }

    public void Push(View view)
    {
        val = !val;

                        while (val)
                        {

                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            mls++;
                            if (mls == 100) {
                                mls = 0;
                                sec++;
                            }
                            if (sec == 60) {
                                sec = 0;
                                min++;
                            }
                            if (min == 60) {
                                min = 0;
                                hr++;
                            }
                            if (hr == 24) {
                                hr = 0;
                                day++;
                            }

                            time.setText(day + " " + hr + " " + min + " " + sec + " " + mls);


                        }



    }


}





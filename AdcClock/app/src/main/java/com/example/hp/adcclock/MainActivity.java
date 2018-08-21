package com.example.hp.adcclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button time;
    Button reset;
    time Time;
    advclock obj;
    boolean val;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Time = new time();
        time = (Button) findViewById(R.id.time);
        reset = (Button) findViewById(R.id.reset);
        val = true;
        obj = null;
    }

    public void Reset(View view) {
        time.setText("00:00:00");

    }

    public void Push(View view)
    {


            obj = new advclock(Time);
            while (true) {

                if (Time.mls > 100) {
                    Time.mls = 0;
                    Time.sec++;
                }
                if (Time.sec > 60) {
                    Time.sec = 0;
                    Time.min++;
                }
                if (Time.min > 60) {
                    Time.min = 0;
                    Time.hr++;
                }
                if (Time.hr > 24) {
                    Time.hr = 0;
                    Time.day++;
                }



            }
        }

}




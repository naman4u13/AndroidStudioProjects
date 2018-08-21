package com.example.hp.adcclock;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;



public class advclock implements Runnable
{
    time Time;
    Thread t;
    function f;
    advclock(time Time)
    {
        this.Time = Time;
        t = new Thread(this,"clock");
        f = new function(Time);
        t.start();


    }
    public void run()
    {

        f.fun();

    }

}


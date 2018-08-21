package com.example.hp.adcclock;

/**
 * Created by hp on 20-01-2018.
 */

public class function
{

        time Time;
        function(time Time)
        {
            this.Time = Time;
        }
        public void fun()
        {
            while(true)
            {
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {

                    e.printStackTrace();
                }
                Time.mls++;

            }
        }
    }



package com.example.hp.advcalc;

/**
 * Created by hp on 15-01-2018.
 */

public class Estimate
{

        float estimate(float i, float j, char c)throws ArithmeticException
        {
            switch(c)

            {
                case '+':return(i+j);
                case '-':return(i-j);
                case '*':return(i*j);
                case '/':return(i/j);
                default: return 0;
            }
        }


}

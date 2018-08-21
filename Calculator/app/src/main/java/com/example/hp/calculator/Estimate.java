package com.example.hp.calculator;

/**
 * Created by hp on 15-01-2018.
 */

public class Estimate
{

        int estimate(int i,int j,char c)
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

package com.example.hp.calculator;

/**
 * Created by hp on 14-01-2018.
 */

public class Priority
{

        int priority(char x)
        {
            if(x == '(')
            {  return 0;}
            else if(x == '+' || x == '-')
            { return 1;}
            else
            {return 2;}



        }



}

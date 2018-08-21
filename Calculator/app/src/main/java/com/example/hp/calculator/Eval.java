package com.example.hp.calculator;

/**
 * Created by hp on 15-01-2018.
 */

public class Eval
{



        static  int eval(String exp)
        {
            Stack x = new Stack();
            Estimate y = new Estimate();
            char ch;
            int op1,op2,i,j,sum;
            i=0;j=0;sum =0;
            int len = exp.length();
            while(i!=len)
            {
                ch = exp.charAt(i);
                if(ch=='(')
                {
                    i++;
                    while(exp.charAt(i)!=')')
                    {
                        j=Character.getNumericValue(exp.charAt(i));
                        sum = sum*10+j;
                        i++;
                    }
                    x.push(sum,'\u0000',1);
                    sum =0;
                }
                else if(Character.isDigit(ch))
                {
                    j=Character.getNumericValue(ch);
                    x.push(j,  '\u0000', 1);

                }
                else
                {
                    op2 =((inode)x.pop()).data;

                    op1 = ((inode)x.pop()).data;

                    j = y.estimate(op1,op2,ch);
                    x.push(j ,'\u0000', 1);
                }
                i++;
            }
               return (((inode)x.pop()).data);
        }


}



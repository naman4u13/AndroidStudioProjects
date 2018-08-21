package com.example.hp.advcalc;

/**
 * Created by hp on 15-01-2018.
 */

public class Eval
{



        static float eval(String exp)
        {
            Stack x = new Stack();
            Estimate y = new Estimate();
            char ch;
            float op1,op2,sum,SUM;
            int i,j;
            i=0;j=0;sum =0;
            int flag =0;
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
                        if(exp.charAt(i)=='.')
                        {
                            flag =i;
                            i++;

                        }
                    }
                    if(flag!=0)
                    {
                        sum = (float) (sum/ Math.pow(10,(i-flag-1)));
                        flag =0;
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
                    try
                    {
                        SUM = y.estimate(op1, op2, ch);
                        x.push(SUM, '\u0000', 1);
                    }
                    catch(ArithmeticException e)
                    {
                        throw e;
                    }
                }
                i++;
            }
               return (((inode)x.pop()).data);
        }


}



package com.example.hp.advcalc;

/**
 * Created by hp on 14-01-2018.
 */

public class Postfix {

        static String convert(String infexp)
        {
            Stack obj = new Stack();
            Priority y = new Priority();
            cnode x;
            char ch;
            char topdata;
            int i=0;
            String posexp = null;
            String temp = null;
            int len=infexp.length();
            while(i<len)
            {
                ch = infexp.charAt(i);
                if(Character.isDigit(ch))
                {

                    if(((i+1)<len)&&(Character.isDigit(infexp.charAt(i+1))||infexp.charAt(i+1)=='.'))
                    {
                        while(Character.isDigit(ch)||ch=='.')
                        {
                            temp = temp+ch;
                            i++;
                            if(i<len)
                            {
                                ch = infexp.charAt(i);
                            }
                            else
                            {
                                break;
                            }
                        }
                        temp = "("+temp+")";
                        i--;
                    }

                    else
                    {
                        temp = temp+ch;
                    }
                    posexp = posexp + temp;
                    temp = null;
                }
                else if(Character.isLetter(ch))
                {
                    posexp = posexp+ch;
                }
                else if(ch=='(')
                {
                    obj.push(0,ch,0);
                }
                else if((ch=='+')||(ch=='-')||(ch=='*')||(ch=='/'))
                {
                    if(obj.isempty())
                    {
                        obj.push(0,ch,0);
                    }
                    else
                    {
                        x = (cnode) obj.pop();
                        topdata = x.data;
                        obj.push(0,topdata,0);

                        if((y.priority(ch))>(y.priority(topdata)))
                        {
                            obj.push(0,ch,0);
                        }
                        else
                        {

                            while((y.priority(ch))<=(y.priority(topdata)))
                            {
                                x = (cnode) obj.pop();
                                topdata = x.data;
                                posexp = posexp + topdata;
                                if(!(obj.isempty()))
                                {
                                    x = (cnode) obj.pop();
                                    topdata = x.data;
                                    obj.push(0,topdata,0);
                                }
                                else
                                {
                                    break;
                                }


                            }
                            obj.push(0,ch,0);

                        }
                    }
                }
                else if(ch==')')
                {
                    x = (cnode) obj.pop();
                    topdata = x.data;

                    while(topdata!='(')
                    {

                        posexp=posexp+topdata;
                        x = (cnode) obj.pop();
                        topdata = x.data;



                    }

                }
                i++;
            }
            while(!obj.isempty())
            {
                x = (cnode) obj.pop();
                topdata = x.data;
                posexp = posexp + topdata;

            }

            posexp = posexp.replace("null","");
            return posexp;

        }



}



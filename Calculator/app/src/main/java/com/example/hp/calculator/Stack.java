package com.example.hp.calculator;

/**
 * Created by hp on 14-01-2018.
 */





    public class Stack implements StackBP {
        node top;
        cnode ctemp;
        inode itemp;
        Stack()
        {
            top =null;
            ctemp = new cnode();
            itemp = new inode();
        }
        public void push(int idata,char cdata,int status)
        {

            if(status == 0)
            {
                ctemp.data = cdata;
                ctemp.next = top;
                top = ctemp;
                ctemp = new cnode();

            }
            else if(status == 1)
            {
                itemp.data = idata;
                itemp.next = top;
                top = itemp;
                itemp = new inode();
            }

            top.status = status;
        }

        public node pop()
        {
            node temp = top;
            if(top!=null)
            {


                top = top.next;


            }
            return temp;
        }

        public void top()
        {

            if(top==null)
            {
                System.out.println("Stack is empty");
            }
            else
            {
                if(top.status == 0)
                {
                    ctemp = (cnode) top;
                    System.out.println(ctemp.data);
                }
                else if(top.status == 1)
                {
                    itemp = (inode)top;
                    System.out.println(itemp.data);
                }

            }
        }

        public boolean isempty()
        {
            if(top == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }






    }



package com.example.hp.calculator;

/**
 * Created by hp on 14-01-2018.
 */

interface StackBP {
    void push(int idata,char cdata,int Status);
    node pop();
    void top();
    boolean isempty();


}

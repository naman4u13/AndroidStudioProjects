package com.example.hp.advcalc;

/**
 * Created by hp on 14-01-2018.
 */

interface StackBP {
    void push(float idata,char cdata,int Status);
    node pop();
    void top();
    boolean isempty();


}

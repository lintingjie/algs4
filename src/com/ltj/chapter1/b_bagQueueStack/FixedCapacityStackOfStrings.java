package com.ltj.chapter1.b_bagQueueStack;

/**
 * Created by ltj on 2019/3/7
 * 定容字符串栈
 */
public class FixedCapacityStackOfStrings {

    String[] a;
    int N = 0;

    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }

    public void push(String item){
       a[N++] = item;
    }

    String pop(){
        return a[--N];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public boolean isFull(){
        return N == a.length;
    }
}

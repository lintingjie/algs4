package com.ltj.chapter2.s4_Priority_Queues;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ltj on 2019/3/24
 */
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public OrderedArrayMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n== 0;
    }

    public void insert(Key key){
        pq[n++] = key;
        for (int i = n-1; i >= 0; i--) {
            if(less(i, i-1)){
                exch(i, i-1);
            }
        }
    }

    public Key delMax(){
        return pq[--n];
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty())
            StdOut.println(pq.delMax());
    }



}

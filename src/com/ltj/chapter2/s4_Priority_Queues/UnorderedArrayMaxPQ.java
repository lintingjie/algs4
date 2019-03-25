package com.ltj.chapter2.s4_Priority_Queues;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ltj on 2019/3/24
 */
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public UnorderedArrayMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key key) {
        pq[n++] = key;
    }

    public Key delMax() {
        if (n == 0) return null;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(max, n-1);
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
        UnorderedArrayMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<>(10);
        pq.insert(3);
        pq.insert(2);
        pq.insert(1);
        pq.insert(4);
        while (!pq.isEmpty())
            StdOut.println(pq.delMax());
    }


}

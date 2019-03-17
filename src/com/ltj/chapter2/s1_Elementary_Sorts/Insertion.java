package com.ltj.chapter2.s1_Elementary_Sorts;

import edu.princeton.cs.algs4.StdOut;

/**
 * 插入 排序
 * Created by ltj on 2019/3/17
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        Integer[] a = {3, 1, 5, 6, 2, 1};
        sort(a);
        show(a);
    }
}

package com.ltj.chapter2.s2_merge_sort;

/**
 * 归并排序：
 * 将两个有序的数组归并成一个更大的有序数组
 * Created by ltj on 2019/3/20
 */
public class Merge {

    private static Comparable[] aux;//归并所需的辅助数组

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = 0; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}

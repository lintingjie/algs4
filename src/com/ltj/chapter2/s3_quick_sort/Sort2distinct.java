package com.ltj.chapter2.s3_quick_sort;

/**
 * 将只有两个主键值的数组排序
 * Created by ltj on 2019/3/23
 */
public class Sort2distinct {

    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        int lt = 0, gt = a.length - 1;
        int i = 0;
        while (i <= gt) {
            if (a[i] < a[lt]) {
                exch(a, i++, lt++);
            } else if (a[i] > a[lt]) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 2, 1, 1, 2};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

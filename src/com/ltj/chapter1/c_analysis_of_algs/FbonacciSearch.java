package com.ltj.chapter1.c_analysis_of_algs;

import java.util.Arrays;

/**
 * 斐波那契查找实现
 * Created by ltj on 2019/3/16
 */
public class FbonacciSearch {


    /**
     * 斐波那契查找
     *
     * @param a
     * @param key
     * @return
     */
    public static int fbSearch(int[] a, int key) {
        int length = a.length;
        int k = 0;
        int[] fb = initFbArray(20);
        while (length > fb[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(a, fb[k] - 1);
        for (int i = length; i < temp.length; i++) {
            temp[i] = a[length - 1];//用最大数补齐
        }
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid  = lo + fb[k-1] - 1;
            if(key < a[mid]){
                hi = mid - 1;
                k = k - 1;//[low,mid-1]内的元素个数为F(k-1)-1个
            }else if(key > a[mid]){
                lo = mid + 1;
                k = k - 2;//[mid+1,high]内的元素个数为n-（F(k-1))= Fk-1-F(k-1)=Fk-F(k-1)-1=F(k-2)-1个
            }else{
                if(mid <= hi){
                    return mid;
                }else{
                    return hi;//补齐部分
                }
            }
        }
        return -1;
    }


    /**
     * 生成指定长度的斐波那契数列
     *
     * @param n
     * @return
     */
    public static int[] initFbArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 15, 22, 25, 31, 39, 42, 47, 49, 59, 68, 88, 88,
                88, 88, 88 };
        System.out.println("result: " + fbSearch(array, 31));
    }
}

package com.ltj.chapter1.s3_analysis_of_algs;

/**
 * 双调查找：
 * 数组中的元素是先递增后递减的
 * Created by ltj on 2019/3/15
 */
public class BitonicMax {
     public static int max(int[] a, int lo, int hi){
         if(lo == hi) return lo;
         int mid = lo + (hi - lo)/2;
         if(a[mid] > a[mid+1]){
             return max(a, lo, mid);
         }else if(a[mid] < a[mid+1]){
             return max(a, mid+1, hi);
         }else{
             return mid;
         }
     }

     public static int max(int[] a){
         int maxIndex = max(a, 0, a.length-1);
         return a[maxIndex];
     }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,3,2,0};
        System.out.println(max(a));
    }

}

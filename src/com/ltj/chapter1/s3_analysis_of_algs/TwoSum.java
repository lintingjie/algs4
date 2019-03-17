package com.ltj.chapter1.s3_analysis_of_algs;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

/**
 * Created by ltj on 2019/3/14
 */
public class TwoSum {
    public static int count(int[] a){
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if(BinarySearch.rank(-a[i],a)>i){
                count++;
            }
        }
        return count;

    }
}

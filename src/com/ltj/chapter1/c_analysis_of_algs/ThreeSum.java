package com.ltj.chapter1.c_analysis_of_algs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by ltj on 2019/3/13
 */
public class ThreeSum {

    public static int count(int[] a){
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(a[i]+a[j]+a[k] == 0){
                      count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 2000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = count(a);
        double time = timer.elapsedTime();
        System.out.println(cnt + " triples, "+ time+" seconds");
    }
}

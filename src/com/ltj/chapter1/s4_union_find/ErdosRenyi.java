package com.ltj.chapter1.s4_union_find;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by ltj on 2019/3/17
 */
public class ErdosRenyi {

    public static int count(int N){
        WeightQuickUnionUF uf = new WeightQuickUnionUF(N);
        int connection = 0;
        while(uf.count()>1) {
            int a = StdRandom.uniform(N);
            int b = StdRandom.uniform(N);
            if (!uf.connected(a, b)) {
                uf.union(a, b);
                connection++;
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(count(10));
    }
}

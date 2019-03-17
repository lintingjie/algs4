package com.ltj.chapter1.s4_union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 加权quick-union算法：
 * 将较小的树连接到较大的树上
 * Created by ltj on 2019/3/17
 */
public class WeightQuickUnionByHeightUF {
    private int[] id;
    private int[] height;//树的高度
    private int count;

    public WeightQuickUnionByHeightUF(int N){
        count = N;
        id = new int[N];
        height = new int[N];
        for (int i = 0; i < N; i++) {
            id[i]  = i;
            height[i] = 0;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        //较矮的树连接到较高的树
        if (height[pRoot] > height[qRoot]) {
            id[qRoot] = pRoot;
        }else if(height[pRoot] < height[qRoot]){
            id[pRoot] = qRoot;
        }else{
            id[pRoot] = qRoot;
            height[qRoot]++;
        }
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightQuickUnionByHeightUF uf = new WeightQuickUnionByHeightUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}

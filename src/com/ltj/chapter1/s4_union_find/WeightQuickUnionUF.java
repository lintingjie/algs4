package com.ltj.chapter1.s4_union_find;

/**
 * 加权quick-union算法：
 * 将较小的树连接到较大的树上
 * Created by ltj on 2019/3/17
 */
public class WeightQuickUnionUF {
    private int[] id;
    private int[] sz;//各个节点所对应的分量的大小
    private int count;

    public WeightQuickUnionUF(int N){
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i]  = i;
        }
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
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
        if (sz[pRoot] > sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }else{
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        count--;
    }
}

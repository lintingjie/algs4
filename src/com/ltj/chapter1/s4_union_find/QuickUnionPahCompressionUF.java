package com.ltj.chapter1.s4_union_find;

/**
 * 路径压缩的quick-union算法：
 * 在find()中添加一个循环，将在路径中遇到的所有节点都直接链接到根节点
 * Created by ltj on 2019/3/17
 */
public class QuickUnionPahCompressionUF {
    private int[] id;
    private int[] sz;//各个节点所对应的分量的大小
    private int count;

    public QuickUnionPahCompressionUF(int N){
        count = N;
        id = new int[N];
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
        int root = p;
        while(root != id[root]){
            root = id[root];
        }
        while(p != root){
            int newP = id[p];
            id[p] = root;
            p = newP;
        }
        return root;
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

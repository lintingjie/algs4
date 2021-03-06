package com.ltj.chapter1.s4_union_find;

/**
 *
 * Created by ltj on 2019/3/17
 */
public class QuickUnionUF {
    private int[] id;//分量id(以触电作为索引）
    private int count;//分量数量

    /**
     * 初始化N个触电
     * @param N
     */
    public QuickUnionUF(int N){
        //初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 连通分量的数量
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * p和q是否存在于同一个分量中
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * p所在分量的标识
     * @param p
     * @return
     */
    public int find(int p){
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    /**
     * 在p和q之间添加一条连接
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
}

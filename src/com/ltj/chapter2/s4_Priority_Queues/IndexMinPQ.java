package com.ltj.chapter2.s4_Priority_Queues;

/**
 * Created by ltj on 2019/3/30
 */
public class IndexMinPQ<Key extends Comparable<Key>> {

    private int N;     //PQ中的元素总量
    private int[] pq;  //索引二叉堆，由1开始
    private int[] qp;  //逆序：qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;//有优先级之分的元素


}

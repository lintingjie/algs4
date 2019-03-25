package com.ltj.chapter2.s4_Priority_Queues;

/**
 * 基于堆的优先队列
 * Created by ltj on 2019/3/25
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0; //存储于pq[1..N]中，pq[0]没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 插入元素
     * 将新元素加到数组末尾，增加堆的大小并让新元素上浮到合适位置
     * @param v
     */
    public void insert(Key v){
         pq[++N] = v;
         sink(N);
    }

    /**
     * 删除最大元素
     * 从数组顶端删去最大元素并将数组的最后一个元素放到顶端，
     * 减小堆的大小并让这个元素下沉到合适的位置
     * @return
     */
    public Key delMax(){
        Key max = pq[1]; //从跟结点得到最大元素
        exch(1, N--); //将其和最后一个结点交换
        pq[N+1] = null; //防止对象游离
        sink(1); //恢复堆的有序性
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k){
        while(2*k<=N){
            int j = 2*k;
            if(j<N && less(j, j+1)){
                j++;//子节点中较大者
            }
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}

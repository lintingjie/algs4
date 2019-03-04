package com.ltj.chapter3.symbolTables;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ltj on 2019/3/4
 * 无序数组实现符号表
 */
public class ArrayST<K,V> {
    private static final int INIT_CAPACITY = 2;
    private K[] keys;
    private V[] vals;
    private int n;

    public ArrayST(){
        this.keys = (K[]) new Object[INIT_CAPACITY];
        this.vals = (V[]) new Object[INIT_CAPACITY];
    }

    private void resize(int capacity){
        assert capacity >= n;
        K[] tempKeys = (K[]) new Object[capacity];
        V[] tempVals = (V[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempKeys[i] = keys[i];
            tempVals[i] = vals[i];
        }
        keys = tempKeys;
        vals = tempVals;
    }

    public void put(K key, V val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        if (n == keys.length) resize(2*keys.length);
        if(contains(key)){
            int i = rank(key);
            vals[i]=val;
        }{
            keys[n]=key;
            vals[n]=val;
        }
        n++;
    }

    public void putStd(K key, V val) {

        // to deal with duplicates
        delete(key);

        // double size of arrays if necessary
        if (n >= vals.length) resize(2*n);

        // add new key and value at the end of array
        vals[n] = val;
        keys[n] = key;
        n++;
    }


    public V get(K key){
        if (key == null) throw new IllegalArgumentException("key is null");
        if (isEmpty()) return null;
        for (int i = 0; i < n; i++) {
            if(key.equals(keys[i])){
                return vals[i];
            }
        }
        return null;
    }

    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (isEmpty()) return;
        for (int i = 0; i < n; i++) {
            if(key.equals(keys[i])){
                keys[i] = keys[n-1];
                vals[i] = vals[n-1];
                keys[n-1] = null;
                vals[n-1] = null;
                n--;
                if(n>0 && n == keys.length/4) resize(keys.length/2);
                return;
            }
        }
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public int size() {
        return n;
    }

    private int rank(K key) {
        if(key == null) throw new IllegalArgumentException("key is null");
        for (int i = 0; i < n; i++) {
            if(key.equals(keys[i])){
                return i;
            }
        }
        throw new IllegalArgumentException("key not exist");
    }

    public boolean contains(K key){
        if(key == null) return false;
        for (int i = 0; i < n; i++) {
            if(key.equals(keys[i])){
                return true;
            }
        }
        return false;
    }

    public Queue<K> keys() {
        Queue<K> queue = new Queue<K>();
        for (int i = 0; i < n; i++)
            queue.enqueue(keys[i]);
        return queue;
    }

    public static void main(String[] args) {
        ArrayST<String,Integer> st = new ArrayST<>();
        st.put("a",1);
        st.put("b",2);
        st.put("c",3);
        st.put("d",3);
        st.put("e",3);
        st.put("f",3);
        st.put("g",3);
        st.delete("a");
        System.out.println(st.n);
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }


}

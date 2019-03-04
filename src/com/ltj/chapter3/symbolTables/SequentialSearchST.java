package com.ltj.chapter3.symbolTables;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ltj on 2019/3/3
 * <p>
 * 顺序查找（基于无序链表）
 */
public class SequentialSearchST<K, V> {
    private Node first;
    private int n;

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V get(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    public int size() {
        return n;
    }

    public Iterable<K> keys() {
        List<K> keys = new ArrayList<>();
        for (Node x = first; x != null; x = x.next) {
            keys.add(x.key);
        }
        return keys;
    }

    /**
     * 错误写法
     * 并没有将值赋值给first
     * @param key
     */
    public void delete(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x = x.next;
                n--;
            }
        }
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void deleteStd(K key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, K key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }


    /**
     * Unit tests the {@code SequentialSearchST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        st.delete("b");
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }


}

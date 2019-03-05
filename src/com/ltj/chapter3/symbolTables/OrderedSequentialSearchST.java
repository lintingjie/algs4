package com.ltj.chapter3.symbolTables;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by ltj on 2019/3/4
 * 有序链表实现有序符号表
 */
public class OrderedSequentialSearchST<K extends Comparable<K>, V> {

    private Node first;
    private int n = 0;

    private class Node {
        K key;
        V val;
        Node next;

        public Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }

    /**
     * key从小到大
     *
     * @param key
     * @param val
     */
    public void put(K key, V val) {
        if (key == null) return;
        if (val == null) {
            delete(key);
            return;
        }
        //第一个节点（最小）
        if (first == null || key.compareTo(first.key) < 0) {
            first = new Node(key, val, first);
            n++;
            return;
        }

        for (Node x = first; x != null && key.compareTo(x.key) >= 0; x = x.next) {
            if (key.compareTo(x.key) == 0) {
                x.val = val;
                return;
            }
            //最后一个节点或者key大于当前节点小于下一节点
            if (x.next == null || key.compareTo(x.next.key) < 0) {
                x.next = new Node(key, val, x.next);
                n++;
                return;
            }
        }
    }

    public V get(K key) {
        if (key == null || first == null) return null;
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) == 0) {
                return x.val;
            }
        }
        return null;
    }

    /**
     * 递归实现删除
     *
     * @param key
     */
    public void deleteRecusive(K key) {
        if (key == null) return;
        first = deleteRecusive(key, first);
    }

    private Node deleteRecusive(K key, Node x) {
        if (x == null) return null;
        if (key.compareTo(x.key) == 0) {
            n--;
            return x.next;
        }
        x.next = deleteRecusive(key, x.next);
        return x;
    }

    /**
     * 迭代实现删除
     *
     * @param key
     */
    public void delete(K key) {
        if (key == null || first == null) return;
        //删除的是第一个节点
        if (key.compareTo(first.key) == 0) {
            first = first.next;
            n--;
            return;
        }
        Node prev = first;
        for (Node x = first; x != null; prev = x, x = x.next) {
            if (key.compareTo(x.key) == 0) {
                prev.next = prev.next.next;
                n--;
                return;
            }
        }

    }

    public boolean contains(K key) {
        if (key == null || first == null) return false;
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    /**
     * 最小的键
     *
     * @return
     */
    public K min() {
        return first == null ? null : first.key;
    }

    /**
     * 最大的键
     *
     * @return
     */
    public K max() {
        for (Node x = first; x != null; x = x.next) {
            if (x.next == null) {
                return x.key;
            }
        }
        return null;
    }

    /**
     * 删除最小的键
     */
    public void deleteMin() {
        if (first == null) return;
        first = first.next;
        n--;
    }

    /**
     * 删除最大的键
     */
    public void deleteMax() {
        if (first == null) return;
        Node prev = first;
        for (Node x = first; x != null; prev = x, x = x.next) {
            if (x.next == null) {
                prev.next = prev.next.next;
                n--;
                return;
            }
        }
    }

    /**
     * 小于key的键的数量
     *
     * @param key
     * @return
     */
    public int rank(K key) {
        if (first == null) return 0;
        int i = 0;
        for (Node x = first; x != null && key.compareTo(x.key) > 0; x = x.next) {
            i++;
        }
        return i;
    }

    public K select(int i) {
        if (first == null || i < 0 || i >= n) return null;
        Node x = first;
        for (int j = 0; j < i; j++) {
            x = x.next;
        }
        return x.key;
    }

    /**
     * 小于等于key的最大键
     *
     * @param key
     * @return
     */
    public K floor(K key) {
        if (key == null) return null;
        K result = null;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) <= 0) {
                result = x.key;
            }
        }
        return result;
    }

    /**
     * 大于等于key的最小值
     *
     * @param key
     * @return
     */
    public K ceiling(K key) {
        if (key == null) return null;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) >= 0) {
                return x.key;
            }
        }
        return null;
    }


    public Iterable<K> keys() {
        Queue<K> q = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            q.enqueue(x.key);
        }
        return q;
    }

    public static void main(String[] args) {
        OrderedSequentialSearchST<String, Integer> st = new OrderedSequentialSearchST<>();
        st.put("b", 1);
        st.put("c", 2);
        st.put("a", 2);
        st.put("d", 2);
        st.put("e", 2);
        st.put("f", 2);
        st.delete("b");
//        st.deleteMin();
//        st.deleteMax();
        System.out.println(st.rank("f"));
        System.out.println("contains('a'):" + st.contains("a"));
        System.out.println("contains('d'):" + st.contains("d"));
        System.out.println("isEmpty:" + st.isEmpty());
        System.out.println("size:" + st.size());
        System.out.println("min key:" + st.min());
        System.out.println("max key:" + st.max());
        System.out.println("floor A:" + st.floor("A"));
        System.out.println("floor b:" + st.floor("b"));
        System.out.println("floor c:" + st.floor("c"));
        System.out.println("floor f:" + st.floor("f"));
        System.out.println("floor g:" + st.floor("g"));
        System.out.println("ceiling A:" + st.ceiling("A"));
        System.out.println("ceiling b:" + st.ceiling("b"));
        System.out.println("ceiling c:" + st.ceiling("c"));
        System.out.println("ceiling f:" + st.ceiling("f"));
        System.out.println("ceiling g:" + st.ceiling("g"));

        System.out.println("rank a:" + st.rank("a"));
        System.out.println("rank c:" + st.rank("c"));
        System.out.println("rank f:" + st.rank("f"));
        System.out.println("select -1:" + st.select(-1));
        System.out.println("select 0:" + st.select(0));
        System.out.println("select 1:" + st.select(1));
        System.out.println("select 5:" + st.select(5));
        System.out.println("select 6:" + st.select(6));
        for (String key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
    }


}

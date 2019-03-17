package com.ltj.chapter1.s2_bag_queue_stack;

import java.util.Iterator;

/**
 * 环形链表实现Queue
 * Created by ltj on 2019/3/10
 */
public class CircleLinkedQueue<Item> implements Iterable<Item> {
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        //压入队尾
        if (last == null) {
            last = new Node();
            last.item = item;
            last.next = last;
        } else {
            Node first = last.next;
            Node preLast = last;
            last = new Node();
            last.item = item;
            last.next = first;
            preLast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        //弹出队首
        if (n == 0) return null;
        Node first = last.next;
        Item item = first.item;
        last.next = first.next;
        first = null;
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node x = last;
        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            Item item = x.next.item;
            x = x.next;
            i--;
            return item;
        }
    }

    public static void main(String[] args) {
        CircleLinkedQueue<String> queue = new CircleLinkedQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }


}

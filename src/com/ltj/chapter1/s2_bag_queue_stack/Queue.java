package com.ltj.chapter1.s2_bag_queue_stack;

import java.util.Iterator;

/**
 * Created by ltj on 2019/3/8
 * 先进先出队列
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        private Item item;
        private Node next;
    }

    public void enqueue(Item item){
        //向表尾添加元素
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()){
            first = last;
        }else {
            oldLast.next=last;
        }
        N++;
    }

    public Item dequeue(){
        //从表头删除元素
        Item item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        N--;
        return item;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator(){

        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        @Override
        public void remove() {
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        for(String s : queue){
            System.out.println(s);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

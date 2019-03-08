package com.ltj.chapter1.b_bagQueueStack;

import java.util.Iterator;

/**
 * Created by ltj on 2019/3/9
 * 背包
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        private Item item;
        private Node next;
    }

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<Item> {
        Node current = first;
        @Override
        public boolean hasNext() {
            return first == null;
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
}

package com.ltj.chapter1.b_bagQueueStack;

import java.util.Iterator;

/**
 * Created by ltj on 2019/3/8
 * 下压堆栈（链表实现）
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;

        Node(){}

        Node(Node x) {
            this.item = x.item;
            this.next = x.next;
        }
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public Stack(Stack t) {
        if (t.first != null) {
            first = new Node(t.first);
            for (Node x = first; x.next != null; x = x.next) {
                first.next = new Node(x.next);
            }
        }
    }

    public void push(Item item) {
        //向栈顶添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        //从栈顶删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) return null;
        return first.item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Iterator<Item> iterator() {

        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
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
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}

package com.ltj.chapter1.s2_bag_queue_stack;

import java.util.Iterator;

/**
 * 数组实现队列
 *
 * Created by ltj on 2019/3/10
 */
public class ResizingArrayQueueOfStrings implements Iterable<String>{

    private String[] a;
    private int n;

    public ResizingArrayQueueOfStrings(){
        a = new String[8];
        n = 0;
    }

    public void enqueue(String s){
        if(a.length==n) resize(2*n);
        //存到队尾
        a[n++] = s;
    }

    public String dequeue(){
        //从队首取出，其他元素向前移动一位
        String item = a[0];
        for (int i = 0; i < n-1; i++) {
            a[i] = a[i+1];
        }
        a[n-1] = null;
        if(n>0 && n==a.length/4) resize(a.length/2);
        return item;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }



    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * 返回最早添加到队列的元素
     * @return
     */
    private String peek(){
        return a[0];
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<String> {
        int i = 0;
        @Override
        public boolean hasNext() {
            return i<n;
        }

        @Override
        public String next() {
            return a[i++];
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        for (String s: queue){
            System.out.println(s);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

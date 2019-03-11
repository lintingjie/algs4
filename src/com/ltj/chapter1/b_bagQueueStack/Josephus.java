package com.ltj.chapter1.b_bagQueueStack;

/**
 * 1.初始化队列
 * 2.M位之前的移到队尾
 * 2.第M个s时出列
 * 3.循环
 *
 * Created by ltj on 2019/3/11
 */
public class Josephus {

    public static void josephus(int N, int M){
        Queue<Integer> queue = new Queue<>();
        for (int i = 1; i <= N; i++) {
            queue.enqueue(i);
        }
        int n = 1;
        while(!queue.isEmpty()){
            if(n==M){
                n=1;//从当前位置重新开始循环
                System.out.print(queue.dequeue()+" ");
            }else{
                queue.enqueue(queue.dequeue());
                n++;
            }
        }
    }

    public static void main(String[] args) {
        josephus(7,2);
    }
}

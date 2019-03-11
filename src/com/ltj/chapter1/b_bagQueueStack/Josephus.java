package com.ltj.chapter1.b_bagQueueStack;

/**
 * 约瑟夫问题：
 * 现有T个人围成一桌坐下，编号从1到N，从编号为1的人开始报数。
 * 报数也从1开始，报到M的人离席，从离席者的下一位在座成员开始，继续从1开始报数。
 * 复现这个过程（各成员的离席次序），或者求最后一个在座的成员编号。
 *
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

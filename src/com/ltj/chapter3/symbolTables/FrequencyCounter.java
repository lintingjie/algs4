package com.ltj.chapter3.symbolTables;/**
 * @description
 * @auther lintingjie
 * @date 2019/3/3 0:34
 */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ltj on 2019/3/3
 */
public class FrequencyCounter {
    public static void main(String[] args) {
        int minlen = 20;
        ST<String, Integer> st = new ST<>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen) continue;
            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }
        String max = "";
        int maxVal = 0;
        st.put(max, maxVal);
        Queue<String> queue = new Queue<>();
        queue.enqueue(max);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
                queue = new Queue<>();
                queue.enqueue(word);
            }else if(st.get(word) == st.get(max)){
                queue.enqueue(word);
            }
        }
        for(String key : queue){
            StdOut.println(key + " " + st.get(key));
        }

    }
}

package com.ltj;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();
        st.put("a",1);
        st.put("b",1);
        st.put("d",1);
        ST test = st;
        test.put("cc",1);
        for (String s : st.keys()){
            StdOut.println(s +" "+st.get(s));
        }
    }
}

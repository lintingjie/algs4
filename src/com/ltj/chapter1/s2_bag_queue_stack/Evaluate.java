package com.ltj.chapter1.s2_bag_queue_stack;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * Created by ltj on 2019/3/7
 * Dijkstra的双栈算术表达式求值算法:
 * 1.将操作数压入操作数栈
 * 2.将运算符压入运算符栈
 * 3.忽略左括号
 * 4.在遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("(")){
                continue;
            } else if("+".equals(s)||"-".equals(s)||"*".equals(s)||"/".equals(s)||"sqrt".equals(s)){
                ops.push(s);
            } else if(")".equals(s)){
                String op = ops.pop();
                Double v = vals.pop();
                if("+".equals(op)){
                    v = vals.pop() + v;
                }else if("-".equals(op)){
                    v = vals.pop() - v;
                }else if("*".equals(op)){
                    v = vals.pop() * v;
                }else if("/".equals(op)){
                    v = vals.pop() / v;
                }else if("sqrt".equals(op)){
                    v = Math.sqrt(v);
                }
                vals.push(v);
            }else{
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }

}

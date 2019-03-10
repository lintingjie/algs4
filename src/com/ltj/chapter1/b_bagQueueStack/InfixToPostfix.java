package com.ltj.chapter1.b_bagQueueStack;


/**
 * 中序表达式转为后序表达式
 *
 * 1.将中序表达式所有括号补全
 * 2.如果是数值直接输出
 * 3.如果是操作符压入栈
 * 4.如果是左括号，continue
 * 5.如果是右括号，取栈顶操作符输出
 *
 *
 * Created by ltj on 2019/3/10
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        //todo 中序表达式忽略的括号补全，比如2+3*4/(5+6) 为 (2+((3*4)/(5+6)))
        System.out.println(infixToPostfix("(2+((3*4)/(5+6)))"));

    }

    public static String infixToPostfix(String infix){
        Stack<String> ops = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (String s : infix.trim().split("")) {
            if      (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")")) result.append(ops.pop());
            else if (s.equals("(")) continue;
            else                    result.append(s);
        }
        return result.toString();
    }


}

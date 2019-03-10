package com.ltj.chapter1.b_bagQueueStack;

/**
 * 后序表达式求值
 *
 * 从左至右扫描表达式，
 * 遇到数字时，将数字压入堆栈，
 * 遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次栈顶元素 op 栈顶元素），并将结果入栈；
 * 重复上述过程直到表达式最右端，
 * 最后运算得出的值即为表达式的结果。
 *
 * Created by ltj on 2019/3/10
 */
public class PostfixValue {

    public static void main(String[] args) {
        System.out.println(getPostfixValue("34+5*6-"));//(3+4)*5-6

    }

    public static Integer getPostfixValue(String expr){
        Stack<Integer> vals = new Stack<>();
        for(String s: expr.trim().split("")){
            if(s.equals("+")){
                Integer val = vals.pop() + vals.pop();
                vals.push(val);
            }else if(s.equals("-")){
                Integer val1 = vals.pop();
                Integer val2 = vals.pop();
                Integer val = val2 - val1;
                vals.push(val);
            }else if(s.equals("*")){
                Integer val1 = vals.pop();
                Integer val2 = vals.pop();
                Integer val = val2 * val1;
                vals.push(val);
            }else if(s.equals("/")){
                Integer val1 = vals.pop();
                Integer val2 = vals.pop();
                Integer val = val2 / val1;
                vals.push(val);
            }else{
                vals.push(Integer.parseInt(s));
            }
        }
        return vals.pop();
    }
}

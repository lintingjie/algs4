package com.ltj.chapter1.s2_bag_queue_stack;


/**
 * 补全左括号
 * 0.遍历输入字符串
 * 1.不是右括号：如果是值vals.push(),是操作符ops.push()
 * 2.是右括号:"("+vals.pop()+ops.pop()+vals.pop()+")",然后整个结果vals.push()
 * 3.循环1、2步骤直到遍历结束
 * 4.vals.pop()即最后结果
 *
 * Created by ltj on 2019/3/9
 */
public class InfixAddLeftBracket {

    private static final String LEFT_PAREN = "(";
    private static final String RIGHT_PAREN = ")";

    public static String addLeftBracket(String input) {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        String val = "";//拼接数值
        for (String s : input.trim().split("")) {
            if(s.equals(RIGHT_PAREN)){
                if(!val.equals("")){
                    vals.push(val);
                    val = "";
                }
                String val1 = vals.pop();
                String val2 = vals.pop();
                String result = LEFT_PAREN + val2 + ops.pop() + val1 + RIGHT_PAREN;
                vals.push(result);
            }else if(s.equals(LEFT_PAREN)){
                continue;
            } else if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                if(!val.equals("")){
                    vals.push(val);
                    val = "";
                }
                ops.push(s);
            }else{
                val += s;
            }
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        String str1 = "1+2)*3-4)*5-6)))";
        String str2 = "11+2.1)*3-4)*5-6)))";
        System.out.println(addLeftBracket(str1));
        System.out.println(addLeftBracket(str2));
    }
}

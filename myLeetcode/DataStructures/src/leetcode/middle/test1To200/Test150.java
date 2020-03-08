package leetcode.middle.test1To200;

import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-03-08
 * @time 15:49
 **/
public class Test150 {
    public static void main(String[] args) {
        int i = evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(i);
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <tokens.length ; i++) {
            if (isNumber(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = calculate(num1, num2, tokens[i]);
                stack.push(res);
            }
        }
        return stack.peek();
    }

    public static boolean isNumber(String str){
        return !(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"));
    }
    public static int  calculate(int num1, int num2, String param){
        if (param.equals("+"))return num1+num2;
        if (param.equals("-"))return num1-num2;
        if (param.equals("*"))return num1*num2;
        if (param.equals("/"))return num1/num2;
        return 0;
    }
}

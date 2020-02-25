package dataStructures.myStack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式计算器
 * @author zhuliyang
 * @date 2019-12-11
 * @time 19:43
 **/
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "4 2 2 2 + 3 + 2 + 4 * + +";
        List<String> list = getListString(suffixExpression);
        System.out.println(calculator(getListString(suffixExpression)));
    }
    //字符串转list<String>
    private static List<String> getListString(String str) {
        String[] strArr = str.split(" ");
        return Arrays.asList(strArr);
    }

    //对逆波兰表达式进行计算的方法
    private static int calculator(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {//匹配0~9的数字
                stack.push(item);
            } else {//如果是计算符号 就先取出栈中的两个数字 然后进行计算 把计算结果放入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = doCal(num1, num2, item);
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.peek());
    }

    //对参数进行 +，-，*，/ ，的方法
    private static int doCal(int num1, int num2, String oper) {
        if (oper.equals("+")) {
            return num1 + num2;
        } else if (oper.equals("-")) {
            return num1 - num2;
        } else if (oper.equals("*")) {
            return num1 * num2;
        } else if (oper.equals("/")) {
            return num1 / num2;
        } else {
            throw new RuntimeException("符号错误");
        }
    }
}

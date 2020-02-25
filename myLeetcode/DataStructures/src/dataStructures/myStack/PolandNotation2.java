package dataStructures.myStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 *
 * @author zhuliyang
 * @date 2019-12-12
 * @time 21:41
 **/
public class PolandNotation2 {
    public static void main(String[] args) {
        String suffixExpression = "4 * ( 2 + ( 2 * 2 * 3 + 2 ) * 4 )";
        List<String> list = polandNotation(getListString(suffixExpression));
        System.out.println(list);
    }

    //字符串转list<String>
    private static List<String> getListString(String str) {
        String[] strArr = str.split(" ");
        return Arrays.asList(strArr);
    }

    //将中缀表达式的list转换为后缀表达式的list
    private static List<String> polandNotation(List<String> list) {
        Stack<String> operStack = new Stack<>();
        List<String> numList = new ArrayList<>();
        for (String item : list) {
            if (!item.matches("\\d+")) {//如果不是数字
                if (!operStack.isEmpty()) {//符号栈非空
                    //当前符号不是括号 并且 栈顶元素的优先级比当前元素优先级大
                    if (priority(item) != -1 && priority(operStack.peek()) >= priority(item)) {
                        String pop = operStack.pop();
                        numList.add(pop);//大的符号放入数字栈
                        operStack.push(item);//当前符号放入符号栈
                    } else {
                        if (")".equals(item)) {//遇到了右括号 就消除括号 并且把里面的运算符放到数字list
                            while (!operStack.peek().equals("(")) {
                                String oper = operStack.pop();//运算符
                                numList.add(oper);//符号放入数字栈
                            }
                            operStack.pop();//弹出左括号
                        }else {
                            operStack.push(item);
                        }
                    }
                } else {//如果为空 放入符号栈
                    operStack.push(item);
                }
            } else {//如果是数字的话 放入数字栈
                numList.add(item);
            }
        }
        numList.add(operStack.pop());//把符号栈中最后一个符号放入数字list
        return numList;
    }

    //判断运算符优先级
    public static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/")) {
            return 1;
        } else if (oper.equals("-") || oper.equals("+")) {
            return 0;
        } else { //括号
            return -1;
        }
    }

}

package leetcode.middle.test201To400;

import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-03-19
 * @time 13:01
 **/
public class Test227 {
    public static void main(String[] args) {
        int calculate = calculate("-1+-2+-3*2");
        System.out.println(calculate);
    }
    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == ' ') continue;

            if(Character.isDigit(arr[i])){
                int tempNum = arr[i] - '0';
                while(++i < arr.length && Character.isDigit(arr[i])){
                    tempNum = tempNum * 10 + (arr[i] - '0');
                } i--;

                if(lastOp == '+') numStack.push(tempNum);
                else if(lastOp == '-') numStack.push(-tempNum);
                else numStack.push(res(lastOp, numStack.pop(), tempNum));
            } else lastOp = arr[i];
        }

        int ans = 0;
        for(int num : numStack) ans += num;
        return ans;
    }

    private static int res(char op, int a, int b){
        if(op == '*') return a * b;
        else if(op == '/') return a / b;
        else if(op == '+') return a + b; //其实加减运算可以忽略
        else return a - b;
    }

}

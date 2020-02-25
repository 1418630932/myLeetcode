package dataStructures.myStack;

/**
 * @author zhuliyang
 * @date 2019-12-09
 * @time 16:31
 **/
public class Calculator {
    public static void main(String[] args) {
        String expression = "5-2*3+1";
        ArrayStack2 numStack = new ArrayStack2(10);//数字栈
        ArrayStack2 operStack = new ArrayStack2(10);//操作符栈
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (operStack.isOper(ch)) {//是否是符号
                if (!operStack.isEmpty()) {//符号栈非空
                    //如果当前运算符栈的运算符优先级小于等于栈顶元素优先级
                    //先计算前一个运算符结果 然后把结果放入数栈 当前运算符放入运算符栈
                    if (operStack.priority(ch) <= operStack.priority((char) operStack.peak())) {
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        char oper = (char) operStack.pop().intValue();
                        int res = operStack.cal(num1, num2, oper);//进行计算结果
                        numStack.push(res);//结果放入数栈
                        operStack.push(ch);//运算符入栈
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);//运算符入栈
                }
            } else {//插入数字
                int num = ch-48;
                //当数字是多位数时 从数字的第一位开始遍历到最后一位
                while (i+1<=expression.length()-1&&(expression.charAt(i+1)>=48&&expression.charAt(i+1)<=57)){
                    int temp = expression.charAt(i+1)-48;
                    num= num*10+temp;
                    i++;//指针后移一位
                }
                numStack.push(num); //数字入栈
            }
        }
        //如果运算符栈种没有东西 表示计算已经完成
        while (!operStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char oper = (char) operStack.pop().intValue();
            int res = operStack.cal(num1, num2, oper);//进行计算结果
            numStack.push(res);
        }
        System.out.println(expression+"="+numStack.peak());
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //返回栈顶元素
    public int peak() {
        return stack[top];
    }

    //入栈
    public void push(int i) {
        //表示栈已满
        if (top == maxSize - 1) {
            System.out.println("栈已满");
            return;
        }
        stack[++top] = i;
    }

    //出栈
    public Integer pop() {
        //表示栈已空
        if (top == -1) {
            System.out.println("栈已空");
            return null;
        }
        return stack[top--];
    }

    //判断优先级
    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else { //数字
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    //进行计算
    public int cal(int num1, int num2, char oper) {
        int res = 0;
        if (oper == '+') {
            res = num2 + num1;
        } else if (oper == '-') {
            res = num2 - num1;
        } else if (oper == '*') {
            res = num2 * num1;
        } else {
            res = num2 / num1;
        }
        return res;
    }
}
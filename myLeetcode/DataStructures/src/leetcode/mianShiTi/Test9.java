package leetcode.mianShiTi;

import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-04-02
 * @time 12:42
 **/
public class Test9 {

}
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()&&stack2.isEmpty())return -1;
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

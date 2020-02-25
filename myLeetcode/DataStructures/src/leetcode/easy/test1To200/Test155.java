package leetcode.easy.test1To200;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-02-06
 * @time 14:50
 **/
public class Test155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());  // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());     // --> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.

    }
    static class MinStack {
        Stack<Integer> stack ;
        PriorityQueue<Integer> queue ;
        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new Stack<>();
            this.queue = new PriorityQueue();
        }

        public void push(int x) {
            stack.push(x);
            this.queue.add(x);
        }

        public void pop() {
            Integer pop = stack.pop();
            this.queue.remove(pop);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return queue.peek();
        }
    }

}

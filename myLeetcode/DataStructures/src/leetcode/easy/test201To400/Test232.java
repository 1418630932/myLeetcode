package leetcode.easy.test201To400;

import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 16:34
 **/
public class Test232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.pop();
        System.out.println(myQueue.empty());
    }

    static class MyQueue {
        int front;
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (stack1.isEmpty()) {
                front = x;
            }
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();

        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack2.isEmpty()?front:stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty()&&stack2.isEmpty();
        }
    }

}

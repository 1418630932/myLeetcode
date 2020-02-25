package leetcode.easy.test201To400;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 15:24
 **/
public class Test225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        myStack.empty();
    }
    static class MyStack {
        Deque<Integer> deque ;
        /** Initialize your data structure here. */
        public MyStack() {
            this.deque= new ArrayDeque();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            deque.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return deque.removeLast();
        }

        /** Get the top element. */
        public int top() {
            return deque.getLast();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return deque.isEmpty();
        }
    }
}

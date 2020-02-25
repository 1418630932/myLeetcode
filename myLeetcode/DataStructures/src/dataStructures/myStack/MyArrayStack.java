package dataStructures.myStack;

/**
 * @author zhuliyang
 * @date 2019-12-08
 * @time 23:59
 **/
public class MyArrayStack {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(11);
        arrayStack.push(111);
        arrayStack.push(111);
        arrayStack.push(1111);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public void push(int i) {
        //表示栈已满
        if (top == maxSize - 1) {
            System.out.println("栈已满");
            return;
        }
        stack[++top] = i;
    }

    public Integer pop() {
        //表示栈已空
        if (top == -1) {
            System.out.println("栈已空");
            return null;
        }
        return stack[top--];
    }
}



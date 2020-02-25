package dataStructures.myQueue;

import java.util.Arrays;
/**
 * @author zhuliyang
 * @date 2019-12-01
 * @time 23:23
 **/
public class ArrayQueueDemo {
    private int head;//头部指针
    private int tail;//尾部指针 
    private int maxSize;//最大长度
    private int[] arr; //数组

    //构造方法
    public ArrayQueueDemo(int maxSize){
        this.maxSize=maxSize+1;
        arr=new int[maxSize+1];//预留一个空间 用来存放队尾指针
    }
    //往队列尾添加元素
    public void put(int i){
        if (isFull()){
            throw new RuntimeException("元素队列满了");
        }
        arr[tail]=i; //赋值
        tail=++tail%maxSize;//指针+1 如果超过了上限就从0开始
    }
    //往队列头取元素
    public int get(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int res =arr[head];//赋值
        arr[head]=0;
        head=++head%maxSize;//指针+1 如果超过了上限就从0开始
        return res;
    }
    //判断队列元素是否充满
    private boolean isFull(){
        return (tail+maxSize-head)%maxSize==maxSize-1; //考虑到了tail 比head小的情况
    }
    private boolean isEmpty(){
        return head==tail;
    }

    public void print(){
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        ArrayQueueDemo arrayQueueDemo = new ArrayQueueDemo(3);
        arrayQueueDemo.put(1);
        arrayQueueDemo.put(2);
        arrayQueueDemo.put(3);
//        arrayQueueDemo.put(4);
        arrayQueueDemo.get();
        arrayQueueDemo.get();
        arrayQueueDemo.get();
//        arrayQueueDemo.get();
        arrayQueueDemo.put(1);
        arrayQueueDemo.put(2);
        arrayQueueDemo.put(3);
        arrayQueueDemo.get();
        arrayQueueDemo.get();
        arrayQueueDemo.get();
        arrayQueueDemo.print();
    }
}

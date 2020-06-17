package leetcode.middle.test601To800;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-06-11
 * @time 0:31
 **/
public class Test739 {
    public static void main(String[] args) {
        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int i = 1; i < T.length; i++) {
            //保证递减
            if (T[i] > T[queue.peek()]) {
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    res[poll] = i - poll;
                }
            }
            while (!queue.isEmpty()&&T[queue.getLast()] < T[i]) {
                Integer last = queue.removeLast();
               res[last] = i-last;
            }
            queue.add(i);
        }
        while (!queue.isEmpty()){
           int poll =  queue.poll();
            res[poll] = 0;
        }
        return res;
    }
}

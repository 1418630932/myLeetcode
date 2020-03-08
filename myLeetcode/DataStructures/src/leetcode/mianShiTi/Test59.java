package leetcode.mianShiTi;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-07
 * @time 17:31
 **/
public class Test59 {
    static class MaxQueue {
        Queue<Integer> queue ;
        int max;
        public MaxQueue() {
            queue = new LinkedList();
        }

        public int max_value() {
            return queue.isEmpty()?-1:max;
        }

        public void push_back(int value) {
            max = Math.max(max, value);
            queue.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()){
               return max = -1;
            }
            Integer poll = queue.poll();
            max = -1;
            for (Integer integer : queue) {
                max = Math.max(integer,max );
            }
            return poll;
        }
    }
}

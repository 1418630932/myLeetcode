package leetcode.mianShiTi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-04-18
 * @time 16:55
 **/
public class Test_jinsai2 {
    public static void main(String[] args) {
        System.out.println(numWays(3, new int[][]{{0,2},{2,1}}, 2));
    }
    public  static int numWays(int n, int[][] relation, int k) {
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(relation[0][1]);
        while (depth < k-1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j = 0; j < relation.length; j++) {
                    if (relation[j][0] == poll) {
                        queue.add(relation[j][1]);
                    }
                }
            }
            depth++;
        }
        int count =0;
        for (Integer integer : queue) {
            if (integer==n-1)count++;
        }
        return count;
    }
}

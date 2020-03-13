package leetcode.middle.test201To400;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-13
 * @time 20:19
 **/
public class Test207 {
    public static void main(String[] args) {
        boolean b = canFinish(2, new int[][]{{0, 1}});
        System.out.println(b);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];//每门课有几门前置课
        ArrayList<Integer>[] listCanChose = new ArrayList[numCourses];//学了这门课之后可以另外学习的课
        for (int i = 0; i <numCourses ; i++) {
            listCanChose[i]=new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            count[prerequisite[0]]++;
            listCanChose[prerequisite[1]].add(prerequisite[0]);
        }
        //可以选择的课
        Queue<Integer> chose = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i]==0)chose.add(i);
        }
        while (!chose.isEmpty()){
            Integer poll = chose.poll();
            numCourses--;
            for (Integer integer : listCanChose[poll]) {
                count[integer]--;
                //如果某门课的前置课程没有了 就加入队列
                if (count[integer]==0)chose.add(integer);
            }
        }
        return numCourses==0;
    }
}

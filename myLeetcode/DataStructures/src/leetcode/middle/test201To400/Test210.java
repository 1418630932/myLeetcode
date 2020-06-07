package leetcode.middle.test201To400;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-03-14
 * @time 15:13
 **/
public class Test210 {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        int res = 1;
        for (int i = 0; i < 100000000; i++) {
            res &= i;
        }
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] choseThenCanStudy = new ArrayList[numCourses];
        for (int i = 0; i <choseThenCanStudy.length ; i++) {
            choseThenCanStudy[i]= new ArrayList<>();
        }
        int[] needTochoseCount = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            needTochoseCount[prerequisite[0]]++;
            choseThenCanStudy[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <needTochoseCount.length ; i++) {
            if (needTochoseCount[i]==0)queue.add(i);
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            res.add(poll);
            for (int i = 0; i <choseThenCanStudy[poll].size() ; i++) {
                int num = --needTochoseCount[choseThenCanStudy[poll].get(i)];
                if (num==0){
                    queue.add(choseThenCanStudy[poll].get(i));
                }
            }
        }
        int[] arr = new int[res.size()];
        int index = 0;
        for (Integer num : res) {
            arr[index++]=num;
        }
        return arr;
    }



}

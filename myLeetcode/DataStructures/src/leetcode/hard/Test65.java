package leetcode.hard;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-05-16
 * @time 13:33
 **/
public class Test65 {
//    public static void main(String[] args) {
//        System.out.println(isNumber("44e016912630333"));
//    }

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        int i = s.indexOf('e');
        String numberStr = i == -1 ? s : s.substring(0, i);
        if (numberStr.length()!=0 &&!isValidNumner(numberStr, i)) return false;
        if (i == -1) {
            return true;
        } else {
            String powStr = s.substring(i+1);
            if (powStr.length()==0)return false;
            return isValidPow(powStr);
        }
    }

    private static boolean isValidPow(String powStr) {
        if (powStr.charAt(0)==' ')return false;
        try {
            Long.parseLong(powStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isValidNumner(String numberStr, int i) {
        if (i != -1 && numberStr.charAt(numberStr.length() - 1) == ' ') return false;
        for (int j = numberStr.length()-1; j >=0 ; j--) {
            char c = numberStr.charAt(j);
            if (c==' '){
                continue;
            }else {
                if (c=='f'){
                    return false;
                }else {
                    break;
                }
            }
        }
        try {
            Double.parseDouble(numberStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] order = findOrder(2, new int[][]{{1, 0}});
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Set[] orders = new Set[numCourses];
        for (int i = 0; i < orders.length; i++) {
            orders[i]=new HashSet();
        }
        for (int[] prerequisite : prerequisites) {
            Set order = orders[prerequisite[0]];
            int lesson = prerequisite[1];
            order.add(lesson);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <orders.length ; i++) {
            if (orders[i].isEmpty())queue.add(i);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                res.add(poll);
                for (int j = 0; j < orders.length; j++) {
                    Set order = orders[j];
                    if (order.contains(poll)) {
                        order.remove(poll);
                        if (order.isEmpty()) queue.add(j);
                    }
                }
            }
        }
        return res.size()==numCourses?res.stream().mapToInt(Integer :: intValue).toArray():new int[0];
    }
}

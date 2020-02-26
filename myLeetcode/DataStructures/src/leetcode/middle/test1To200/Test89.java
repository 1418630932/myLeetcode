package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.List;

public class Test89 {
    public static void main(String[] args) {
        List<Integer> list = grayCode(3);
        System.out.println(list);
    }

    public static List<Integer> grayCode(int n) {
        int length = (int) Math.pow(2, n);
        boolean[] isVisited = new boolean[length];
        List<Integer> res = new LinkedList<>();
        helper(res, isVisited, n, 0);
        return res;
    }

    private static void helper(List<Integer> res, boolean[] isVisited, int n, int i) {
        if (!isVisited[i]) {
            isVisited[i] = true;
            res.add(i);
            for (int j = 0; j < n; j++) {
                int next = i ^ (1 << j);
                helper(res, isVisited, n, next);
            }
        }
    }

}

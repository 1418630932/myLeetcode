package leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-05-30
 * @time 14:18
 **/
public class Test84 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,2}));
    }
    public static int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length==0)return 0;
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <tmp.length ; i++) {
            while (!stack.isEmpty()&&tmp[i]<tmp[stack.peek()]){
                int h = tmp[stack.pop()];
                area = Math.max(area, (i-stack.peek()-1)*h);
            }
            stack.push(i);
        }
        return area;
    }
}

package leetcode.hard;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-04-04
 * @time 13:06
 **/
public class Test42 {
    public static void main(String[] args) {
        int trap = trap(new int[]{4, 2, 3});
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int area = 0;
        int hmax = 0; //当前数组的最高柱子的索引
        int tempArea = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[hmax]) {
                hmax = i;
                area += tempArea;
                tempArea = 0;
            } else {
                tempArea += height[hmax] - height[i];
            }
        }
        if (hmax != height.length - 1) {
            area += trapRes(height, hmax);
        }
        return area;
    }

    private static int trapRes(int[] height, int h) {
        int hmax = height.length - 1; //当前数组的最高柱子的索引
        int area = 0;
        int tempArea = 0;
        for (int i = height.length - 2; i >= h; i--) {
            if (height[i] >= height[hmax]) {
                hmax = i;
                area += tempArea;
                tempArea = 0;
            } else {
                tempArea += height[hmax] - height[i];
            }
        }
        return area;
    }
}

package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-18
 * @time 19:36
 **/
public class Test11 {
    //O(n2)
    public int maxArea(int[] height) {
        int max = Math.min(height[0], height[1]);
        for (int i = 2; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[j] >= height[i]) {
                    max = Math.max(max, height[i] * (i - j));
                    break;
                } else {
                    max = Math.max(max, Math.min(height[i], height[j]) * (i - j));
                }
            }
        }
        return max;
    }
    //O(n)
    public int maxArea1(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            //留高去矮
            if (height[left]>height[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }
}

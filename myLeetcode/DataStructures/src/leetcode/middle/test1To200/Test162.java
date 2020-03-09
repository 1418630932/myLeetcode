package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-03-09
 * @time 20:03
 **/
public class Test162 {
    public static void main(String[] args) {
        int peakElement = findPeakElement(new int[]{7,6,5,4,3,2,1});
        System.out.println(peakElement);
    }
    public static int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i<j){
            if (i<nums.length-1&&nums[i]>nums[i+1]){
                return i;
            }else {
                while (i<nums.length-1&&nums[i]<nums[i+1]){
                    i++;
                }
            }
            if (nums[j]>nums[j-1]){
                return j;
            }else {
                while (nums[j]<nums[j-1]){
                    j--;
                }
            }
        }
        return j;
    }
}
